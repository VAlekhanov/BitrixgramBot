package org.alekhanov.bitrixgrambot;

import org.telegram.telegrambots.bots;

public static void main(String[]args){
        ApiContextInitializer.init();
        TelegramBotApi telegramBotApi=new TelegramBotApi();
        try{
        telegramBotApi.registerBot(Bot.getBot());
        }catch(TelegramApiRequestException e){
        e.printStackTrace();
        }
        }

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            log.log(Level.SEVERE, "Exception: ", e.toString());
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
