package ru.pylaev.toDoProject.presentLayer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.Controller;
import ru.pylaev.toDoProject.presentLayer.MainRespondLogic;
import ru.pylaev.util.ListToNumberingArrayConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class HtmlController extends Controller {
    public final static String MAIN_STYLE = "margin-left:120px;width:1295px;";
    private String alertStyle;
    private String[] arrTask;
    private String message = ToDoMain.PROPERTIES.get("askOwner");

    @Autowired
    public HtmlController(UiStateModel uiStateModel, MainRespondLogic respondLogic) {
        super(uiStateModel, respondLogic);
    }

    @GetMapping
    public String get(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("tasks", arrTask);
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
        this.message = message;
        arrTask = ListToNumberingArrayConverter.convert(tasks);
        alertStyle = getAlertStyle(arrTask);
    }

    public static String getAlertStyle(String[] tasks) {
        String color = (tasks == null || tasks.length<1)?"alertColor":"mainColor";
        return MAIN_STYLE + "background:" + ToDoMain.PROPERTIES.get(color);
    }
}


