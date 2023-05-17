package com.ekaufmann.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardTest {

    @Test
    void cardShouldInstantiateWithoutValues() {
        Card card = new Card();

        assertNull(card.getSuit());
        assertNull(card.getPoints());
        assertNull(card.getFace());
    }

    @Test
    void cardShouldInstantiateWithValues() {
        var suit = "hearts";
        var points = 2;
        var face = "2";

        Card card = new Card(
            suit, points, face
        );

        assertEquals(suit, card.getSuit());
        assertEquals(points, card.getPoints());
        assertEquals(face, card.getFace());
    }
}
