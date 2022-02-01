package alekhanov;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.*;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(sh);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        if (update.hasMessage()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
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

    public static SendMessage sendHelpMessage(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(valueOf(chatId));
        sendMessage.setText("Пример");
        return sendMessage;
    }

    public static SendPhoto sendLandspacePhoto(long chatId) {
        InputFile file = new InputFile("https://sun9-68.userapi.com/kkE70h-FsBX4AKJxE4wKm0iug8jYHxx97v4u_Q/OKIOERhgTR4.jpg");
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(valueOf(chatId));
        sendPhoto.setPhoto(file);
        return sendPhoto;
    }

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Тык");
        inlineKeyboardButton1.setCallbackData("ajsdhgfkajsgf");
        inlineKeyboardButton2.setText("Тык2");
        inlineKeyboardButton2.setCallbackData("Button \"Тык2\" has been pressed");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Fi4a");
        inlineKeyboardButton.setCallbackData("CallFi4a");
        keyboardButtonsRow1.add(inlineKeyboardButton);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(valueOf(chatId));
        sendMessage.setText("Пример");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
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