package ru.pylaev.toDoProject.presentLayer.factories.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.controller.controllerLogic.ExeptGraphLogic;
import ru.pylaev.toDoProject.presentLayer.factories.BaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.view.UniversalViewHandler;
import ru.pylaev.toDoProject.presentLayer.view.WindowView;

import java.util.function.BiConsumer;

@Component
public class WindowUiFactory extends BaseUiFactory implements IWindowUiFactory {
    @Autowired
    public WindowUiFactory(UniversalViewHandler viewHandler,
                           UiStateModel uiStateModel,
                           BiConsumer<String, UiStateModel> respondLogic,
                           ExeptGraphLogic graphLogic,
                           WindowView windowView) {
        super(viewHandler, uiStateModel, respondLogic, graphLogic);
        viewHandler.setRunnableUi(windowView);
    }
}
