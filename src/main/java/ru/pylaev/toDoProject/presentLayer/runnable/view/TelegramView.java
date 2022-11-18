package ru.pylaev.toDoProject.presentLayer.runnable.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelegramView extends View {
    private final CustomTelegramBot telegramBot;

    @Autowired
    public TelegramView(CustomTelegramBot telegramBot){
        this.telegramBot = telegramBot;
    }

    @Override
    public String getUserInput() {
        return telegramBot.getUserInput();
    }

    @Override
    public void setNull() {
        telegramBot.setUserInput(null);
    }

    @Override
    public void display(String message) {
        telegramBot.display(message);
    }
}