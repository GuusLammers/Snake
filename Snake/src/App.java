public class App {

    public static void main(String[] args) throws Exception {
        // constants, make these values divisible by 10 to ensure proper rendering
        int GAME_WIDTH = 500;
        int GAME_HEIGHT = 500 ;
        
        SnakeModel snakeModel = new SnakeModel(GAME_WIDTH, GAME_HEIGHT);
        SnakeView snakeView = new SnakeView(GAME_WIDTH, GAME_HEIGHT);
        new SnakeController(snakeModel, snakeView);

        snakeView.setLocationRelativeTo(null);
        snakeView.setVisible(true);
    }

}
