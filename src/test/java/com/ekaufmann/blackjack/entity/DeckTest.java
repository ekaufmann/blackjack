package com.ekaufmann.blackjack.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeckTest {

    @Test
    void deckShouldInstantiateWithCards() {
        var deck = new Deck();

        assertNotNull(deck.getCards());
    }

    @Test
    void deckShouldInstantiateWith52Cards() {
        var deck = new Deck();

        assertNotNull(deck.getCards());
        assertEquals(deck.getCards().size(), 52);
    }
}
