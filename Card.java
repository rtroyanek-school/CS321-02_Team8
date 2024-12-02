/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 * Represents a playing card with a suit and rank.
 */
public class Card {
    
    /**
     * Enum for the four suits of a card: CLUBS, DIAMONDS, HEARTS, SPADES.
     */
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
    /**
     * Enum for the thirteen ranks of a card: TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE.
     */
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    private final Suit suit;  // The suit of the card
    private final Rank rank;  // The rank of the card

    /**
     * Constructs a card given a suit and rank.
     *
     * @param suit the suit of the card (e.g., CLUBS, DIAMONDS, HEARTS, SPADES)
     * @param rank the rank of the card (e.g., TWO, THREE, KING, ACE)
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns the Blackjack value of the card.
     * Face cards (JACK, QUEEN, KING) are worth 10, Aces are worth 11, and other cards have their rank value.
     *
     * @return the value of the card
     */
    public int getValue() {
        switch (rank) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING: return 10;
            case ACE: return 11;
        }
        return 0; // Should never reach here
    }

     /**
     * Returns the path of the card in the format "resizedCards/value_of_suit.png".
     *
     * @return the path of the card
     */
    public String getImagePath() {
        // Convert rank and suit to lowercase and replace underscores with spaces for ranks
        String rankName = rank.name().toLowerCase();
        String suitName = suit.name().toLowerCase();
        return "resizedCards/" + rankName + "_of_" + suitName + ".png";
    }


    /**
     * Returns a string representation of the card, including its rank and suit.
     * Example: "KING of SPADES"
     *
     * @return a string describing the card
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
} 
