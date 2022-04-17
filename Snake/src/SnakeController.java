import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeController {
    
    int GAME_SPEED = 100;

    SnakeModel snakeModel;
    SnakeView snakeView;

    boolean gameRunning = false;
    boolean firstRun = true;

    SnakeController(SnakeModel snakeModel, SnakeView snakeView) throws Exception {
        this.snakeModel = snakeModel;
        this.snakeView = snakeView;

        this.snakeView.addKeyListener(new KeyArrowListener());
        this.snakeView.addKeyListener(new SpaceBarListner());
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
            this.snakeView.snakePanel.updateScoreLabel(Integer.toString(this.snakeModel.getCurrentScore()));
            this.snakeView.snakePanel.refreshPanel();
        }
    }

    private void startGame() {
        /*
        Starts the game if it is not already running.
        */
        if(!gameRunning) {
            snakeModel.restart();
            createGameTimer();
            // if it is the first run remove the start menu and load the score board
            if(firstRun) {
                snakeView.snakePanel.destroyStartMenu();
                snakeView.snakePanel.createScoreLabel();
                firstRun = false;
            }
            gameRunning = true;
        }
    }

    private void createGameTimer() {
        /*
        Creates a timer that executes game updates at time intertvals of GAME_SPEED. 
        When this timer is running the game is running.
        */
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    updateGame();
                    // stop timer if snake is dead
                    if(!snakeModel.getIsAlive()) {
                        timer.cancel();
                        gameRunning = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          }, this.GAME_SPEED, this.GAME_SPEED);
    }

    public class KeyArrowListener extends KeyAdapter {
        /*
        A key pressed event listener that listens for arrow key inputs.
        */
        public void keyPressed(KeyEvent e) {
            try {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    snakeModel.setCurrentDirection("up");
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    snakeModel.setCurrentDirection("down");
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    snakeModel.setCurrentDirection("left");
                }   
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    snakeModel.setCurrentDirection("right");
                } 
            } catch(Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public class SpaceBarListner extends KeyAdapter {
        /*
        A key event listener that listens for the space bar to be pressed.
        */
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                startGame();
            }
        }
    }

}