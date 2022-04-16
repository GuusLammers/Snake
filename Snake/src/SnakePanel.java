import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.BorderLayout;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakePanel extends JPanel {
    
    int WINDOW_WIDTH;
    int WINDOW_HEIGHT;

    JLabel scoreLabel;

    Color baseTileColor = Color.white;
    Color snakeColor = Color.blue;
    Color preyColor = Color.green;

    Tile[][] tiles; // [row][column]

    SnakePanel(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        this.setPreferredSize(new Dimension(this.WINDOW_WIDTH, this.WINDOW_HEIGHT));
        this.setLayout(new BorderLayout());

        createScoreLabel();

        initializeTiles();
    }

    public void paintComponent(Graphics g) {
        /*
        Paints all componenents onto JPanel.
        */
        Graphics2D g2D = (Graphics2D) g;

        for(int row = 0; row < this.tiles.length; row++) {
            for(int column = 0; column < this.tiles[row].length; column++) {
                Tile tile = this.tiles[row][column];
                g2D.setColor(tile.getColor());
                g2D.fill(tile.getTile());
            }
        }
        
    }

    public void refreshPanel() {
        /*
        Refreshes the panel.
        */
        this.revalidate();
        this.repaint();
    }

    private void initializeTiles() {
        /*
        Initializes the tiles that make up the snakes filed of play.
        */
        int columnWidth = 20;
        int rowWidth = 20;
        int columns = this.WINDOW_WIDTH / columnWidth;
        int rows = this.WINDOW_HEIGHT / rowWidth;

        this.tiles = new Tile[rows][columns];
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                int x = column * columnWidth;
                int y = row * rowWidth;
                Rectangle2D square = new Rectangle2D.Double(x, y, columnWidth, rowWidth);
                this.tiles[row][column] = new Tile(square, baseTileColor);
            }
        }
    }

    public void resetTilesColors() {
        /*
        Resets all tile colors back to baseTileColor.
        */
        for(int row = 0; row < this.tiles.length; row++) {
            for(int column = 0; column < this.tiles[row].length; column++) {
                Tile tile = this.tiles[row][column];
                if(tile.getColor() != baseTileColor) {
                    tile.setColor(Color.white);
                }
            }
        }
    }

    public void updateSnake(List<Coordinate> snakeCoordiantes) {
        /*
        Colors the passed in snakeCoordinates to snakeColor.
        */
        for(Coordinate snakeCoordinate: snakeCoordiantes) {
            Tile tile = this.tiles[snakeCoordinate.getY()][snakeCoordinate.getX()];
            tile.setColor(snakeColor);
        }
    }

    public void updatePrey(Coordinate preyCoordinate) {
        /*
        Colors the passed in preyCoordinate to preyColor.
        */
        Tile tile = this.tiles[preyCoordinate.getY()][preyCoordinate.getX()];
        tile.setColor(preyColor);
    }

    public void updateScoreLabel(String score) {
        /*
        Updates the scoreLabel to the argument score.
        */
        this.scoreLabel.setText(score);
    }

    private void createScoreLabel() {
        /*
        Instantiates scoreLabel with a score of 0 and centers it in the middle of the screen.
        */
        this.scoreLabel = new JLabel("0");
        this.scoreLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
        this.scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        this.scoreLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(this.scoreLabel, BorderLayout.CENTER);
    }

}
