package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.UI;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Map;

@org.springframework.stereotype.Controller
public class HtmlUI extends UI {
    private final HtmlControllerLogicDecorator controllerLogic;

    @Autowired
    public HtmlUI(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
        controllerLogic = new HtmlControllerLogicDecorator(new MainControllerLogic());
    }

    @GetMapping
    public String get(Model model) {
        Map<String, Object> map = controllerLogic.getParam(view);
        String color = controllerLogic.getColor(view);
        map.put("color", color);
        HtmlViewHandler.updateModel(map, model);
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        controllerLogic.processUserInput(userInput, uiStateModel);
        return "redirect:/";
    }
}


