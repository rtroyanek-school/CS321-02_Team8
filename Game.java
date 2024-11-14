package com.mycompany.blackjackgame;

import java.util.Scanner;

public class Game {
    private Deck deck;
    private User user;
    private Dealer dealer;
    private Scanner scanner;
    private Statistics stats; // Statistics tracking

    /**
     * Initializes the game with a new deck, user, dealer, and statistics.
     */
    public Game() {
        deck = new Deck();
        user = new User(deck);
        dealer = new Dealer(deck);
        scanner = new Scanner(System.in);
        stats = new Statistics(); // Initialize stats
    }

    /**
     * Starts a new game, handles the initial deal, and manages the game flow.
     */
    public void startGame() {
        System.out.println("Welcome to Blackjack!");

        while (true) {
            playRound();
            System.out.print("Play another round? (y/n): ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                break;
            }
            resetHands();
        }

        System.out.println("Thanks for playing! Here are your final statistics:");
        stats.printStatistics(); // Display final statistics
    }

    /**
     * Plays one round of Blackjack.
     */
    private void playRound() {
        deck.shuffle();
        dealInitialCards();

        // Check for initial Blackjacks
        if (user.getHand().isBlackjack()) {
            System.out.println("You have Blackjack!");
            if (dealer.hasBlackjack()) {
                System.out.println("Dealer also has Blackjack. It's a tie!");
                updateStatistics(false, false, true);
            } else {
                System.out.println("You win!");
                dealer.reactToLoss();
                updateStatistics(true, false, false);
            }
            displayRoundStatistics();
            return;
        } else if (dealer.hasBlackjack()) {
            System.out.println("Dealer has Blackjack! You lose.");
            dealer.reactToWin();
            updateStatistics(false, true, false);
            displayRoundStatistics();
            return;
        }

        // Player's turn
        playerTurn();

        // Dealer's turn if player didn't bust
        if (user.getHandValue() <= 21) {
            dealerTurn();
        }

        // Determine the outcome
        determineWinner();
        displayRoundStatistics(); // Display wins after the round ends
    }

    /**
     * Displays the current statistics after each round.
     */
    private void displayRoundStatistics() {
        System.out.println("\nCurrent Statistics:");
        System.out.println("Total Player Wins: " + stats.getPlayerWins());
        System.out.println("Total Dealer Wins: " + stats.getDealerWins());
        System.out.println("Total Ties: " + stats.getTies());
    }

    /**
     * Deals two initial cards to both the player and the dealer.
     */
    private void dealInitialCards() {
        System.out.println("\nDealing initial cards...");
        
        // Draw first card for the player and display once
        user.drawCard(deck);
        System.out.println("Your hand: " + user.getHand() + " (Total: " + user.getHandValue() + ")");
        
        // Draw second card for the player and display once
        user.drawCard(deck);
        System.out.println("Your hand: " + user.getHand() + " (Total: " + user.getHandValue() + ")\n");

        // Dealer draws two cards but only shows the first card
        dealer.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
        
        dealer.showInitialCard();
        System.out.println();
    }

    /**
     * Manages the player's turn, allowing them the choice to hit or stand.
     */
    private void playerTurn() {
        System.out.println("\nPlayer's turn:");
        while (true) {
            System.out.print("Would you like to 'hit' or 'stand'? ");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("hit")) {
                user.drawCard(deck);
                System.out.println("Your hand: " + user.getHand() + " (Total: " + user.getHandValue() + ")\n");
                if (user.getHandValue() > 21) {
                    System.out.println("Bust! You went over 21.\n");
                    return;
                }
            } else if (choice.equalsIgnoreCase("stand")) {
                break;
            } else {
                System.out.println("Invalid choice. Please type 'hit' or 'stand'.");
            }
        }
        System.out.println();
    }

    /**
     * Manages the dealer's turn according to the dealer's rules.
     */
    private void dealerTurn() {
        dealer.playTurn(); // Dealer plays according to house rules
        dealer.revealHand(); // Reveal all cards after dealer finishes
        System.out.println();
    }

    /**
     * Compares the player's and dealer's hands to determine the winner and updates statistics.
     */
    private void determineWinner() {
        int playerTotal = user.getHandValue();
        int dealerTotal = dealer.getHandValue();

        System.out.println("Final Results:");
        System.out.println("Player's total: " + playerTotal);
        System.out.println("Dealer's total: " + dealerTotal);

        if (playerTotal > 21) {
            System.out.println("You busted! Dealer wins.");
            dealer.reactToPlayerBust();
            updateStatistics(false, true, false);
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win!");
            dealer.reactToLoss();
            updateStatistics(true, false, false);
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins.");
            dealer.reactToWin();
            updateStatistics(false, true, false);
        } else {
            System.out.println("It's a tie!");
            updateStatistics(false, false, true);
        }
        System.out.println();
    }

    /**
     * Updates the statistics for the current round.
     */
    private void updateStatistics(boolean playerWon, boolean dealerWon, boolean isTie) {
        stats.recordGame(
            playerWon,
            dealerWon,
            isTie,
            user.getHand().isBlackjack(),
            dealer.hasBlackjack()
        );
    }

    /**
     * Resets both the player's and dealer's hands for the next round.
     */
    private void resetHands() {
        user.resetHand();
        dealer.resetHand();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
