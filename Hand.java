package com.mycompany.blackjackgame;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    // Adds a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Calculates the total value of the hand, with proper handling for Aces
    public int getHandValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int value = card.getValue();
            if (value == 11) { // Assume Ace is 11 initially
                aceCount++;
            }
            total += value;
        }

        // Adjust if total exceeds 21 and there are Aces
        while (total > 21 && aceCount > 0) {
            total -= 10; // Count Ace as 1 instead of 11
            aceCount--;
        }

        return total;
    }

    // Checks if the hand is a Blackjack (an Ace and a 10-value card)
    public boolean isBlackjack() {
        return getHandValue() == 21 && cards.size() == 2;
    }

    // Returns the cards in the hand
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Clears the hand for a new round
    public void clear() {
        cards.clear();
    }

    // Provides a readable representation of the hand's contents and value
    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (Card card : cards) {
            handString.append(card).append(", ");
        }
        // Remove the last comma and space, and add total value
        if (handString.length() > 0) {
            handString.setLength(handString.length() - 2);
        }
        return handString.toString();
    }
}
