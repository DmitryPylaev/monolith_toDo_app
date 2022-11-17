package ru.pylaev.toDoProject.presentLayer.controller.runnable;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.controller.BaseController;
import ru.pylaev.toDoProject.presentLayer.factories.IBaseUiFactory;

import java.util.function.Supplier;

public abstract class BaseRunnableController extends BaseController implements Runnable{
    public boolean active = true;
    private final Supplier<String> requestSupplier;

    public BaseRunnableController(IBaseUiFactory factory) {
        super(factory);
        this.requestSupplier = viewHandler.getRequestSupplier();
    }

    public void processUserInput(UiStateModel uiStateModel) {
        respondLogic.accept(requestSupplier.get(), uiStateModel);
    }

    @Override
    public final void run() {
        viewHandler.show();
        while (active) processUserInput(uiStateModel);
    }
}
