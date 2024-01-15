package org.example;

import org.example.messageController.MessageHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


public class Bot extends TelegramLongPollingBot {

    MessageHandler messageHandler = new MessageHandler();

    @Override
    public void onRegister() {
        messageHandler.init();
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.getMessage().hasText()) {
            return;
        }

        new Thread(() -> {
            messageHandler.check(update, this);
            System.gc();
        }).start();

        System.gc();

    }

    public void sendMessage(SendMessage message)
    {
        try {
            this.sendApiMethod(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "botName";
    }

    @Override
    public String getBotToken() {
        return "telegramToken";
    }
}
