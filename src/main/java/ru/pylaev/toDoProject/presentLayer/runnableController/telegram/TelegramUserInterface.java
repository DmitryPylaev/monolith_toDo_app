package ru.pylaev.toDoProject.presentLayer.runnableController.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.pylaev.toDoProject.businessLogicLayer.UiStateModel;
import ru.pylaev.toDoProject.presentLayer.runnableController.RunnableController;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.concurrent.TimeUnit;

@Component
public class TelegramUserInterface extends RunnableController {
    private final TelegramBot bot;

    @Autowired
    public TelegramUserInterface(View view, UiStateModel uiStateModel, @Value("${botToken}") String token){
        super(view, uiStateModel);
        bot = new TelegramBot(token, 1249988927);
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        view.setPrinter(bot::send);
    }

    @Override
    public String getInput() {
        bot.Input = null;
        try {
            while (bot.Input == null) TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bot.Input;
    }
}
