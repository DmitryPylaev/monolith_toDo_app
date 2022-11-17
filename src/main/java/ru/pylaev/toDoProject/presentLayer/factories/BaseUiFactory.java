package ru.pylaev.toDoProject.presentLayer.factories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.dataAccessLayer.Task;
import ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler;

import java.util.List;
import java.util.function.BiConsumer;

@Component("baseControllerFactory")
@Scope("prototype")
@AllArgsConstructor
@Getter
public class BaseUiFactory implements IBaseUiFactory {
    private final UniversalViewHandler viewHandler;
    private final UiStateModel uiStateModel;
    private final BiConsumer<String, UiStateModel> respondLogic;
    private final BiConsumer<String, List<Task>> graphLogic;
}
