package com.ekaufmann.blackjack.service;

import com.ekaufmann.blackjack.entity.Deck;
import com.ekaufmann.blackjack.entity.Player;

public class GameService {

    private final Deck deck;

    private final Player player;

    public GameService(Deck deck, Player player) {
        this.deck = deck;
        this.player = player;
    }

    public String retrievePlayerCardsAndScore() {
        return player.toString();
    }

    public String givePlayerACard() {
        try {
            var card = deck.hit();
            player.receiveCard(card);
        } catch (IndexOutOfBoundsException ex) {
            return "Deck is empty!";
        }
        return player.toString();
    }

    public String verifyPlayerScore() {
        var comparison = player.getPoints().compareTo(21);
        return switch (comparison) {
            case 1 -> "Player has more than 21 points";
            case -1 -> "Player has less than 21 points";
            default -> "Player score is equal 21 points";
        };
    }
}
