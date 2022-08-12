package ru.pylaev.toDoProject.presentLayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.runnableUi.CustomPrinter;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Arrays;

@Controller
public class HtmlController extends BaseUI {
    private Model model;

    @Autowired
    public HtmlController(View view, UiState uiState) {
        super(view, uiState);
        view.setPrinter(new HtmlPrinter());
    }

    @GetMapping
    public String get(Model model) {
        this.model = model;
        view.show();
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        processingRequest(userInput);
        return "redirect:/";
    }

    private class HtmlPrinter implements CustomPrinter {
        public void display(String content) {
            String[] arrStr = content.split("\n");
            String message = arrStr[arrStr.length-1];
            String[] tasks = Arrays.copyOfRange(arrStr, 0, arrStr.length-1);
            model.addAttribute("message", message);
            model.addAttribute("tasks", tasks);
        }
    }
}


