package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.view.View;

@org.springframework.stereotype.Controller
public class HtmlController extends Controller {
    @Autowired
    public HtmlController(View view, UiStateModel uiStateModel) {
        super(view, uiStateModel);
    }

    @GetMapping
    public String get(Model model) {
        HtmlViewHandler.updateModel(view.show(), model);
        return "home";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        processingRequest(userInput);
        return "redirect:/";
    }
}


