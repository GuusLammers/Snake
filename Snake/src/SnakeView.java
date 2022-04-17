import javax.swing.JFrame;

public class SnakeView extends JFrame {
    
    int WINDOW_WIDTH;
    int WINDOW_HEIGHT;

    SnakePanel snakePanel;

    SnakeView(int GAME_WIDTH, int GAME_HEIGHT) {
        this.WINDOW_WIDTH = GAME_WIDTH;
        this.WINDOW_HEIGHT = GAME_HEIGHT;

        this.setTitle("Snake"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(this.WINDOW_HEIGHT, this.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setUndecorated(true);

        this.snakePanel = new SnakePanel(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
        this.add(this.snakePanel);
    }

}
