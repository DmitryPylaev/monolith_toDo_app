package ru.pylaev.toDoProject.presentLayer.ui;

import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;

public abstract class BaseUI {
    protected View view;
    protected UiStateModel uiStateModel;
    protected IControllerLogic respondControllerLogic;

    public BaseUI(View view, UiStateModel uiStateModel, IControllerLogic respondControllerLogic) {
        this.view = view;
        this.uiStateModel = uiStateModel;
        this.respondControllerLogic = respondControllerLogic;
        uiStateModel.addObserver(view);
    }
}
