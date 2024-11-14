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
            
            // Optional personality message during the dealer's turn
            if (hand.getHandValue() < 17) {
                System.out.println("Dealer mutters, 'Better play it safe...'");
            }
        }
    }

    // Shows the dealer's first card (for players to see)
    public void showInitialCard() {
    if (!hand.getCards().isEmpty()) {
        System.out.println("Dealer shows: " + hand.getCards().get(0));
        System.out.println("Dealer says, 'Let's see if you can handle this...'");
    }
}


    // Reveal the dealer's full hand at the end of the round
    public void revealHand() {
        System.out.println("Dealer's full hand: " + hand + " (Total: " + hand.getHandValue() + ")");
    }

    // Check if the dealer has a blackjack (initial Ace and 10-value card)
    public boolean hasBlackjack() {
        return hand.getHandValue() == 21 && hand.getCards().size() == 2;
    }

    // Personality reaction if dealer wins
    public void reactToWin() {
        System.out.println("Dealer says smugly, 'Victory is mine!'");
    }

    // Personality reaction if dealer loses
    public void reactToLoss() {
        System.out.println("Dealer sighs, 'I guess you got lucky...'");
    }

    // Personality reaction if player busts
    public void reactToPlayerBust() {
        System.out.println("Dealer laughs, 'Better luck next time!'");
    }

    // Accessor to get the dealer's hand
    public Hand getHand() {
        return hand;
    }

    // Resets the dealer's hand for a new round
    public void resetHand() {
        hand.clear();
    }

    // Get the dealer's hand value for comparisons
    public int getHandValue() {
        return hand.getHandValue();
    }
}
