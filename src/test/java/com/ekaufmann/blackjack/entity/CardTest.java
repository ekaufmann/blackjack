package com.ekaufmann.blackjack.entity;

import com.ekaufmann.blackjack.entity.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardTest {

    @Test
    void cardShouldInstantiateWithoutValues() {
        var card = new Card();

        assertNull(card.getSuit());
        assertNull(card.getPoints());
        assertNull(card.getFace());
    }

    @Test
    void cardShouldInstantiateWithValues() {
        var suit = "hearts";
        var points = 2;
        var face = "2";

        var card = new Card(
            suit, points, face
        );

        assertEquals(card.getSuit(), suit);
        assertEquals(card.getPoints(), points);
        assertEquals(card.getFace(), face);
    }
}
