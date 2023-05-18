package com.ekaufmann.blackjack;

import com.ekaufmann.blackjack.entity.Deck;

public class App {

    public static void main(String[] args) {
        var deck = new Deck();
        System.out.println(deck);
        System.out.println(deck.hit());
        System.out.println(deck);
    }
}
