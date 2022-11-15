package ru.pylaev.toDoProject.presentLayer;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableController;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

public class BaseRunnableController extends BaseController implements IRunnableController {
    public boolean active = true;
    private final BaseInputGetter inputGetter;

    public BaseRunnableController(IRunnableControllerFactory factory) {
        super(factory);
        this.inputGetter = factory.getInputGetter();
    }

    @Override
    public void processUserInput(UiStateModel uiStateModel) {
        respondControllerLogic.getRespond(inputGetter.getNotEmptyInput(), uiStateModel);
    }

    @Override
    public final void run() {
        view.show();
        while (active) processUserInput(uiStateModel);
    }
}
