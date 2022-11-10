package ru.pylaev.toDoProject.presentLayer.controllerLogic;

import ru.pylaev.toDoProject.ToDoMain;

public class AlertControllerLogic {
    public final static String MAIN_STYLE = "margin-left:120px;width:1295px;";

    public static String getAlertStyle(String[] tasks) {
        String color = (tasks == null || tasks.length<1)?"alertColor":"mainColor";
        return MAIN_STYLE + "background:" + ToDoMain.PROPERTIES.get(color);
    }
}
