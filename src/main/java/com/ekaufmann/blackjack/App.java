package com.ekaufmann.blackjack;

import com.ekaufmann.blackjack.handler.GameHandler;

public class App {

    public static void main(String[] args) {
        new GameHandler().run();
    }
}
