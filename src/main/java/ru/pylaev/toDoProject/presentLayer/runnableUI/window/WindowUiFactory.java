package ru.pylaev.toDoProject.presentLayer.runnableUI.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimpleController;
import ru.pylaev.toDoProject.presentLayer.ui.BaseUiFactory;

@Component
public class WindowUiFactory extends BaseUiFactory implements RunnableUiFactory {
    private final Window window;

    @Autowired
    public WindowUiFactory(View view, UiStateModel uiStateModel, Window window) {
        super(view, uiStateModel);
        this.window = window;
        view.setPainter(window::display);
    }

    @Override
    public IController getController() {
        return new SimpleController(new WindowInputGetter(window.getTextField()), new MainControllerLogic());
    }
}
