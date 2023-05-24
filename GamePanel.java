/*
 ICS4U1-3 GUI assignment
 PONG
 Challenge feature: music
 Aseer Baset
 23/05/2023
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    // set game screen size
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    // objects
    public Thread gameThread;
    public Image image;
    public Graphics graphics;
    public Paddles paddle1, paddle2;
    public Ball ball;
    public Score score;

    // constructor
    public GamePanel() {

        // create 2 paddles and set their position
        paddle1 = new Paddles(0, (GAME_HEIGHT / 2) - (Paddles.length / 2));
        paddle2 = new Paddles(790, (GAME_HEIGHT / 2) - (Paddles.length / 2));
        // creat a ball and set it's position
        ball = new Ball(380, 250);
        // creat a score object
        score = new Score();
        ball.setScore(score); // set default score

        this.setFocusable(true);
        this.addKeyListener(this);

        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        gameThread = new Thread(this);
        gameThread.start();
    }

    // paint method 
    public void paint(Graphics g) {
        image = createImage(GAME_WIDTH, GAME_HEIGHT);
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    private void draw(Graphics g) {
        // draw all the created objects from the constructor 
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    // call associated move methods for each objects movement
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();

        // check to see if game end conditions are met
        if (Score.gameOver) {
            gameEnd(); // if met, run gameEnd method
        }
    }
    
    // collision 
    public void checkCollision() {

        // collission for the paddles so they don't go out of the screen
        if (paddle1.y <= 0)
            paddle1.y = 0;

        if (paddle1.y >= (GAME_HEIGHT - Paddles.length))
            paddle1.y = (GAME_HEIGHT - Paddles.length);

        if (paddle2.y <= 0)
            paddle2.y = 0;

        if (paddle2.y >= (GAME_HEIGHT - Paddles.length))
            paddle2.y = (GAME_HEIGHT - Paddles.length);

        ball.screenCollision(); // ball collision with the game frame
        ball.paddleCollision(paddle1, paddle2); // ball collision with the paddles
    }

    // Makes the objects freeze in there default positions to stop thw game 
    private void gameEnd() {
        paddle1 = new Paddles(0, (GAME_HEIGHT / 2) - (Paddles.length / 2));
        paddle2 = new Paddles(790, (GAME_HEIGHT / 2) - (Paddles.length / 2));
        ball.respawn();
    }
    // run the game loop
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

            if (delta >= 1) { // run necessary methods in the loop
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    // Key press listeners 
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
