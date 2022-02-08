package alekhanov.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;


public class MenuRenderer {

    private static List<KeyboardRow> keyboardRowList = new ArrayList<>();
    private static ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    private static SendMessage sendMessage = new SendMessage();
    private static long globalChatId;

    protected static SendMessage startWindow(long chatId) {
        globalChatId = chatId;
        KeyboardButton loginButton = new KeyboardButton();
        loginButton.setText("log in");
        KeyboardButton forgotLoginOrPasswordButton = new KeyboardButton();
        forgotLoginOrPasswordButton.setText("forgot login or password");
        updateKeyboard(loginButton);
        updateKeyboard(forgotLoginOrPasswordButton);
        sendMessage.setText("on");
        sendMessage.setChatId(valueOf(chatId));
        return sendMessage;
    }

    protected static SendMessage devTools(long chatId) {
        globalChatId = chatId;
        KeyboardButton clearKeyboardButton = new KeyboardButton();
        clearKeyboardButton.setText("Clear Keyboard");
        updateKeyboard(clearKeyboardButton);
        sendMessage.setText("dev");
        sendMessage.setChatId(valueOf(chatId));
        return sendMessage;
    }

    private static void updateKeyboard(KeyboardButton button) {
            KeyboardRow keyboardRow = new KeyboardRow();
            keyboardRow.add(0, button);
            keyboardRowList.add(keyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.setText("update");
            sendMessage.setChatId(valueOf(globalChatId));
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

    protected static SendMessage clearKeyboard(long chatId) {
        updateKeyboard(null);
        ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
        replyKeyboardRemove.setRemoveKeyboard(true);
        replyKeyboardRemove.setSelective(true);
        sendMessage.setReplyMarkup(replyKeyboardRemove);
        sendMessage.setText("clear");
        sendMessage.setChatId(valueOf(chatId));
        return sendMessage;
    }
}
