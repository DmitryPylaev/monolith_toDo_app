package ru.pylaev.toDoProject.presentLayer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;

@Component("baseUiFactory")
@Scope("prototype")
public class BaseUiFactory {
    private final View view;
    private final UiStateModel uiStateModel;

    @Autowired
    public BaseUiFactory(View view, UiStateModel uiStateModel) {
        this.view = view;
        this.uiStateModel = uiStateModel;
    }

    public View getView() {
        return view;
    }

    public UiStateModel getUiStateModel() {
        return uiStateModel;
    }
}
