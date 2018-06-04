package com.TestBotTelegram;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
public class Main {
    public static void main(String[] args) {

        // TODO Initialize Api Context
        ApiContextInitializer.init();

        // TODO Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();
        // TODO Register our bot
        try {
            botsApi.registerBot(new Mister47Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}