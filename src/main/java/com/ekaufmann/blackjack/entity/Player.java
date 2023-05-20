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

    @Override
    public String toString() {
        var output = new StringBuilder().append("Cards: ");

        cards.forEach(card -> {
            output.append(card.toString());
        });

        return output
            .append("\nPoints: ")
            .append(points)
            .append("\n")
            .toString();
    }
}
