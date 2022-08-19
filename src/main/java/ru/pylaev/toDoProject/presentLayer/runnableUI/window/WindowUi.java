package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnableUI.RunnableUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

@Component
public class WindowUi extends RunnableUI {
    @Autowired
    public WindowUi(View view, UiStateModel uiStateModel, WindowUIFactory factory) {
        super(view, uiStateModel);
        view.setPrinter(factory.getPrinter());
        setController(factory.getController());
    }
}
