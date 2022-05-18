package ru.netology.game;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player one = new Player(1, "Serg", 350);
    Player two = new Player(2, "Faer", 200);
    Player three = new Player(3, "Check", 400);
    Player four = new Player(4, "Dack", 200);

    @Test
    void shouldWinFirstPlayer() {
        Game game = new Game();

        game.register(one);
        game.register(two);

        int expected = 1;
        int actual = game.round("Serg", "Faer");

        assertEquals(expected, actual);
    }

    @Test
    void shouldWinSecondPlayer() {
        Game game = new Game();

        game.register(one);
        game.register(three);

        int expected = 2;
        int actual = game.round("Serg", "Check");

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotWinAnyone() {
        Game game = new Game();

        game.register(two);
        game.register(four);

        int expected = 0;
        int actual = game.round("Faer", "Dack");

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetNotRegisteredExceptionForFirstPlayer() {
        Game game = new Game();

        game.register(two);
        game.register(four);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Asag", "Dack");
        });
    }

    @Test
    void shouldGetNotRegisteredExceptionForSecondPlayer() {
        Game game = new Game();

        game.register(two);
        game.register(four);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Faer", "Aert");
        });
    }
}