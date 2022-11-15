package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimpleRunnableController;
import ru.pylaev.toDoProject.presentLayer.ui.BaseUiFactory;

@Component
public class WindowUiFactory extends BaseUiFactory implements RunnableUiFactory {
    private final Window window;

    @Autowired
    public WindowUiFactory(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic, Window window) {
        super(view, uiStateModel, respondControllerLogic);
        this.window = window;
        view.setPainter(window::display);
    }

    @Override
    public IRunnableController getController() {
        return new SimpleRunnableController(new WindowInputGetter(window.getTextField()), new MainControllerLogic());
    }
}
