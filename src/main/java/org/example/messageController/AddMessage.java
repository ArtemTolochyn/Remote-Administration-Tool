package org.example.messageController;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AddMessage {
    public void text(Bot bot, Long chatId, String message)
    {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId.toString())
                .text(message)
                .build();

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void bigText(Bot bot, Long chatId, String message)
    {

        InputStream inputStream = new ByteArrayInputStream(message.getBytes());
        SendDocument sendDocument = SendDocument.builder()
                .chatId(chatId.toString())
                .document(new InputFile(inputStream, "passwords.txt"))
                .build();

        try {
            bot.execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void image(Bot bot, Long chatId, InputFile image) throws TelegramApiException {

        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatId.toString())
                .photo(image)
                .build();

        bot.execute(sendPhoto);
    }
}
