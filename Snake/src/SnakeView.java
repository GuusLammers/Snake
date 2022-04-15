import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeView extends JFrame {
    
    int WINDOW_WIDTH;
    int WINDOW_HEIGHT;

    JPanel snakePanel;

    SnakeView(int GAME_WIDTH, int GAME_HEIGHT) {
        this.WINDOW_WIDTH = GAME_WIDTH;
        this.WINDOW_HEIGHT = GAME_HEIGHT;

        this.setTitle("Snake"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(this.WINDOW_HEIGHT, this.WINDOW_HEIGHT);
        this.setResizable(false);

        snakePanel = new SnakePanel(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
        this.add(snakePanel);
    }

}
