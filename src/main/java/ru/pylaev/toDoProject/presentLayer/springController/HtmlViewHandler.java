package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.ui.Model;

import java.util.Arrays;

public class HtmlViewHandler {
    public static void updateModel(String content, Model model) {
        String[] arrStr = content.split("\n");
        String message = arrStr[arrStr.length-1];
        String[] tasks = Arrays.copyOfRange(arrStr, 0, arrStr.length-1);
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
    }
}
