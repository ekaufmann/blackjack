package com.ekaufmann.blackjack.handler;

import com.ekaufmann.blackjack.entity.Deck;
import com.ekaufmann.blackjack.entity.Player;
import com.ekaufmann.blackjack.service.GameService;

import java.io.IOException;
import java.util.Scanner;

public class GameHandler {

    private final GameService service;

    public GameHandler() {
        service = new GameService(new Deck(), new Player());
    }

    public void run() throws IOException {
        var input = new Scanner(System.in);

        showHeader();

        while (true) {
            var choice = input.next();
            System.out.println();

            switch (choice.toUpperCase()) {
                case "P" -> System.out.println(service.retrievePlayerCardsAndScore());
                case "H" -> System.out.println(service.givePlayerACard());
                case "S" -> System.out.println(service.verifyPlayerScore());
                case "R" -> System.out.println("Restarting...WIP");
                case "Q" -> endGame();
                default -> System.out.println("This is an incorrect option!");
            }
        }
    }

    private void showHeader() {
        System.out.println("\n========= Blackjack =========\n");
        System.out.println("\nChoose one of the available options to play Blackjack:\n");
        System.out.println("P -> Show points\nH -> Hit\nS -> Stand\nR -> Restart\nQ -> Quit\n");
    }

    private static void endGame() {
        System.out.println("Bye! :D");
        System.exit(0);
    }
}
