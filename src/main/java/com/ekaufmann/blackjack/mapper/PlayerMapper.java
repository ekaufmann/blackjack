package com.ekaufmann.blackjack.mapper;

import com.ekaufmann.blackjack.dto.PlayerDTO;
import com.ekaufmann.blackjack.entity.Card;
import com.ekaufmann.blackjack.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "cards", source = "cards", qualifiedByName = "getCards")
    PlayerDTO toDTO(Player player);

    @Named("getCards")
    default List<String> getCards(List<Card> cards) {
        if (cards == null || cards.size() == 0) return List.of();
        return cards.stream()
            .map(Card::toString)
            .collect(Collectors.toList());
    }
}
