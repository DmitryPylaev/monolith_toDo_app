package ru.pylaev.toDoProject.presentLayer.telegram;

import lombok.AllArgsConstructor;
import ru.pylaev.toDoProject.presentLayer.BaseInputGetter;

@AllArgsConstructor
public class TelegramInputGetter extends BaseInputGetter {
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
