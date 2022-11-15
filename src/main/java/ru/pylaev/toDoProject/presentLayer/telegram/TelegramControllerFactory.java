package ru.pylaev.toDoProject.presentLayer.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.View;
import ru.pylaev.toDoProject.presentLayer.abstractions.IControllerLogic;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableControllerFactory;
import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;
import ru.pylaev.toDoProject.presentLayer.BaseControllerFactory;

@Component
public class TelegramControllerFactory extends BaseControllerFactory implements IRunnableControllerFactory {
    private final TelegramBot bot;

    @Autowired
    public TelegramControllerFactory(View view, UiStateModel uiStateModel, IControllerLogic rendControllerLogic, TelegramBot bot) {
        super(view, uiStateModel, rendControllerLogic);
        this.bot = bot;
        view.setPainter(bot::send);
    }

    @Override
    public BaseInputGetter getInputGetter() {
        return new TelegramInputGetter(bot);
    }
}
