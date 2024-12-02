package com.mycompany.blackjackgame;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class GraphicalCard {

    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    public static final int JOKER = 4;

    private final int suit;
    private final int value;

    private static Image cardImage;
    private static boolean imageLoaded;

    public GraphicalCard(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public void draw(Graphics g, JPanel panel, int x, int y) {
        String cardPath = card.getImagePath();
        Image cardImage = new ImageIcon().getImage();
        g.drawImage(cardImage, x, y, 80, 120, panel); 
    }

    private boolean findImage() {
        if (imageLoaded)
            return (cardImage != null);
        imageLoaded = true;
        ClassLoader cl = GraphicalCard.class.getClassLoader();
        URL imageURL = cl.getResource("cards.png");
        if (imageURL == null)
            return false;
        cardImage = Toolkit.getDefaultToolkit().createImage(imageURL);
        return (cardImage != null);
    }

    private String getSuitAsString() {
        switch (suit) {
            case SPADES: return "Spades";
            case HEARTS: return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS: return "Clubs";
            default: return "Joker";
        }
    }

    private String getValueAsString() {
        if (suit == JOKER)
            return "Joker";
        else {
            switch (value) {
                case 1: return "Ace";
                case 11: return "Jack";
                case 12: return "Queen";
                case 13: return "King";
                default: return String.valueOf(value);
            }
        }
    }
}
