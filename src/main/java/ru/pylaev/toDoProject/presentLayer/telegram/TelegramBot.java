package ru.pylaev.toDoProject.presentLayer.telegram;

import lombok.Getter;
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
public class TelegramBot extends TelegramLongPollingBot {
    public String input;
    private long chatId;
    @Getter private String botToken;

    @Autowired
    public TelegramBot(@Value("${chatId}") long chatId, @Value("${botToken}") String botToken){
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
            input = update.getMessage().getText();
        }
    }

    @Override
    public String getBotUsername() { return ToDoMain.PROPERTIES.get("botName"); }

    public void send(String message) {
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