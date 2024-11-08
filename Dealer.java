package com.mycompany.blackjackgame;

public class Dealer {
    private Hand hand;  // The dealer's hand of cards
    private Deck deck;  // The deck used in the game

    // Constructor to initialize the dealer's hand and the deck
    public Dealer(Deck deck) {
        this.hand = new Hand();
        this.deck = deck;
    }

    // Dealer's turn: hits until hand value reaches 17 or higher
    public void playTurn() {
        System.out.println("Dealer's turn:");
        while (hand.getHandValue() < 17) {
            Card newCard = deck.dealCard();
            hand.addCard(newCard);
            System.out.println("Dealer draws: " + newCard);
        }
    }

    // Shows the dealer's first card (for players to see)
    public void showInitialCard() {
        if (!hand.getCards().isEmpty()) {
            System.out.println("Dealer shows: " + hand.getCards().get(0));
        }
    }

    // Reveal the dealer's full hand at the end of the round
    public void revealHand() {
        System.out.println("Dealer's full hand: " + hand + " (Total: " + hand.getHandValue() + ")");
    }

    // Get the dealer's hand value for comparisons
    public int getHandValue() {
        return hand.getHandValue();
    }

    // Accessor to get the dealer's hand
    public Hand getHand() {
        return hand;
    }

    // Resets the dealer's hand for a new round
    public void resetHand() {
        hand.clear();
    }

    // Checks if the dealer has a blackjack (initial Ace and 10-value card)
    public boolean hasBlackjack() {
        return hand.getHandValue() == 21 && hand.getCards().size() == 2;
    }
}
