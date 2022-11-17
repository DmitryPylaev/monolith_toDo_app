package ru.pylaev.toDoProject.presentLayer.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.controller.controllerLogic.ConsoleGraphLogic;
import ru.pylaev.toDoProject.presentLayer.view.ConsoleView;
import ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler;

import java.util.function.BiConsumer;

@Component
public class ConsoleUiFactory extends BaseUiFactory {
    @Autowired
    public ConsoleUiFactory(UniversalViewHandler viewHandler,
                            UiStateModel uiStateModel,
                            BiConsumer<String, UiStateModel> respondControllerLogic,
                            ConsoleGraphLogic graphLogic,
                            ConsoleView runnableUi) {
        super(viewHandler, uiStateModel, respondControllerLogic, graphLogic);
        viewHandler.setRunnableUi(runnableUi);
    }
}
