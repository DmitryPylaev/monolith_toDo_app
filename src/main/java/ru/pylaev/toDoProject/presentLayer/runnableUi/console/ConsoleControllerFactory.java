package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseControllerFactory;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

@Component
public class ConsoleControllerFactory extends BaseControllerFactory implements IRunnableControllerFactory {
    private final ConsoleInputGetter inputGetter;

    @Autowired
    public ConsoleControllerFactory(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic, ConsoleInputGetter inputGetter) {
        super(view, uiStateModel, respondControllerLogic);
        this.inputGetter = inputGetter;
        view.setPainter(System.out::println);
    }

    @Override
    public Supplier<String> getInputGetter() {
        return inputGetter::getNotEmptyInput;
    }
}
