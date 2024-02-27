package com.arcade;

import com.arcade.model.Board;
import com.arcade.model.Player;
import com.arcade.service.Game;
import com.arcade.service.Ladder;
import com.arcade.service.Snake;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        // Implement logic to read input (snakes, ladders, players) from command line or file

        // Create snakes and ladders
        List<Snake> snakes = Arrays.asList(new Snake(16, 6), new Snake(47, 26), new Snake(49, 11), new Snake(56, 53));
        List<Ladder> ladders = Arrays.asList(new Ladder(2, 38), new Ladder(4, 14), new Ladder(9, 31), new Ladder(33, 85));

        // Create players
        List<Player> players = Arrays.asList(new Player("Player1"), new Player("Player2"), new Player("Player3"));

        // Create board
        Board board = new Board(snakes, ladders);

        // Create the game
        Game game = new Game(board, players);

        // Play the game
        game.play();
    }
}