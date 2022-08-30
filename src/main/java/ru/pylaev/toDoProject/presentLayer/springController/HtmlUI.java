package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.SimpleControllerLogic;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.View;

@org.springframework.stereotype.Controller
public class HtmlUI extends UI {
    private final SimpleControllerLogic controllerLogic;

    @Autowired
    public HtmlUI(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        controllerLogic = new SimpleControllerLogic();
    }

    @GetMapping
    public String get(Model model) {
        HtmlViewHandler.updateModel(view.show(), model);
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        controllerLogic.processUserInput(userInput, uiStateModel);
        return "redirect:/";
    }
}


