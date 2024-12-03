package com.mycompany.blackjackgame;

public class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

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

    public String getImagePath() {
    // Convert rank and suit to lowercase for compatibility with the filename convention
    String rankName = rank.name().toLowerCase();
    String suitName = suit.name().toLowerCase();
    return "resizedCards/" + rankName + "_of_" + suitName + ".png";
}


    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
