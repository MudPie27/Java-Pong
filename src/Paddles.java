package src;
import java.awt.*;
import java.awt.event.*;

public class Paddles extends Rectangle {
	
	public int velocity;
	public final int SPEED = 15; 
	public static int length = 100, width = 10;
	
	public Paddles(int x, int y){
	   super(x, y, width, length);
	}
	
	public void keyPressed1(KeyEvent e) {

	    if(e.getKeyChar() == 'w'){
	      changeDir(-SPEED);
	      move();
	    }

	    if(e.getKeyChar() == 's'){
	      changeDir(SPEED);
	      move();
	    }
	  }

	  public void keyReleased1(KeyEvent e) {

	    if(e.getKeyChar() == 'w'){
	      changeDir(0);
	      move();
	    }

	    if(e.getKeyChar() == 's'){
	      changeDir(0);
	      move();
	    }
	  }
	
	public void keyPressed2(KeyEvent e) {

	    if(e.getKeyCode() == KeyEvent.VK_UP){
	      changeDir(-SPEED);
	      move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	      changeDir(SPEED);
	      move();
	    }
	  }
	
	public void keyReleased2(KeyEvent e) {

	    if(e.getKeyCode() == KeyEvent.VK_UP){
	      changeDir(0);
	      move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	      changeDir(0);
	      move();
	    }
	  }
	
	 public void changeDir(int speed) {
	    velocity = speed;
     }
	 
	 public void move() {
	    y = y + velocity;
     }
	 
	  public void draw(Graphics g) {
	    g.setColor(Color.white);
	    g.fillRect(x, y, width, length);
     }
}