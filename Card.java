/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 *
 * @author rkigwana
 * Represents a single playing card with a suit and rank.
 */
public class Card {

    /** Nested enums for Suit and Rank */
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        private final int rankValue;

        Rank(int value) {
            this.rankValue = value;
        }

        public int getRankValue() {
            return rankValue;
        }
    }

    /** Variables for suit and rank */
    private final Suit suit;
    private final Rank rank;

    /**
     * Creates a card given a suit and rank.
     *
     * @param suit the suit of the card (e.g., HEARTS, DIAMONDS)
     * @param rank the rank of the card (e.g., TWO, KING, ACE)
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the Blackjack value of the card.
     * Face cards are worth 10, Aces are 11, and other cards have their rank value.
     *
     * @return the value of the card
     */
    public int getValue() {
        return rank.getRankValue();
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns a string representation of the card.
     * Example: "KING of SPADES (10)"
     *
     * @return a string describing the card
     */
    @Override
    public String toString() {
        return rank + " of " + suit + " (" + getValue() + ")";
    }
}
