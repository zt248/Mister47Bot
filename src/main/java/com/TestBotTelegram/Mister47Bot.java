package com.TestBotTelegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Mister47Bot extends TelegramLongPollingBot {


    private static final String TOKEN = "499519825:AAFvlZC1FbwKrJ8qD1sf1LIREb4IhgxKJtg";
    private static final String USERNAME = "Mister47Bot";

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

//    @Override
//    public void onUpdateReceived(Update update) {
//        // We check if the update has a message and the message has text
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            // Set variables
//            String message_text = update.getMessage().getText();
//            long chat_id = update.getMessage().getChatId();
//
//            SendMessage message = new SendMessage() // Create a message object object
//                    .setChatId(chat_id)
//                    .setText(message_text);
//            try {
//                execute(message); // Sending our message object to user
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }

//    }


    @Override
    public void onUpdateReceived(Update update) {


//        String command =  update.getMessage().getText();
//
//
//        Message message = update.getMessage();
//        if (message != null && message.hasText()) {
//            if(command.equals("myname")){
//                System.out.println(update.getMessage().getFrom().getFirstName());
//                update.getMessage().getFrom().getFirstName();
//
//            }

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help"))
                sendMsg(message, "Привет, я робот");
            else
                sendMsg(message, "Я не знаю что ответить на это");
        }
        }


    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
