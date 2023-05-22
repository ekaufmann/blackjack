package com.ekaufmann.blackjack.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {

    private final List<Card> cards;

    private Integer points;

    public Player() {
        cards = new ArrayList<>();
        points = 0;
    }

    public void receiveCard(Card card) {
        points += card.getPoints();
        cards.add(card);
    }
}
