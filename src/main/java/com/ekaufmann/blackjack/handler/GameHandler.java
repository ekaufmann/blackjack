package com.ekaufmann.blackjack.handler;

import com.ekaufmann.blackjack.entity.Deck;
import com.ekaufmann.blackjack.entity.Player;
import com.ekaufmann.blackjack.service.GameService;

import java.util.Scanner;

public class GameHandler {

    private final GameService service;

    public GameHandler() {
        service = new GameService(new Deck(), new Player());
    }

    public void run() {
        var input = new Scanner(System.in);
        System.out.println("Choose one of thw available options to play Blackjack:\n");
        System.out.println("P -> Show points\nH -> Hit\nS -> Stand\nR -> Restart\nQ -> Quit");

        while (true) {
            var choice = input.next();
            switch (choice.toUpperCase()) {
                case "P" -> System.out.println(service.retrievePlayerCardsAndScore());
                case "H" -> System.out.println(service.givePlayerACard());
                case "S" -> System.out.println(service.verifyPlayerScore());
                case "R" -> System.out.println("Restarting...");
                case "Q" -> endGame();
                default -> System.out.println("This is an incorrect option!");
            }
        }
    }

    private static void endGame() {
        System.out.println("Preparing to quit...");
        System.exit(0);
    }
}
