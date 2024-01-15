package org.example.messageController;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Buttons {

    public void first(Bot bot, Long chatId, String text)
    {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build();

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Screenshot \uD83D\uDDBC\uFE0F");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Discord \uD83E\uDD21\uFE0F");
        row.add("Camera \uD83D\uDCF8\uFE0F");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Passwords");
        row.add("PlayAudio");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Hotkeys");
        row.add("CMD");
        keyboard.add(row);


        keyboardMarkup.setKeyboard(keyboard);

        keyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void hotkeys(Bot bot, Long chatId, String text)
    {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build();

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("LinkedIn");
        row.add("CloseApp");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("MouseLock");
        keyboard.add(row);

        row = new KeyboardRow();
        row.add("Cancel");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);

        keyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancel(Bot bot, Long chatId, String text)
    {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build();

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("Cancel");
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);

        keyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
