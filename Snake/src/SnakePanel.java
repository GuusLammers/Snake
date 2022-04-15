import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {
    
    int WINDOW_WIDTH;
    int WINDOW_HEIGHT;
    int columns;
    int rows;
    int columnWidth = 10;
    int rowWidth = 10;

    

    SnakePanel(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        this.columns = this.WINDOW_WIDTH / this.columnWidth;
        this.rows = this.WINDOW_HEIGHT / this.rowWidth;

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(this.WINDOW_WIDTH, this.WINDOW_HEIGHT));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        
    }

}
