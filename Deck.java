/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjackgame;

/**
 *
 * @author rkigwana
 */
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of 52 playing cards. Responsible for initializing,
 * shuffling, and dealing cards.
 */
public class Deck {

    /**A list to hold all 52 cards
     *
     */
    private List<Card> deck;

    /**
     * Constructs a deck of 52 cards with all combinations of suits and ranks.
     */
    public Deck() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    /**
     * Initializes the deck with all 52 cards, one for each combination
     * of Suit and Rank.
     */
    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck, randomizing the order of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Deals the top card from the deck. Removes and returns the card.
     *
     * @return the top card from the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card dealCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Cannot deal from an empty deck.");
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
