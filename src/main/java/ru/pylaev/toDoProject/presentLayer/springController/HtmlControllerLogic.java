package ru.pylaev.toDoProject.presentLayer.springController;

import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.ToDoMain;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public class HtmlControllerLogic extends MainControllerLogic {

    public String getColor(View view) {
        String[] tasks = view.getTasks();
        String color = "background:" + ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("mainColor");
        if (tasks == null || tasks.length<1) {
            color = "background:"+ ToDoMain.CUSTOM_PROPERTIES.getPropertyContent("alertColor");
        }
        return color;
    }
}
