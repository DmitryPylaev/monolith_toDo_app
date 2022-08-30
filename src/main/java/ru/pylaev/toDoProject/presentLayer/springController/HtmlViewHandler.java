package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.ui.Model;

import java.util.Map;

public class HtmlViewHandler {
    public static void updateModel(Map<String, Object> map, Model model) {
        for (Map.Entry<String, Object> entry:map.entrySet()) {
            model.addAttribute(entry.getKey(), entry.getValue());
        }
    }
}
