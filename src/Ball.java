package src;
import java.awt.*;

public class Ball extends Rectangle {

	public final int SPEED = 7;
	public static final int BALL_DIAMETER = 20;

	public Ball(int x, int y) {
		super(x, y, BALL_DIAMETER, BALL_DIAMETER);
	}

	public void move() {
		y = y + SPEED;
		x = x + (int)(Math.random()*14);
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
	}

}