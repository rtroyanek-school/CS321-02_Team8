/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

public class Statistics {
    private int gamesPlayed;
    private int playerWins;
    private int dealerWins;
    private int ties;
    private int playerBlackjacks;
    private int dealerBlackjacks;

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

    public void printStatistics() {
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Dealer Wins: " + dealerWins);
        System.out.println("Ties: " + ties);
        System.out.println("Player Blackjacks: " + playerBlackjacks);
        System.out.println("Dealer Blackjacks: " + dealerBlackjacks);
    }

    // New methods to get win counts
    public int getPlayerWins() {
        return playerWins;
    }

    public int getDealerWins() {
        return dealerWins;
    }

    public int getTies() {
        return ties;
    }
}
