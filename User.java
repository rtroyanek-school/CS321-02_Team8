/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 *
 * @author rtroyanek
 * Represents the player's hand. Responsible for drawing  cards and adding
 * them to the player's hand.
 */
public class User {
    private Hand hand;
    private Deck deck;
    
    /**
     * A list to hold the player's hand
     */
    public User(Deck deck) {
        this.hand = new Hand();
        this.deck = deck;
    }
    
    /**
     * Draw a card from the deck and add it to the player's hand
     */
    public void drawCard(Deck deck) {
        Card drawnCard = deck.dealCard();
        if (drawnCard != null){
            hand.addCard(drawnCard);
            System.out.println("You drew: " + drawnCard);
            System.out.println("Your hand: " + hand + " (Total: " + hand.getHandValue() + ")");
        }
    }
    
    /**
     * Returns the list of cards in the player's hand 
     * 
     * @return list of cards in hand
     */
    public Hand getHand() {
        return hand;
    }
    
    /**
     * Returns value of all cards in player's hand
     * 
     * @return value of the hand
     */
    public int getHandValue() {
        return hand.getHandValue();
    }
    
    /**
     * Resets the player's hand to be prepared for the next round
     */
    public void resetHand() {
        hand.clear();
    }
}
