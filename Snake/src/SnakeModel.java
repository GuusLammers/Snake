import java.util.ArrayList;
import java.util.List;

public class SnakeModel {
    
    // constants
    int minX;
    int maxX;
    int minY;
    int maxY;

    // class fields
    List<Coordinate> snakeCoordinates;
    Coordinate preyCoordinate;
    String currentDirection = "right";
    int currentScore;
    boolean isAlive;

    SnakeModel(int GAME_WIDTH, int GAME_HEIGHT) {
        this.minX = 0;
        this.maxX = GAME_WIDTH / 20;
        this.minY = 0;
        this.maxY = GAME_HEIGHT / 20;

        restart();
    }

    public void restart() {
        /*
        Restarts the snake model. Resets snakeCoordinates, preyCoordinate, currentScore, and isAlive.
        */
        createSnake();
        createPrey();
        this.currentScore = 0;
        this.isAlive = true;
    }

    public void gameTick() throws Exception {
        /*
        Controls game progression. A game tick consists of the snake moving one step forward in its currentDirection.
        This method checks if the snake is still alive and if the prey has been eaten. If the prey is eaten it updates
        currentScore and generates a new preyCoordinate.
        */

        Coordinate newSnakeCoordinate = getNewSnakeCoordinate(); // fetch new snake coordinate
        
        if(!isAlive(newSnakeCoordinate)) {
            this.isAlive = false;
            return;
        }

        this.snakeCoordinates.add(newSnakeCoordinate);

        if(isPreyEaten(newSnakeCoordinate)) {
            this.currentScore++;
            createPrey();

        } else {
            this.snakeCoordinates.remove(0);
        }


    }

    private void createSnake() {
        /*
        Create a snake with an initial length of 5 units that starts in the middle of the screen. The head of the snake is
        represented by the coordinate at the end of the snakeCoordinates list.
        */
        int xCoordinate = ((int) this.maxX / 2) - 2; 
        int yCoordinate = (int) this.maxY / 2;

        this.snakeCoordinates = new ArrayList<Coordinate>();

        for(int i = 0; i < 5; i++) {
            this.snakeCoordinates.add(new Coordinate(xCoordinate, yCoordinate));
            xCoordinate++;
        }
    }

    private void createPrey() {
        /*
        Creates a new prey by randomly generating coordinates. New prey cannot spawn inside of snake.
        */

        while(true) {
            int x = getRandomNumber(this.minX, this.maxX);
            int y = getRandomNumber(this.minY, this.maxY);

            // check if newly generate coordinate is inside the snake. If it is generate a new one.
            for(Coordinate snakeCoordinate: snakeCoordinates) {
                if(snakeCoordinate.getX() == x && snakeCoordinate.getY() == y) {
                    continue;
                }
            }

            this.preyCoordinate = new Coordinate(x, y);
            break;
        }
    }

    private Coordinate getNewSnakeCoordinate() throws Exception {
        /*
        Returns the next snake coordinate. Computed using snakeCoordinates and currentDirection.
        */
        Coordinate snakeHead = this.snakeCoordinates.get(this.snakeCoordinates.size() - 1);
        switch(this.currentDirection) {
            case "left": 
                return new Coordinate(snakeHead.getX() - 1, snakeHead.getY());

            case "right": 
                return new Coordinate(snakeHead.getX() + 1, snakeHead.getY());

            case "up": 
                return new Coordinate(snakeHead.getX(), snakeHead.getY() - 1);
                
            case "down": 
                return new Coordinate(snakeHead.getX(), snakeHead.getY() + 1);
                
            default:
                throw new Exception("This is an invalid direction: " + this.currentDirection + "!");    
        }
    }

    private boolean isPreyEaten(Coordinate newSnakeCoordinate) {
        /*
        Returns true if the newSnakeCoordinate is the same as the preyCoordinate.
        */
        if(newSnakeCoordinate.getX() == this.preyCoordinate.getX() && newSnakeCoordinate.getY() == this.preyCoordinate.getY()) {
            return true;
        }

        return false;
    }

    private boolean isAlive(Coordinate newSnakeCoordinate) {
        /*
        Checks if the snake is still alive. The snake is dead if it goes out of bounds or if it eats itself.
        */
        // Check 1: Did snake go out of bounds.
        if(newSnakeCoordinate.getX() < this.minX || newSnakeCoordinate.getX() > maxX - 1 || newSnakeCoordinate.getY() < this.minY || newSnakeCoordinate.getY() > maxY - 1) {
            return false;
        }
        // Check 2: Did snake eat itself.
        for(Coordinate snakeCoordinate: snakeCoordinates) {
            if(snakeCoordinate.getX() == newSnakeCoordinate.getX() && snakeCoordinate.getY() == newSnakeCoordinate.getY()) {
                return false;
            }
        }

        return true;
    }

    public List<Coordinate> getSnakeCoordinates() {
        /*
        Returns snakeCoordiantes.
        */
        return this.snakeCoordinates;
    }

    public Coordinate getPreyCoordinates() {
        /*
        Returns prey coordinates.
        */
        return this.preyCoordinate;
    }

    public int getCurrentScore() {
        /*
        Returns currentScore.
        */
        return this.currentScore;
    }

    public boolean getIsAlive() {
        /*
        Returns isAlive.
        */
        return this.isAlive;
    }

    public void setCurrentDirection(String newDirection) throws Exception {
        /*
        Sets the snakes currentDirection to newDirection. Snake cannot turn 180 degrees into itself.
        */
        switch(newDirection) {
            case "left": 
                if(this.currentDirection == "right") {
                    return;
                }
                this.currentDirection = newDirection;

            case "right": 
                if(this.currentDirection == "left") {
                    return;
                }
                this.currentDirection = newDirection;

            case "up": 
                if(this.currentDirection == "down") {
                    return;
                }
                this.currentDirection = newDirection;
                
            case "down": 
                if(this.currentDirection == "up") {
                    return;
                }
                this.currentDirection = newDirection;
                
            // default:
            //     throw new Exception("This is an invalid direction: " + newDirection + "!");    
        }
    }

    private int getRandomNumber(int min, int max) {
        /*
        Helper method that generates a random number between min and max.
        */
        return (int) ((Math.random() * (max - min)) + min);
    }

}
