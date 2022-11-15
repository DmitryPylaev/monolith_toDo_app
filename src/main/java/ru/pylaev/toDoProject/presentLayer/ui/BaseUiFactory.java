package ru.pylaev.toDoProject.presentLayer.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;

@Component("baseUiFactory")
@Scope("prototype")
@AllArgsConstructor
@Getter
public class BaseUiFactory {
    private final View view;
    private final UiStateModel uiStateModel;
    private final IControllerLogic respondControllerLogic;
}
