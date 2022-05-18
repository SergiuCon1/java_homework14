package ru.netology.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Data
public class Game {
    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = isRegistered(playerName1);
        int strengthPlayer2 = isRegistered(playerName2);
        if (strengthPlayer1 == 0) {
            throw new NotRegisteredException("Player with name " + playerName1 + " is not registered");
        }
        if (strengthPlayer2 == 0) {
            throw new NotRegisteredException("Player with name " + playerName2 + " is not registered");
        }
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }

    public int isRegistered(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                int strengthPlayer = player.getStrength();
                return strengthPlayer;
            }
        }
        return 0;
    }
}