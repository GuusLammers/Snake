import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainMenuPanel extends JPanel {
    
    int WINDOW_WIDTH;
    int WINDOW_HEIGHT;

    JLabel gameTitleLabel;
    JButton startGameButton;

    MainMenuPanel(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        this.setPreferredSize(new Dimension(this.WINDOW_WIDTH, this.WINDOW_HEIGHT));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(200, 150, 200, 150)));

        createGameTitleLabel();
        createStartGameButton();
    }

    private void createGameTitleLabel() {
        /*
        Creates and adds the game title label to the panel.
        */
        this.gameTitleLabel = new JLabel("Snake");
        this.gameTitleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
        this.gameTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.gameTitleLabel);
    }

    private void createStartGameButton() {
        /*
        Creates and adds the start game button to the panel.
        */
        this.startGameButton = new JButton();

        JLabel startGameButtonLabel = new JLabel("Play", SwingConstants.CENTER);
        startGameButtonLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
        this.startGameButton.add(startGameButtonLabel);
        
        this.startGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(startGameButton);
    }

}
