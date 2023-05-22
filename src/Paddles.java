package src;
import java.awt.*;
import java.awt.event.*;

public class Paddles extends Rectangle {
	
	public int yVelocity;
	public final int SPEED = 15; 
	public static int length = 100, width = 10;
	
	public Paddles(int x, int y){
	   super(x, y, width, length);
	}
	
	public void keyPressed1(KeyEvent e){

	    if(e.getKeyChar() == 'w'){
	      setYDirection(SPEED*-1);
	      move();
	    }

	    if(e.getKeyChar() == 's'){
	      setYDirection(SPEED);
	      move();
	    }
	  }
	
	public void keyReleased1(KeyEvent e){

	    if(e.getKeyChar() == 'w'){
	      setYDirection(0);
	      move();
	    }

	    if(e.getKeyChar() == 's'){
	      setYDirection(0);
	      move();
	    }
	  }
	
	public void keyPressed2(KeyEvent e){

	    if(e.getKeyCode() == KeyEvent.VK_UP){
	      setYDirection(SPEED*-1);
	      move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	      setYDirection(SPEED);
	      move();
	    }
	  }
	
	public void keyReleased2(KeyEvent e){

	    if(e.getKeyCode() == KeyEvent.VK_UP){
	      setYDirection(0);
	      move();
	    }

	    if(e.getKeyCode() == KeyEvent.VK_DOWN){
	      setYDirection(0);
	      move();
	    }
	  }
	
	 public void setYDirection(int yDirection){
	    yVelocity = yDirection;
     }
	 
	 public void move(){
	    y = y + yVelocity;
     }
	 
	  public void draw(Graphics g){
	    g.setColor(Color.white);
	    g.fillRect(x, y, width, length);
     }
}