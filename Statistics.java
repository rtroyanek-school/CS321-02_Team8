/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 * Represents the statistics for a Blackjack game.
 * Tracks the number of games played, wins, ties, and blackjacks for both the player and the dealer.
 */
public class Statistics {
    private int gamesPlayed; // Total number of games played
    private int playerWins; // Number of games won by the player
    private int dealerWins; // Number of games won by the dealer
    private int ties; // Number of games that ended in a tie
    private int playerBlackjacks; // Number of times the player got a Blackjack
    private int dealerBlackjacks; // Number of times the dealer got a Blackjack

    /**
     * Records the outcome of a game, updating the relevant statistics.
     *
     * @param playerWon       true if the player won the game
     * @param dealerWon       true if the dealer won the game
     * @param isTie           true if the game ended in a tie
     * @param playerBlackjack true if the player got a Blackjack
     * @param dealerBlackjack true if the dealer got a Blackjack
     */
    public void recordGame(boolean playerWon, boolean dealerWon, boolean isTie, boolean playerBlackjack, boolean dealerBlackjack) {
        gamesPlayed++;
        if (isTie) {
            ties++;
        } else if (playerWon) {
            playerWins++;
        } else if (dealerWon) {
            dealerWins++;
        }

        if (playerBlackjack) {
            playerBlackjacks++;
        }
        if (dealerBlackjack) {
            dealerBlackjacks++;
        }
    }

    /**
     * Prints the statistics of the games played, including wins, ties, and Blackjacks.
     */
    public void printStatistics() {
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Dealer Wins: " + dealerWins);
        System.out.println("Ties: " + ties);
        System.out.println("Player Blackjacks: " + playerBlackjacks);
        System.out.println("Dealer Blackjacks: " + dealerBlackjacks);
    }

    /**
     * Returns the number of games won by the player.
     *
     * @return the number of player wins
     */
    public int getPlayerWins() {
        return playerWins;
    }

    /**
     * Returns the number of games won by the dealer.
     *
     * @return the number of dealer wins
     */
    public int getDealerWins() {
        return dealerWins;
    }

    /**
     * Returns the number of games that ended in a tie.
     *
     * @return the number of ties
     */
    public int getTies() {
        return ties;
    }
}
