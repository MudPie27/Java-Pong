package src;

import java.awt.*;

public class Ball extends Rectangle {
    public static final int BALL_DIAMETER = 20;
    private static final int SPEED = 7;

	private Score score;

    private int velocityX;
    private int velocityY;
    private double rand, timer;

    public Ball(int x, int y) {
        super(x, y, BALL_DIAMETER, BALL_DIAMETER);
        randomVelocity();
        timer = 0;
    }

	public void setScore(Score score) {
        this.score = score;
    }
	
    private void randomVelocity() {
		rand = Math.random();

        if (rand < 0.5) {
            velocityX = -SPEED;
        } else {
            velocityX = SPEED;
        }

        if (rand < 0.5) {
            velocityY = -SPEED;
        } else {
            velocityY = SPEED;
        }
    }

    public void move() {
        x += velocityX;
        y += velocityY;
    }

	public void paddleCollision(Paddles paddle1, Paddles paddle2) {
        if (intersects(paddle1) || intersects(paddle2)) {
            velocityX = -velocityX; // Reverse the horizontal velocity
        }
    }

    public void boundaryCollision() {
        if (y <= 0 || y >= GamePanel.GAME_HEIGHT - BALL_DIAMETER) {
            velocityY = -velocityY; // Reverse the vertical velocity
        }

        // Check if the ball has gone off-screen
		if (x <= 0 || x >= GamePanel.GAME_WIDTH - BALL_DIAMETER) {
            if (System.currentTimeMillis() - timer >= 1500) {
                if (x <= 0) {
                    score.updateScore2(); // Increment Player 2 score
                } else {
                    score.updateScore1(); // Increment Player 1 score
                }
                respawn();
            }
        } else {
            timer = System.currentTimeMillis(); // Update the respawn time
        }
    }

    public void respawn() {
        x = GamePanel.GAME_WIDTH / 2 - BALL_DIAMETER / 2;
        y = GamePanel.GAME_HEIGHT / 2 - BALL_DIAMETER / 2;
        randomVelocity();
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
    }
}
