package ru.pylaev.toDoProject.presentLayer.runnableUi.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseControllerFactory;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

@Component
public class WindowControllerFactory extends BaseControllerFactory implements IRunnableControllerFactory {
    private final Window window;

    @Autowired
    public WindowControllerFactory(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic, Window window) {
        super(view, uiStateModel, respondControllerLogic);
        this.window = window;
        view.setPainter(window::display);
    }

    @Override
    public Supplier<String> getInputGetter() {
        return window::getNotEmptyInput;
    }
}
