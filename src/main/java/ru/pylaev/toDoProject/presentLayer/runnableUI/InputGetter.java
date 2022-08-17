package ru.pylaev.toDoProject.presentLayer.runnableUI;

import java.util.concurrent.TimeUnit;

public abstract class InputGetter {
    protected abstract String get ();

    protected abstract void setNull();

    protected String getInput() {
        setNull();
        String result = null;
        try {
            while (result == null) {
                result = get();
                TimeUnit.MILLISECONDS.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
