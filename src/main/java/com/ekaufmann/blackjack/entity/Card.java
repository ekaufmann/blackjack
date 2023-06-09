package com.ekaufmann.blackjack.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private String suit;
    private Integer points;
    private String face;

    @Override
    public String toString() {
        return new StringBuilder()
            .append(face)
            .append(" of ")
            .append(suit)
            .toString();
    }
}
