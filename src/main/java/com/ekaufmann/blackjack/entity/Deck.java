package com.ekaufmann.blackjack.entity;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ToString
public class Deck {

    private List<Card> cards;

    public Deck() {
        this.populate();
    }

    public List<Card> getCards() {
        return List.copyOf(this.cards);
    }

    public Card hit() {
        int randomIndex = new Random().nextInt(cards.size());

        return cards.remove(randomIndex);
    }

    private void populate() {
        cards = new ArrayList<>();
        var suits = List.of("hearts", "spades", "clubs", "diamonds");
        var figurativeCards = List.of("jack", "queen", "king");

        suits.forEach(suit -> {
            for (int points = 2; points <= 10; points++) {
                cards.add(new Card(suit, points, String.valueOf(points)));
            }

            figurativeCards.forEach(
                figure -> cards.add(new Card(suit, 10, figure))
            );

            cards.add(new Card(suit, 11, "ace"));
        });
    }
}
