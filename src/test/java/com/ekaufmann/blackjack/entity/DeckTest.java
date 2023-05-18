package com.ekaufmann.blackjack.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setup() {
        deck = new Deck();
    }

    @Test
    void deckShouldInstantiateWithCards() {
        assertNotNull(deck.getCards());
    }

    @Test
    void deckShouldInstantiateWith52Cards() {
        assertNotNull(deck.getCards());
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    void deckShouldGiveACardAndRemoveFromItself() {
        var card = deck.hit();

        assertNotNull(card);
        assertEquals(deck.getCards().size(), 51);
    }
}
