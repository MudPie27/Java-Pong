package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public Thread gameThread;
    public Image image;
    public Graphics graphics;
    public Paddles paddle1, paddle2;
    public Ball ball;
    public Score score; // Score object

    public GamePanel() {
        paddle1 = new Paddles(0, (GAME_HEIGHT/2)-(Paddles.length/2));
        paddle2 = new Paddles(790, (GAME_HEIGHT/2)-(Paddles.length/2));
        ball = new Ball(380, 250);
        score = new Score(); // Create an instance of Score
        ball.setScore(score); // Pass the Score object to the Ball object

        this.setFocusable(true);
        this.addKeyListener(this);

        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paint(Graphics g) {
        image = createImage(GAME_WIDTH, GAME_HEIGHT);
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    private void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g); // Draw the score
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long now;

        while (true) {
            now = System.nanoTime();
            delta = delta + (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public void checkCollision() {
        if (paddle1.y <= 0) {
            paddle1.y = 0;
        }
        if (paddle1.y >= GAME_HEIGHT - Paddles.length) {
            paddle1.y = GAME_HEIGHT - Paddles.length;
        }

        if (paddle2.y <= 0) {
            paddle2.y = 0;
        }
        if (paddle2.y >= GAME_HEIGHT - Paddles.length) {
            paddle2.y = GAME_HEIGHT - Paddles.length;
        }
        ball.boundaryCollision(); // Check ball boundary collision
        ball.paddleCollision(paddle1, paddle2); // Check ball paddle collision
    }

    @Override
    public void keyPressed(KeyEvent e) {
        paddle1.keyPressed1(e);
        paddle2.keyPressed2(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        paddle1.keyReleased1(e);
        paddle2.keyReleased2(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
