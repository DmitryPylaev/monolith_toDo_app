package ru.pylaev.toDoProject.presentLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.abstractions.IBaseControllerFactory;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;

@Component("baseControllerFactory")
@Scope("prototype")
@AllArgsConstructor
@Getter
public class BaseControllerFactory implements IBaseControllerFactory {
    private final View view;
    private final UiStateModel uiStateModel;
    private final IControllerLogic respondControllerLogic;
}
