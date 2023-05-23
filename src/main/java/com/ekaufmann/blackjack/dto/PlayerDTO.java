package com.ekaufmann.blackjack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlayerDTO {

    private List<String> cards;

    private String points;

    public PlayerDTO() {
        this.cards = List.of();
        this.points = "0";
    }

    @Override
    public String toString() {
        var output = new StringBuilder().append("Cards: ");

        cards.forEach(card -> {
            output.append(card);
            output.append("\n");
        });

        return output
            .append("Points: ")
            .append(points)
            .append("\n")
            .toString();
    }
}
