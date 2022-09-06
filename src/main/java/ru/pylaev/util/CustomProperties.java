package ru.pylaev.util;

import java.util.PropertyResourceBundle;

public record CustomProperties(String fileName) {
    public String get(String property) {
        var properties = (PropertyResourceBundle) PropertyResourceBundle.getBundle(fileName);
        return properties.getString(property);
    }
}
