/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 *
 * @author rkigwana
 */
public class DeckTestManual {
    public static void main(String[] args) {
        /**
         * Testing the Card class
         */
        
        Card testCard = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        System.out.println("Test Card: " + testCard); // Expected output should be : "ACE of HEARTS (11)"

        /** Creating a new deck and shuffling it */
        Deck deck = new Deck();
        System.out.println("Number of cards before shuffling: " + deck.cardsRemaining()); // Expected: 52
        deck.shuffle();

        /** Deal out some cards */
        System.out.println("Dealing cards:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.dealCard()); // Print the details of each dealt card
        }

        /** Show the number of remaining cards */
        System.out.println("Number of cards remaining: " + deck.cardsRemaining()); // Expected: 47

        /** Test dealing until the deck is empty */
        while (deck.cardsRemaining() > 0) {
            deck.dealCard();
        }

        /** Verify that the deck is empty */
        System.out.println("Number of cards after dealing all: " + deck.cardsRemaining()); // Expected: 0
        try {
            deck.dealCard(); /** This should throw an exception */
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage()); // Expected: "Cannot deal from an empty deck."
        }
    }
}

