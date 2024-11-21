/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 * Represents the main logic of the Blackjack game.
 * Manages the deck, user, dealer, and game flow.
 */
public class Game {
    private Deck deck; // The deck used in the game
    private User user; // The player in the game
    private Dealer dealer; // The dealer in the game
    private int playerWins = 0; // Count of player wins
    private int dealerWins = 0; // Count of dealer wins
    private int ties = 0; // Count of ties
    private boolean gameEnded; // Flag to indicate if the game has ended

    /**
     * Constructs a new Game instance with a deck, user, and dealer.
     */
    public Game() {
        deck = new Deck();
        user = new User();
        dealer = new Dealer();
        gameEnded = false;
    }

    /**
     * Starts a new game, resets the previous state, and deals initial cards to the user and dealer.
     */
    public void startGame() {
        resetGame(); // Properly reset the game before starting
        deck.shuffle();
        user.drawCard(deck);
        user.drawCard(deck);
        dealer.drawCard(deck);
        dealer.drawCard(deck);
        gameEnded = false;
    }

    /**
     * Handles the player's "hit" action, drawing a card from the deck.
     * Ends the game if the player busts (hand value exceeds 21).
     */
    public void playerHit() {
        if (!gameEnded) {
            user.drawCard(deck);
            if (user.getHandValue() > 21) {
                gameEnded = true;
                calculateOutcome(); // Only update stats once
            }
        }
    }

    /**
     * Handles the player's "stand" action, allowing the dealer to take their turn.
     * Ends the game after the dealer's turn.
     */
    public void playerStand() {
        if (!gameEnded) {
            dealer.playTurn(deck);
            gameEnded = true;
            calculateOutcome(); // Only update stats once
        }
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game has ended, false otherwise
     */
    public boolean isGameOver() {
        return gameEnded;
    }

    /**
     * Determines the outcome of the game and returns it as a string.
     *
     * @return a string describing the outcome of the game
     */
    public String getOutcome() {
        int playerTotal = user.getHandValue();
        int dealerTotal = dealer.getHandValue();

        if (playerTotal > 21) {
            return "You busted! Dealer wins.";
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            return "You win!";
        } else if (playerTotal < dealerTotal) {
            return "Dealer wins.";
        } else {
            return "It's a tie!";
        }
    }

    /**
     * Returns the dealer's initial card for display purposes.
     *
     * @return a string representing the dealer's first card
     */
    public String getDealerInitialCard() {
        if (!dealer.getHand().getCards().isEmpty()) {
            return dealer.getHand().getCards().get(0).toString(); // Return only the first card of the dealer's hand.
        } else {
            return "No cards available"; // Fallback if dealer's hand is empty.
        }
    }

    /**
     * Calculates the outcome of the game and updates the statistics for player wins, dealer wins, or ties.
     */
    private void calculateOutcome() {
        int playerTotal = user.getHandValue();
        int dealerTotal = dealer.getHandValue();

        if (playerTotal > 21) {
            dealerWins++;
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            playerWins++;
        } else if (playerTotal < dealerTotal) {
            dealerWins++;
        } else {
            ties++;
        }
    }

    /**
     * Returns the player's hand.
     *
     * @return the player's hand
     */
    public Hand getPlayerHand() {
        return user.getHand();
    }

    /**
     * Returns the dealer's hand.
     *
     * @return the dealer's hand
     */
    public Hand getDealerHand() {
        return dealer.getHand();
    }

    /**
     * Returns the number of times the player has won.
     *
     * @return the number of player wins
     */
    public int getPlayerWins() {
        return playerWins;
    }

    /**
     * Returns the number of times the dealer has won.
     *
     * @return the number of dealer wins
     */
    public int getDealerWins() {
        return dealerWins;
    }

    /**
     * Returns the number of ties that have occurred.
     *
     * @return the number of ties
     */
    public int getTies() {
        return ties;
    }

    /**
     * Resets the game state, including the user's and dealer's hands, and sets gameEnded to false.
     */
    private void resetGame() {
        user.resetHand();
        dealer.resetHand();
        gameEnded = false;
    }
}


    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
