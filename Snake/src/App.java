public class App {

    // constants, make these values divisible by 10 to ensure proper rendering
    int GAME_WIDTH = 1000;
    int GAME_HEIGHT = 1000;

    public static void main(String[] args) throws Exception {
        SnakeModel snakeModel = new SnakeModel();
        SnakeView snakeView = new SnakeView();
        SnakeController snakeController = new SnakeController(snakeModel, snakeView);
    }
}
