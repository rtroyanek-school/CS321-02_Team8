package com.mycompany.blackjackgame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GraphicalCard {

    private final Card card;  // Reference to the associated Card object
    private Image cardImage;

    // Constructor that takes a Card object
    public GraphicalCard(Card card) {
        this.card = card;
        loadCardImage();
    }

    // Load the card image using the path from the card object
    private void loadCardImage() {
        try {
            String cardPath = card.getImagePath(); // Example: "resizedCards/two_of_clubs.png"
            URL imageUrl = getClass().getClassLoader().getResource(cardPath);

            if (imageUrl != null) {
                cardImage = new ImageIcon(imageUrl).getImage();
                System.out.println("Successfully loaded image for: " + cardPath);
            } else {
                System.err.println("Error: Could not load image from path: " + cardPath);
            }
        } catch (Exception e) {
            System.err.println("Exception while loading card image: " + e.getMessage());
        }
    }

    // Draw the card in the given Graphics context
    public void draw(Graphics g, JPanel panel, int x, int y) {
        if (cardImage != null) {
            g.drawImage(cardImage, x, y, 80, 120, panel);
        } else {
            // Fallback: Draw a placeholder rectangle or error indicator
            g.setColor(Color.RED);
            g.fillRect(x, y, 80, 120);
            g.setColor(Color.BLACK);
            g.drawString("Image not found", x + 5, y + 60);
        }
    }
}
