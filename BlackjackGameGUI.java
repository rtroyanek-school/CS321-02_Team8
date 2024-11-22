package com.mycompany.blackjackgame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BlackjackGameGUI {
    private JFrame frame;
    private JPanel dealerPanel, playerPanel, buttonPanel, statsPanel;
    private JLabel statsLabel, lossesLabel, tiesLabel, dealerQuoteLabel, statusLabel;
    private JButton hitButton, standButton, replayButton, resetButton;

    private Game game;
    private CardPanel dealerCardPanel, playerCardPanel;

    public BlackjackGameGUI() {
        game = new Game();

        frame = new JFrame("Blackjack Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0, 102, 0)); // Dark green background

        setupGUI();
        game.startGame();
        updateGUI();

        frame.setVisible(true);
    }

    private void setupGUI() {
        // Dealer Panel Setup
        dealerPanel = new JPanel();
        dealerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#FFCC00"), 2), "Dealer", 0, 0, new Font("Arial", Font.BOLD, 18), Color.decode("#FFFF99")));
        dealerPanel.setPreferredSize(new Dimension(600, 300));
        dealerPanel.setOpaque(true);
        dealerPanel.setBackground(new Color(0, 102, 0));
        dealerPanel.setLayout(new BorderLayout());

        dealerQuoteLabel = new JLabel("Dealer: \"Let's see if you can handle this...\"", SwingConstants.CENTER);
        dealerQuoteLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        dealerQuoteLabel.setForeground(Color.decode("#FFFF99")); // Light yellow color
        dealerPanel.add(dealerQuoteLabel, BorderLayout.SOUTH);

        dealerCardPanel = new CardPanel();
        dealerCardPanel.setBackground(new Color(0, 102, 0)); // Dark green background
        dealerPanel.add(dealerCardPanel, BorderLayout.CENTER);

        // Player Panel Setup
        playerPanel = new JPanel();
        playerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#FFCC00"), 2), "Player", 0, 0, new Font("Arial", Font.BOLD, 18), Color.decode("#FFFF99")));
        playerPanel.setPreferredSize(new Dimension(600, 300));
        playerPanel.setOpaque(true);
        playerPanel.setBackground(new Color(0, 102, 0));
        playerPanel.setLayout(new BorderLayout());

        playerCardPanel = new CardPanel();
        playerCardPanel.setBackground(new Color(0, 102, 0)); // Dark green background
        playerPanel.add(playerCardPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(new Color(0, 102, 0));
        hitButton = new JButton("Hit");
        hitButton.setBackground(Color.decode("#FFCC00")); // Dark yellow color
        hitButton.setForeground(Color.BLACK);
        hitButton.addActionListener(e -> handleHit());

        standButton = new JButton("Stand");
        standButton.setBackground(Color.decode("#FFCC00")); // Dark yellow color
        standButton.setForeground(Color.BLACK);
        standButton.addActionListener(e -> handleStand());

        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        playerPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Stats Panel Setup
        statsPanel = new JPanel();
        statsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#FFCC00"), 4), "Statistics", 0, 0, new Font("Arial", Font.BOLD, 18), Color.decode("#FFFF99")));
        statsPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setOpaque(true);
        statsPanel.setBackground(new Color(0, 102, 0));

        statsLabel = new JLabel("Wins: 0", SwingConstants.CENTER);
        statsLabel.setForeground(Color.decode("#FFFF99"));
        statsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lossesLabel = new JLabel("Losses: 0", SwingConstants.CENTER);
        lossesLabel.setForeground(Color.decode("#FFFF99"));
        lossesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lossesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        tiesLabel = new JLabel("Ties: 0", SwingConstants.CENTER);
        tiesLabel.setForeground(Color.decode("#FFFF99"));
        tiesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tiesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        replayButton = new JButton("Replay");
        replayButton.setBackground(Color.decode("#FFCC00")); // Dark yellow color
        replayButton.setForeground(Color.BLACK);
        replayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        replayButton.addActionListener(e -> replayGame());

        resetButton = new JButton("Reset");
        resetButton.setBackground(Color.decode("#FFCC00")); // Dark yellow color
        resetButton.setForeground(Color.BLACK);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.addActionListener(e -> resetGame());

        statsPanel.add(Box.createVerticalGlue());
        statsPanel.add(statsLabel);
        statsPanel.add(Box.createVerticalStrut(20));
        statsPanel.add(lossesLabel);
        statsPanel.add(Box.createVerticalStrut(20));
        statsPanel.add(tiesLabel);
        statsPanel.add(Box.createVerticalStrut(20));
        statsPanel.add(replayButton);
        statsPanel.add(Box.createVerticalStrut(10));
        statsPanel.add(resetButton);
        statsPanel.add(Box.createVerticalGlue());

        // Status Label
        statusLabel = new JLabel("Welcome to Blackjack!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        statusLabel.setForeground(Color.decode("#FFFF99")); // Light yellow color
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(0, 102, 0));

        // Add components to the frame
        frame.add(dealerPanel, BorderLayout.NORTH);
        frame.add(playerPanel, BorderLayout.CENTER);
        frame.add(statsPanel, BorderLayout.EAST);
        frame.add(statusLabel, BorderLayout.SOUTH);
    }

    private void handleHit() {
        game.playerHit();
        updateGUI();
        if (game.isGameOver()) {
            endGame();
        }
    }

    private void handleStand() {
        game.playerStand();
        updateGUI();
        endGame();
    }

    private void replayGame() {
        game.startGame();
        updateGUI();
        statusLabel.setText("New round started. Let's go!");
        dealerQuoteLabel.setText("Dealer: \"Let's see if you can handle this...\"");
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
    }

    private void resetGame() {
        game = new Game();
        game.startGame();
        updateGUI();
        statusLabel.setText("Game reset. Good luck!");
        dealerQuoteLabel.setText("Dealer: \"Let's see if you can handle this...\"");
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
    }

    private void updateGUI() {
        if (game.isGameOver()) {
            dealerCardPanel.setCards(game.getDealerHand().getCards()); // Show full dealer hand at the end
        } else {
            dealerCardPanel.setCards(List.of(game.getDealerHand().getCards().get(0))); // Show only one card during play
        }
        playerCardPanel.setCards(game.getPlayerHand().getCards());

        statsLabel.setText("Wins: " + game.getPlayerWins());
        lossesLabel.setText("Losses: " + game.getDealerWins());
        tiesLabel.setText("Ties: " + game.getTies());

        if (game.isGameOver()) {
            statusLabel.setText(game.getOutcome());
            updateDealerQuote();
        }
    }

    private void updateDealerQuote() {
        String outcome = game.getOutcome();

        if (outcome.contains("You win")) {
            dealerQuoteLabel.setText("Dealer: \"I guess you got lucky...\"");
        } else if (outcome.contains("Dealer wins")) {
            dealerQuoteLabel.setText("Dealer: \"Victory is mine!\"");
        } else if (outcome.contains("tie")) {
            dealerQuoteLabel.setText("Dealer: \"It's a draw. Not bad!\"");
        } else {
            dealerQuoteLabel.setText("Dealer: \"Let's see if you can handle this...\"");
        }
    }

    private void endGame() {
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
    }

    class CardPanel extends JPanel {
        private List<Card> cards;

        public void setCards(List<Card> cards) {
            this.cards = cards;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (cards != null) {
                int x = 20;
                for (Card card : cards) {
                    GraphicalCard graphicalCard = card.toGraphicalCard();
                    graphicalCard.draw(g, this, x, 20);
                    x += 90; // Adjust spacing between cards
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlackjackGameGUI::new);
    }
}
