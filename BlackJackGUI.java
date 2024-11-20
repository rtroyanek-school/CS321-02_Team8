/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack.gui;
import javax.swing.*;
import java.awt.*;

/**
 * @author rtroyanek
 * Handles initializing the GUI and allowing users to interact with it. Updates
 * game-play based on user actions.
 */
public class BlackJackGUI {

    private JFrame frame;
    private JPanel panel;
    private JPanel playerCardPanel;
    private JPanel dealerCardPanel;
    private JButton hitButton;
    private JButton standButton;
    private Game game;
    
    /**
     * Initializes the window in which the GUI sits.
     */
    
    public BlackJackGUI(Game game) {
        this.game = game;
        frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        setupPanels();
        setupButtons();
    }

    /**
     * Controls where the User's and Dealer's cards are displayed.
     */
    private void setupPanels() {
        playerCardPanel = new JPanel();
        dealerCardPanel = new JPanel();
        panel.add(playerCardPanel, BorderLayout.SOUTH);
        panel.add(dealerCardPanel, BorderLayout.NORTH);
    }

    /**
     * Initializes the buttons to allow the player to make decisions.
     */
    private void setupButtons() {
        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        hitButton.addActionListener(e -> game.playerHit());
        standButton.addActionListener(e -> game.playerStand());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        panel.add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Takes a card and where it should be displayed and places the card in the
     * game window.
     */
    private void displayCard(String cardName, JPanel cardPanel) {
        ImageIcon cardIcon = new ImageIcon("path/to/cards/" + cardName + ".png");
        JLabel cardLabel = new JLabel(cardIcon);
        cardPanel.add(cardLabel);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Displays the game window.
     */
    public void display() {
        frame.setVisible(true);
    }
}
