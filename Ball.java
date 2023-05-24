import java.awt.*;

public class Ball extends Rectangle {

    // class variables
    public static final int BALL_DIAMETER = 20;
    private static int SPEED = 7;
    // score object
    private Score score;
    // variables
    private int velocityX, velocityY;
    private double rand, timer;

    // constructor
    public Ball(int x, int y) {
        super(x, y, BALL_DIAMETER, BALL_DIAMETER);
        initialMovement();
        timer = 0;
    }

    // method that sets the score in gamePanel
    public void setScore(Score scr) {
        score = scr;
    }

    // makes the ball go in a random direction after spawned
    private void initialMovement() {
        rand = Math.random(); // random number between 0 and 1
        // left or right
        if (rand > 0.5) {
            velocityX = SPEED;
        } else {
            velocityX = -SPEED;
        }
        // up or down
        if (rand > 0.5) {
            velocityY = SPEED;
        } else {
            velocityY = -SPEED;
        }
    }

    // check if the ball hits a paddle
    // if it does, reverse horizontal direction
    public void paddleCollision(Paddles paddle1, Paddles paddle2) {

        if (intersects(paddle1.getBounds2D()) || intersects(paddle2.getBounds2D())) {
            velocityX = -velocityX;
        }
    }

    public void screenCollision() {

        // check if the ball hits the top or bottom boundaries
        // if it does, reverse vertical direction
        if ((y <= 0) || (y >= GamePanel.GAME_HEIGHT - BALL_DIAMETER)) {
            velocityY = -velocityY;
        }

        // if the ball goes behind either paddles, give the opposite paddle a point
        if ((x <= 0) || (x >= GamePanel.GAME_WIDTH - BALL_DIAMETER)) {

            // wait 1.5 seconds before respawning 
            if ((System.currentTimeMillis() - timer) >= 1500) {
                if (x <= 0) {
                    score.updateScore2();
                } else {
                    score.updateScore1();
                }
                respawn(); // respawn ball
            }
        } else {
            timer = System.currentTimeMillis(); // reset the ball respawn timer
        }
    }

    // set a default position for the ball to start from
    public void respawn() {
        x = ((GamePanel.GAME_WIDTH / 2) - (BALL_DIAMETER / 2));
        y = ((GamePanel.GAME_HEIGHT / 2) - (BALL_DIAMETER / 2));
        initialMovement(); // choose random movement to start
    }

    // update movement
    public void move() {
        x += velocityX;
        y += velocityY;
    }

    // draw the ball
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }
}
