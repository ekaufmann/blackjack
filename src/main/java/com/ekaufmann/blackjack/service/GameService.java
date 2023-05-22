package com.ekaufmann.blackjack.service;

import com.ekaufmann.blackjack.entity.Deck;
import com.ekaufmann.blackjack.entity.Player;
import com.ekaufmann.blackjack.mapper.PlayerMapper;

public class GameService {

    private Deck deck;

    private Player player;

    private PlayerMapper mapper;

    public GameService(Deck deck, Player player) {
        this.deck = deck;
        this.player = player;
        this.mapper = PlayerMapper.INSTANCE;
    }

    public String retrievePlayerCardsAndScore() {
        return mapper.toDTO(player).toString();
    }

    public String givePlayerACard() {
        try {
            var card = deck.hit();
            player.receiveCard(card);
            return mapper.toDTO(player).toString();
        } catch (IndexOutOfBoundsException ex) {
            return "Deck is empty!";
        }
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
