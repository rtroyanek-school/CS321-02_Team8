/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.blackjackgame;
/**
 * Represents the user (player) in a Blackjack game.
 * Manages the player's hand and actions like drawing cards.
 */
public class User {
    private Hand hand; // The player's hand of cards

    /**
     * Constructs a User with an empty hand.
     */
    public User() {
        this.hand = new Hand();
    }

    /**
     * Draws a card from the deck and adds it to the player's hand.
     *
     * @param deck the deck from which to draw the card
     */
    public void drawCard(Deck deck) {
        Card card = deck.dealCard();
        hand.addCard(card);
    }

    /**
     * Returns the total value of the player's hand.
     *
     * @return the value of the player's hand
     */
    public int getHandValue() {
        return hand.getValue();
    }

    /**
     * Returns the player's hand.
     *
     * @return the player's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Resets the player's hand to an empty hand for a new round.
     */
    public void resetHand() {
        hand = new Hand();
    }
}

