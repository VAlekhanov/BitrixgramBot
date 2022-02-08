package alekhanov.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class TrainingMethods {
    protected static SendMessage sendHelpMessage(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(valueOf(chatId));
        sendMessage.setText("Пример");
        return sendMessage;
    }

    protected static SendPhoto sendLandspacePhoto(long chatId) {
        InputFile file = new InputFile("https://sun9-68.userapi.com/kkE70h-FsBX4AKJxE4wKm0iug8jYHxx97v4u_Q/OKIOERhgTR4.jpg");
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(valueOf(chatId));
        sendPhoto.setPhoto(file);
        return sendPhoto;
    }

    protected static SendMessage sendInlineKeyBoardMessage(long chatId) {
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
}
