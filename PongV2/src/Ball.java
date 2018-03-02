import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	final int ballWidth = 20, ballHeight = 20;
	
	double xVel, yVel, x, y;
	
	public Ball() {
		x = WIDTH/2;
		y = HEIGHT/2;
		xVel = -4;
		yVel = 5;
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
	
	public void checkCollision(Paddle p1) {
		if(x <= 50 + paddleWidth + 10) {
			if(p1.getY() <= y && p1.getY() + paddleHeight >= y) {
				xVel = -xVel;
			}
		}
		else if(x >= WIDTH - 50 - paddleWidth - 10) {
			if(p1.getY() <= y && p1.getY() + paddleHeight >= y) {
				xVel = -xVel;
			}
		}
	}
	
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	
}
