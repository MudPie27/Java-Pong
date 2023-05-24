package src;
import java.awt.*;
import java.awt.event.*;

public class Paddles extends Rectangle {
	// class varaibles
	public static int length = 100, width = 10;
	// regular variables
	public int velocity; 
	public final int SPEED = 15; 
	
	// constructor 
	public Paddles(int x, int y) {
	   super(x, y, width, length);
	}
	
	// controls for player 1 (left paddle)
	public void keyPressed1(KeyEvent e) {

	    if(e.getKeyChar() == 'w'){
			updateVelocity(-SPEED); // method that updates velocity depending on which key is pressed
			move(); // method that moves the paddle accordingly 
	    }

	    if(e.getKeyChar() == 's'){
			updateVelocity(SPEED);
			move();
	    }
	}

	 public void keyReleased1(KeyEvent e) {

		if(e.getKeyChar() == 'w'){
	    	updateVelocity(0);
	    	move();
	    }

	    if(e.getKeyChar() == 's'){
			updateVelocity(0);
			move();
	    }
	}
	
	// controls for player 2 (right paddle)
	public void keyPressed2(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_UP){
			updateVelocity(-SPEED);
			move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	    	updateVelocity(SPEED);
			move();
	    }
	}
	
	public void keyReleased2(KeyEvent e) {

	    if(e.getKeyCode() == KeyEvent.VK_UP){
			updateVelocity(0);
			move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
			updateVelocity(0);
			move();
	    }
	}
	
	// sets velocity to 0, 15 or =15 depending on which button is pressed/released
	public void updateVelocity(int speed) {
		velocity = speed;
    }
	
	// moves the paddle according to velocity 
	public void move() {
	    y = y + velocity;
    }
	
	// displays the paddles
	public void draw(Graphics g) {
	    g.setColor(Color.white);
	    g.fillRect(x, y, width, length);
    }
}