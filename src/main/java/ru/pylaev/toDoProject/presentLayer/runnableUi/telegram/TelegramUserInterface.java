package ru.pylaev.toDoProject.presentLayer.runnableUi.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.pylaev.toDoProject.businessLogicLayer.UiState;
import ru.pylaev.toDoProject.presentLayer.runnableUi.BaseRunnableUI;
import ru.pylaev.toDoProject.presentLayer.view.View;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class TelegramUserInterface extends BaseRunnableUI {
    private final TelegramBot bot;

    @Autowired
    public TelegramUserInterface(UiState uiState, View view, @Value("${botToken}") String token){
        super(uiState, view);
        bot = new TelegramBot(token, 1249988927);
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() {
        if (view.getTasks()!=null && view.getTasks().length>0) {
            bot.send(Arrays.toString(view.getTasks()));
        }
        bot.send(view.getMessage());
    }

    @Override
    public String get() {
        bot.Input = null;
        try {
            while (bot.Input == null) TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bot.Input;
    }
}
