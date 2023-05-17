package com.ekaufmann.blackjack.entity;

import com.ekaufmann.blackjack.entity.Card;
import com.ekaufmann.blackjack.entity.Deck;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeckTest {

    @Test
    void deckShouldInstantiateWithoutCards() {
        var deck = new Deck();

        assertNull(deck.getCards());
    }

    @Test
    void deckShouldInstantiateWithCards() {
        var card = new Card("hearts", 2, "2");
        var listOfCards = List.of(card);
        var deck = new Deck(listOfCards);

        assertEquals(deck.getCards(), listOfCards);
    }
}
