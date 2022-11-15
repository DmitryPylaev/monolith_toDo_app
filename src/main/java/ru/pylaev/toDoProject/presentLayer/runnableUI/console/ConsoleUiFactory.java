package ru.pylaev.toDoProject.presentLayer.runnableUI.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.ui.BaseUiFactory;

@Component
public class ConsoleUiFactory extends BaseUiFactory implements RunnableUiFactory {
    @Autowired
    public ConsoleUiFactory(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic) {
        super(view, uiStateModel, respondControllerLogic);
        view.setPainter(System.out::println);
    }

    @Override
    public IRunnableController getController() {
        return new ConsoleRunnableController(new ConsoleInputGetter(), new MainControllerLogic());
    }
}
