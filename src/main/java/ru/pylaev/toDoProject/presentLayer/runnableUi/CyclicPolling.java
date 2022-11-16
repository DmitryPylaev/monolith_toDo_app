package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableUi;

import java.util.concurrent.TimeUnit;

public class CyclicPolling {
    public static String getNotEmptyInput(IRunnableUi ui) {
        ui.setNull();
        String result = null;
        try {
            while (result == null) {
                result = ui.getUserInput();
                TimeUnit.MILLISECONDS.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
