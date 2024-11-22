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

    public void draw(Graphics g, Component component, int x, int y) {
        if (findImage()) {
            int cx;    // x-coord of upper left corner of the card inside cardImage
            int cy;    // y-coord of upper left corner of the card inside cardImage
            switch (suit) {
                case CLUBS:    cy = 0; break;
                case DIAMONDS: cy = 123; break;
                case HEARTS:   cy = 2 * 123; break;
                case SPADES:   cy = 3 * 123; break;
                default:       cy = 4 * 123;   // Joker
            }
            if (suit == JOKER) {
                if (value == 1)
                    cx = 0;
                else
                    cx = 79;
            } else {
                cx = (value - 1) * 79;
            }
            g.drawImage(cardImage, x, y, x + 79, y + 123, cx, cy, cx + 79, cy + 123, component);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 79, 120);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 78, 119);
            g.drawString(getValueAsString(), x + 10, y + 30);
            g.drawString("of", x + 20, y + 60);
            g.drawString(getSuitAsString(), x + 10, y + 90);
        }
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
