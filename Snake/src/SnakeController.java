import java.util.Timer;
import java.util.TimerTask;

public class SnakeController {
    
    int GAME_SPEED = 100;

    SnakeModel snakeModel;
    SnakeView snakeView;

    SnakeController(SnakeModel snakeModel, SnakeView snakeView) throws Exception {
        this.snakeModel = snakeModel;
        this.snakeView = snakeView;

        //this.snakeView.snakePanel.addKeyListener(new ArrowKeyListener());

        createGameTimer();
    }

    private void updateGame() throws Exception {
        /*
        Updates the snake and the prey if the snake is still alive
        */
        if(this.snakeModel.getIsAlive()) {
            this.snakeModel.gameTick();
            this.snakeView.snakePanel.resetTilesColors();
            this.snakeView.snakePanel.updateSnake(this.snakeModel.getSnakeCoordinates());
            this.snakeView.snakePanel.updatePrey(this.snakeModel.getPreyCoordinates());
            this.snakeView.snakePanel.refreshPanel();
        }
    }

    private void createGameTimer() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    updateGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          }, this.GAME_SPEED, this.GAME_SPEED);
    }

}
