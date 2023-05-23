package com.ekaufmann.blackjack;

import com.ekaufmann.blackjack.handler.GameHandler;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        new GameHandler().run();
    }
}
