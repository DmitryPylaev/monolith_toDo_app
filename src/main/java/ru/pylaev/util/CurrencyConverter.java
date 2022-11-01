package ru.pylaev.util;

import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.dataAccessLayer.network.CustomHttpClient;
@Component
@Setter
public class CurrencyConverter {
    private String url = "https://api.exchangerate.host/latest";
    private String[] params = new String[] {"base=USD", "symbols=RUB", "places=2"};
    private String jsonElementName = "rates";

    public String getPare() {
        return CustomHttpClient.get(url, params, jsonElementName);
    }
}
