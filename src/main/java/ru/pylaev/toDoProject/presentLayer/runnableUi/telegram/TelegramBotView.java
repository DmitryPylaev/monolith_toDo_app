package ru.pylaev.toDoProject.presentLayer.runnableUi.telegram;

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
import ru.pylaev.toDoProject.presentLayer.runnableUi.CyclicPolling;
import ru.pylaev.toDoProject.presentLayer.abstractions.IRunnableUi;

@Component
public class TelegramBotView extends TelegramLongPollingBot implements IRunnableUi {
    @Getter public String userInput;
    private long chatId;
    @Getter private String botToken;

    @Autowired
    public TelegramBotView(@Value("${chatId}") long chatId, @Value("${botToken}") String botToken){
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

    @Override
    public String getBotUsername() { return ToDoMain.PROPERTIES.get("botName"); }

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

    @Override
    public void setNull() {
        userInput = null;
    }

    public String getNotEmptyInput() {
        return CyclicPolling.getNotEmptyInput(this);
    }
}