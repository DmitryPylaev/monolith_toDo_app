package ru.pylaev.toDoProject.presentLayer.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;
import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;
import ru.pylaev.toDoProject.presentLayer.BaseControllerFactory;

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
    public BaseInputGetter getInputGetter() {
        return new WindowInputGetter(window.getTextField());
    }
}
