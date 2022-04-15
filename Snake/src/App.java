public class App {

    public static void main(String[] args) throws Exception {
        // constants, make these values divisible by 10 to ensure proper rendering
        int GAME_WIDTH = 1000;
        int GAME_HEIGHT = 1000;
        
        SnakeModel snakeModel = new SnakeModel(GAME_WIDTH, GAME_HEIGHT);
        SnakeView snakeView = new SnakeView();
        SnakeController snakeController = new SnakeController(snakeModel, snakeView);
    }
}