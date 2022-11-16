package ru.pylaev.toDoProject.presentLayer.runnableUi;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

public class BaseRunnableController extends BaseController implements IRunnableController {
    public boolean active = true;
    private final Supplier<String> inputGetter;

    public BaseRunnableController(IRunnableControllerFactory factory) {
        super(factory);
        this.inputGetter = factory.getRequestSupplier();
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        respondControllerLogic.getRespond(inputGetter.get(), uiStateModel);
    }

    @Override
    public final void run() {
        viewHandler.show();
        while (active) processUserInput(uiStateModel);
    }
}
