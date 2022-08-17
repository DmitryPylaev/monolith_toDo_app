package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

@Component
public class TelegramInputGetter extends InputGetter {
    private final TelegramBot bot;

    @Autowired
    public TelegramInputGetter(TelegramBot bot) {
        this.bot = bot;
    }

    @Override
    public String get() {
        return bot.input;
    }

    @Override
    public void setNull() {
        bot.input = null;
    }
}
