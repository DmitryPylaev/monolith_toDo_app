package ru.pylaev.toDoProject.presentLayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateService;
import ru.pylaev.toDoProject.presentLayer.BaseUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Controller
public class HtmlController extends BaseUI {

    @Autowired
    public HtmlController(UiState uiState, View view) {
        super(uiState, view);
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("view", view);
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        view.setTasks(UiStateService.processUserInput(userInput, uiState));
        view.setMessage(uiState.getStep().toString());
        return "redirect:/";
    }
}
