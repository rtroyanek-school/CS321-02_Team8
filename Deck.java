/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 *
 * @author rkigwana
 * Represents a deck of 52 playing cards. Responsible for initializing,
 * shuffling, and dealing cards.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of 52 playing cards. Responsible for initializing,
 * shuffling, and dealing cards. Automatically reinitializes if the deck runs out.
 */
public class Deck {

    // List to hold all 52 cards
    private List<Card> deck;

    /**
     * Constructs a deck of 52 cards with all combinations of suits and ranks.
     */
    public Deck() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    /**
     * Initializes the deck with all 52 cards, one for each combination of Suit and Rank.
     */
    private void initializeDeck() {
        deck.clear(); /** Clears any existing cards to avoid having duplicates */
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck, and randomizes the order of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Deals the top card from the deck. If the deck is empty, it reinitializes
     * and shuffles the new deck before it deals the card.
     *
     * @return the top card from the deck
     */
    public Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty. Creating and shuffling a new deck...");
            initializeDeck();
            shuffle();
        }
        return deck.remove(0);
    }

    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the number of cards left in the deck
     */
    public int cardsRemaining() {
        return deck.size();
    }
}
