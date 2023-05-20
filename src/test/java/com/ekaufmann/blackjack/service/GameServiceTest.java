package com.ekaufmann.blackjack.service;

import com.ekaufmann.blackjack.entity.Card;
import com.ekaufmann.blackjack.entity.Deck;
import com.ekaufmann.blackjack.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @InjectMocks
    private GameService service;

    @Mock
    private Player player;

    @Mock
    private Deck deck;

    @Test
    void thePlayerShouldHitTheDeckAndGetACardSuccessfully() {
        var card = new Card("hearts", 2, "2");

        when(deck.hit()).thenReturn(card);
        doNothing().when(player).receiveCard(card);

        var response = service.givePlayerACard();

        verify(deck, only()).hit();
        verify(player, only()).receiveCard(any(Card.class));
        assertNotNull(response);
    }

    @Test
    void theDeckIsEmptyWhenThePlayerHitIt() {
        when(deck.hit()).thenThrow(IndexOutOfBoundsException.class);

        var response = service.givePlayerACard();

        verify(deck, only()).hit();
        verify(player, never()).receiveCard(any());
        assertNotNull(response);
    }

    @Test
    void verifyPlayerScoreLessThan21() {
        when(player.getPoints()).thenReturn(new Random().nextInt(0, 20));

        var response = service.verifyPlayerScore();

        verify(player, only()).getPoints();
        assertNotNull(response);
        assertTrue(response.contains("less"));
    }

    @Test
    void verifyPlayerScoreEqual21() {
        when(player.getPoints()).thenReturn(21);

        var response = service.verifyPlayerScore();

        verify(player, only()).getPoints();
        assertNotNull(response);
        assertTrue(response.contains("equal"));
    }

    @Test
    void verifyPlayerScoreMoreThan21() {
        when(player.getPoints()).thenReturn(new Random().nextInt(22, 25));

        var response = service.verifyPlayerScore();

        verify(player, only()).getPoints();
        assertNotNull(response);
        assertTrue(response.contains("more"));
    }

    @Test
    void shouldRetrieveThePlayerCardsAndScoreSuccessfully() {
        when(player.toString()).thenReturn("Cards: \nPoints: 0\n");

        var result = service.retrievePlayerCardsAndScore();

        assertNotNull(result);
    }
}
