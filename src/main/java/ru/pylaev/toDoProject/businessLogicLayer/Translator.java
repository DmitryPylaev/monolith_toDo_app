package ru.pylaev.toDoProject.businessLogicLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.CustomHttpClient;

import java.util.HashMap;

@Component
public class Translator {
    public static String target = "en";
    public static String source = "ru";

    private static String key;

    @Autowired
    public Translator(@Value("${apiKey}") String k) {
        key = k;
    }

    public static String translate(String content) {
        var params = new HashMap<String, String>();
        params.put("q", content);
        params.put("target", target);
        params.put("source", source);

        var headers = new HashMap<String, String>();
        headers.put("content-type", "application/x-www-form-urlencoded");
        headers.put("Accept-Encoding", "application/gzip");
        headers.put("X-RapidAPI-Key", key);
        headers.put("X-RapidAPI-Host", "google-translate1.p.rapidapi.com");

        String result = CustomHttpClient.post("https://google-translate1.p.rapidapi.com/language/translate/v2", params, "data", headers);
        return result.substring(result.lastIndexOf(":")+2, result.lastIndexOf("\""));
    }
}
