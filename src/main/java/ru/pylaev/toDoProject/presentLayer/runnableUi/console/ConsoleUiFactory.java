package ru.pylaev.toDoProject.presentLayer.runnableUi.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.ViewHandler;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRespondLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

@Component
public class ConsoleUiFactory extends BaseUiFactory implements IRunnableControllerFactory {
    private final ConsoleView inputGetter;

    @Autowired
    public ConsoleUiFactory(ViewHandler viewHandler, UiStateModel uiStateModel, IRespondLogic respondControllerLogic, ConsoleView inputGetter) {
        super(viewHandler, uiStateModel, respondControllerLogic);
        this.inputGetter = inputGetter;
        viewHandler.setPainter(inputGetter::display);
    }

    @Override
    public Supplier<String> getRequestSupplier() {
        return inputGetter::getNotEmptyInput;
    }
}
