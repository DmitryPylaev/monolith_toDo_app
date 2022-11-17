package ru.pylaev.toDoProject.presentLayer.controller.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.controller.BaseController;
import ru.pylaev.toDoProject.presentLayer.factories.BaseUiFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class HtmlController extends BaseController {
    public final static String MAIN_STYLE = "margin-left:120px;width:1295px;";
    private String alertStyle;

    @Autowired
    public HtmlController(@Qualifier("baseControllerFactory") BaseUiFactory factory) {
        super(factory);
    }

    @GetMapping
    public String get(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", viewHandler.getMessage());
        map.put("tasks", viewHandler.getArrTask());
        map.put("style", alertStyle);
        model.addAllAttributes(map);
        return "index";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        respondLogic.accept(userInput, uiStateModel);
        return "redirect:/";
    }

    @Override
    public void update(String message, List<Task> tasks) {
        alertStyle = getAlertStyle(viewHandler.getArrTask());
    }

    public static String getAlertStyle(String[] tasks) {
        String color = (tasks == null || tasks.length<1)?"alertColor":"mainColor";
        return MAIN_STYLE + "background:" + ToDoMain.PROPERTIES.get(color);
    }
}


