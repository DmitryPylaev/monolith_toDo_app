package ru.pylaev.toDoProject.presentLayer.runnableUi.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.BaseUiFactory;
import ru.pylaev.toDoProject.presentLayer.ViewHandler;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRespondLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;

import java.util.function.Supplier;

@Component
public class WindowUiFactory extends BaseUiFactory implements IRunnableControllerFactory {
    private final WindowView windowView;

    @Autowired
    public WindowUiFactory(ViewHandler viewHandler, UiStateModel uiStateModel, IRespondLogic respondControllerLogic, WindowView windowView) {
        super(viewHandler, uiStateModel, respondControllerLogic);
        this.windowView = windowView;
        viewHandler.setPainter(windowView::display);
    }

    @Override
    public Supplier<String> getRequestSupplier() {
        return windowView::getNotEmptyInput;
    }
}
