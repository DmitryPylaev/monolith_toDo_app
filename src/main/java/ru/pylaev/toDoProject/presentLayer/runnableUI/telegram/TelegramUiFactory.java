package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IController;
import ru.pylaev.toDoProject.presentLayer.abstractions.RunnableUiFactory;
import ru.pylaev.toDoProject.presentLayer.MainControllerLogic;
import ru.pylaev.toDoProject.presentLayer.runnableUI.SimpleController;
import ru.pylaev.toDoProject.presentLayer.ui.BaseUiFactory;

@Component
public class TelegramUiFactory extends BaseUiFactory implements RunnableUiFactory {
    private final TelegramBot bot;

    @Autowired
    public TelegramUiFactory(View view, UiStateModel uiStateModel, TelegramBot bot) {
        super(view, uiStateModel);
        this.bot = bot;
        view.setPainter(bot::send);
    }

    @Override
    public IController getController() {
        return new SimpleController(new TelegramInputGetter(bot), new MainControllerLogic());
    }
}
