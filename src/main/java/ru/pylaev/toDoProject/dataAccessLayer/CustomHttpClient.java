package ru.pylaev.toDoProject.dataAccessLayer;

import com.google.gson.JsonParser;
import ru.pylaev.toDoProject.ToDoMain;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CustomHttpClient {
    public static String get(String urlString, String[] params, String jsonElementName) {
        var urlResult = new StringBuilder(urlString);
        for (int i = 0; i < params.length; i++) {
            if (i==0) urlResult.append("?");
            else urlResult.append("&");
            urlResult.append(params[i]);
        }

        String result = "";
        try {
            var connection = (HttpURLConnection) new URL(urlResult.toString()).openConnection();
            result = getRequestString(connection, jsonElementName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ToDoMain.PROPERTIES.get("networkError"));
        }
        return result;
    }

    public static String post(String urlString, Map<String, String> params, String jsonElementName, Map<String, String> headers) {
        String result = "";
        try {
            var connection = (HttpURLConnection) new URL(urlString).openConnection();

            connection.setRequestMethod("POST");
            headers.forEach(connection::setRequestProperty);
            connection.setDoOutput(true);
            var out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(params));
            out.flush();
            out.close();

            result = getRequestString(connection, jsonElementName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ToDoMain.PROPERTIES.get("networkError"));
        }
        return result;
    }

    private static String getRequestString(HttpURLConnection connection, String jsonElementName) throws IOException {
        var jsonObj = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent())).getAsJsonObject();
        var jsonElement = jsonObj.get(jsonElementName);
        return jsonElement.toString();
    }
}
