package alekhanov.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static alekhanov.telegram.MenuRenderer.*;
import static alekhanov.telegram.TrainingMethods.*;
import static alekhanov.bitrix.service.ConnectToBitrix.*;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("Бот включен");
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
        if (update.hasMessage()) {
            if (update.getMessage().getText().matches("\\/.*")) {

                if (update.getMessage().getText().matches("/startBOT")) {
                    try {
                        //TODO method which start Bitrix work

                        //TODO method which render minimalistic menu for bitrix
                        message.setText("Получил сообщение: startBOT");
                        execute(message);
                        execute(startWindow(update.getMessage().getChatId()));

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (update.getMessage().getText().matches("/devBOT")) {
                    try {
                        //TODO method which start Bitrix work

                        //TODO method which render minimalistic menu for bitrix
                        message.setText("Получил сообщение: devBOT");
                        execute(message);
                        execute(devTools(update.getMessage().getChatId()));

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (update.getMessage().getText().matches("/clear")) {
                    try {
                        //TODO method which start Bitrix work

                        //TODO method which render minimalistic menu for bitrix
                        message.setText("Получил сообщение: clear");
                        execute(message);
                        execute(clearKeyboard(update.getMessage().getChatId()));

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (update.getMessage().getText().toLowerCase().equals("/помощь")) {
                    try {
                        execute(sendHelpMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (update.getMessage().getText().toLowerCase().equals("/картинка_поля")) {
                    try {
                        execute(sendLandspacePhoto(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (update.getMessage().getText().toLowerCase().equals("/кнопки")) {
                    try {
                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                //TODO end Bitrix work
            }
        } else {
            try {
                execute(startWindow(update.getMessage().getChatId()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "BitrixSync";
    }

    @Override
    public String getBotToken() {
        return "5039191030:AAGGC3hIg3VB-yEe7ioYECPgrroe8FMNBWs";
    }
}