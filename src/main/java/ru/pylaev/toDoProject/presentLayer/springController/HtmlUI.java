package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class HtmlUI extends UI {
    private final HtmlControllerLogic controllerLogic;

    @Autowired
    public HtmlUI(View view, UiStateModel uiStateModel, HtmlControllerLogic htmlControllerLogic) {
        super(view, uiStateModel);
        this.controllerLogic = htmlControllerLogic;
    }

    @GetMapping
    public String get(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", view.getMessage());
        map.put("tasks", view.getTasks());
        map.put("color", controllerLogic.getColor(view));
        model.addAllAttributes(map);
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        controllerLogic.processUserInput(userInput, uiStateModel);
        return "redirect:/";
    }
}


