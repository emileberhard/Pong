import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	final int ballWidth = 20, ballHeight = 20;
	Random r = new Random();
	
	double xVel, yVel, x, y;
	int direction = r.nextInt(2);
	
	public Ball() {
		x = WIDTH/2;
		y = HEIGHT/2;
		System.out.println(direction);
		
		if(direction == 0) {
			xVel = 2 + (10 * r.nextDouble());
		}else if(direction == 1) {
			xVel = -2 + (-10 * r.nextDouble());
		}
		yVel = 2 + (7 * r.nextDouble());
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((int)x - 10, (int)y -10, ballWidth, ballHeight);
	}
	
	public void move() {
		x += xVel;
		y += yVel;
		
		if(y + ballHeight/2 > HEIGHT) {
			y = HEIGHT - ballHeight/2;
			yVel = -yVel;
		}
		if(y - ballHeight/2 < 0) {
			y = ballHeight/2;
			yVel = -yVel;
		}
	}
	
	public void checkCollision(Paddle p1, Paddle p2) {
		if(x <= 50 + paddleWidth + 10) {
			if(p1.getY() <= y && p1.getY() + paddleHeight >= y) {
				xVel = -xVel;
			}
		}
		else if(x >= WIDTH - 50 - paddleWidth - 10) {
			if(p2.getY() <= y && p2.getY() + paddleHeight >= y) {
				xVel = -xVel;
			}
		}
	}
	
	public boolean p1ScoreBool(Ball b1) {
		if(b1.getX() > WIDTH) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean p2ScoreBool(Ball b1) {
		if(b1.getX() + ballWidth/2 < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reset() {
		x = WIDTH/2;
		y = HEIGHT/2;
		direction = r.nextInt(2);
		
		if(direction == 0) {
			xVel = 2 + (10 * r.nextDouble());
		}else if(direction == 1) {
			xVel = -2 + (-10 * r.nextDouble());
		}
		
		yVel = 2 + (7 * r.nextDouble());
	}
	
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	
}
