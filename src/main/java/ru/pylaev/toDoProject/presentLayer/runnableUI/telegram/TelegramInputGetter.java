package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

@AllArgsConstructor
public class TelegramInputGetter extends InputGetter {
    private final TelegramBot bot;

    @Override
    public String getUserInput() {
        return bot.input;
    }

    @Override
    public void setNull() {
        bot.input = null;
    }
}
