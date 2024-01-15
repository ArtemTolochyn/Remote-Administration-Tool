package org.example;


import org.example.systemController.BrowserController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.print("Registering bot...");

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        telegramBotsApi.registerBot(new Bot());
    }
}