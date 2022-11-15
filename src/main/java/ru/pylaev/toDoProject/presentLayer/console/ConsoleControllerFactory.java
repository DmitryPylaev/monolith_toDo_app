package ru.pylaev.toDoProject.presentLayer.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;
import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;
import ru.pylaev.toDoProject.presentLayer.BaseControllerFactory;

@Component
public class ConsoleControllerFactory extends BaseControllerFactory implements IRunnableControllerFactory {
    @Autowired
    public ConsoleControllerFactory(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic) {
        super(view, uiStateModel, respondControllerLogic);
        view.setPainter(System.out::println);
    }

    @Override
    public BaseInputGetter getInputGetter() {
        return new ConsoleInputGetter();
    }
}
