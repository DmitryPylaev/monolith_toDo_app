package ru.pylaev.toDoProject.presentLayer.runnableUI.telegram;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pylaev.toDoProject.presentLayer.runnableUI.InputGetter;

@Component
@AllArgsConstructor
public class TelegramInputGetter extends InputGetter {
    private final TelegramBot bot;

    @Override
    public String get() {
        return bot.input;
    }

    @Override
    public void setNull() {
        bot.input = null;
    }
}
