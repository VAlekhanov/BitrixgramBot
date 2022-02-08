package alekhanov.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static alekhanov.telegram.TrainingMethods.*;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            if(update.getMessage().getText().toLowerCase().equals("/помощь")){
                try {
                    execute(sendHelpMessage(update.getMessage().getChatId()));
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