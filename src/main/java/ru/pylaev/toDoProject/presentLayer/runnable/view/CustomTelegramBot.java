package ru.pylaev.toDoProject.presentLayer.runnable.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.pylaev.toDoProject.ToDoMain;

@Component
public class CustomTelegramBot extends TelegramLongPollingBot {
    @Getter @Setter private String userInput;
    private long chatId;
    @Getter private String botToken;
    @Getter private final String botUsername = ToDoMain.PROPERTIES.get("botName");

    @Autowired
    public CustomTelegramBot(@Value("${chatId}") long chatId, @Value("${botToken}") String botToken){
        try {
            this.chatId = chatId;
            this.botToken = botToken;
            new TelegramBotsApi(DefaultBotSession.class).registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().getChat().getId() == chatId)  {
            userInput = update.getMessage().getText();
        }
    }

    public void display(String message) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
