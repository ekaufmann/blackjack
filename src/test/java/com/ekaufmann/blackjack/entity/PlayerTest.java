package com.ekaufmann.blackjack.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    void shouldInstantiateAPlayer() {
        var player = new Player();

        assertNotNull(player);
    }

    @Test
    void shouldInstantiateAPlayerWithNoCardsAndZeroPoints() {
        var player = new Player();

        assertEquals(player.getCards().size(), 0);
        assertEquals(player.getPoints(), 0);
    }

    @Test
    void playerCanReceiveACardAndItsPointsToCounter() {
        var player = new Player();
        var card = new Card("spades", 2, "2");

        player.receiveCard(card);

        assertEquals(player.getCards().size(), 1);
        assertEquals(player.getCards().get(0), card);
        assertEquals(player.getPoints(), 2);
    }
}
