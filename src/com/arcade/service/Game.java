package com.arcade.service;

import com.arcade.model.Board;
import com.arcade.model.Player;

import java.util.List;
import java.util.Random;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean gameWon;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.gameWon = false;
    }

    // Method to simulate a dice roll
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Method to check if a player has won
    private boolean hasPlayerWon(Player player) {
        return player.getPosition() == 100;
    }

    // Method to move a player based on the dice roll
    private void movePlayer(Player player, int diceValue) {
        int currentPosition = player.getPosition();
        int newPosition = currentPosition + diceValue;

        // Check if the new position is affected by snakes
        for (Snake snake : board.getSnakes()) {
            if (newPosition == snake.getPosition()) {
                newPosition = snake.getTail();
                break;
            }
        }

        // Check if the new position is affected by ladders
        for (Ladder ladder : board.getLadders()) {
            if (newPosition == ladder.getPosition()) {
                newPosition = ladder.getEnd();
                break;
            }
        }

        // Update player position
        if (newPosition <= 100) {
            player.setPosition(newPosition);
        }

        // Check if the player has won
        if (hasPlayerWon(player)) {
            gameWon = true;
            System.out.println(player.getName() + " wins the game");
        } else {
            System.out.println(player.getName() + " rolled a " + diceValue +
                    " and moved from " + currentPosition + " to " + newPosition);
        }
    }

    // Method to play the game
    public void play() {
        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);
            int diceValue = rollDice();
            movePlayer(currentPlayer, diceValue);

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}
