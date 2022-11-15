package ru.pylaev.toDoProject.presentLayer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.abstractions.Observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class HtmlUI extends BaseUI implements Observer {
    public final static String MAIN_STYLE = "margin-left:120px;width:1295px;";
    private String alertStyle;

    @Autowired
    public HtmlUI(@Qualifier("baseUiFactory") BaseUiFactory factory) {
        super(factory.getView(), factory.getUiStateModel(), factory.getRespondControllerLogic());
        uiStateModel.addObserver(this);
    }

    @GetMapping
    public String get(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", view.getMessage());
        map.put("tasks", view.getArrTask());
        map.put("style", alertStyle);
        model.addAllAttributes(map);
        return "index";
    }

    @PostMapping
    public String post(@RequestParam String userInput) {
        respondControllerLogic.getRespond(userInput, uiStateModel);
        return "redirect:/";
    }

    @Override
    public void update(String message, List<Task> tasks) {
        alertStyle = getAlertStyle(view.getArrTask());
    }

    public static String getAlertStyle(String[] tasks) {
        String color = (tasks == null || tasks.length<1)?"alertColor":"mainColor";
        return MAIN_STYLE + "background:" + ToDoMain.PROPERTIES.get(color);
    }
}


