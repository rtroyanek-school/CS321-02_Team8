package com.mycompany.blackjackgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hand of cards in a Blackjack game.
 * Manages the collection of cards and calculates the hand's value.
 */
public class Hand {
    private List<Card> cards; // The list of cards in the hand

    /**
     * Constructs an empty hand.
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the hand.
     *
     * @param card the card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Calculates the total value of the hand, adjusting for Aces as needed.
     * Face cards are worth 10, and Aces can be worth 1 or 11 depending on the total hand value.
     *
     * @return the total value of the hand
     */
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int cardValue = card.getValue();
            if (cardValue == 1) { // Ace initially counts as 1
                aceCount++;
                value += 1;
            } else if (cardValue > 10) { // Face cards count as 10
                value += 10;
            } else {
                value += cardValue;
            }
        }

        // Adjust Aces if beneficial to count them as 11
        while (aceCount > 0 && value + 10 <= 21) {
            value += 10;
            aceCount--;
        }

        return value;
    }

    /**
     * Returns the list of cards in the hand.
     *
     * @return the list of cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Returns a string representation of the hand, including all cards.
     *
     * @return a string describing the cards in the hand
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "Empty Hand";
    }
}
