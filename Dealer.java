package com.mycompany.blackjackgame;

package com.mycompany.blackjackgame;

/**
 * Represents the dealer in a Blackjack game.
 * The dealer has a hand of cards and follows specific rules for drawing cards.
 */
public class Dealer {
    private Hand hand; // The dealer's hand of cards

    /**
     * Constructs a Dealer with an empty hand.
     */
    public Dealer() {
        this.hand = new Hand();
    }

    /**
     * Draws a card from the deck and adds it to the dealer's hand.
     *
     * @param deck the deck from which to draw the card
     */
    public void drawCard(Deck deck) {
        Card card = deck.dealCard();
        hand.addCard(card);
    }

    /**
     * Returns the total value of the dealer's hand.
     *
     * @return the value of the dealer's hand
     */
    public int getHandValue() {
        return hand.getValue();
    }

    /**
     * Returns the dealer's hand.
     *
     * @return the dealer's hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Resets the dealer's hand to an empty hand for a new round.
     */
    public void resetHand() {
        hand = new Hand();
    }

    /**
     * Plays the dealer's turn by drawing cards until the hand value is at least 17.
     *
     * @param deck the deck from which to draw cards
     */
    public void playTurn(Deck deck) {
        while (getHandValue() < 17) {
            drawCard(deck);
        }
    }
}
