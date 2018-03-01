import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	final double GRAVITY = 0.94;
	final int paddleAccel = 2;
	
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	
	public HumanPaddle(int player) {
		upAccel = false; downAccel = false;
		y = HEIGHT/2 - paddleHeight/2;
		yVel = 0;
		if(player == 1) {
			x = 50;
		}
		else
			x = WIDTH - 50 - paddleWidth;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, (int)y, paddleWidth, paddleHeight);
	}

	public void move() {
		if(upAccel) {
			yVel -= paddleAccel;
		}
		
		if(downAccel) {
			yVel += paddleAccel;
		}
		
		if(!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		
		if(yVel > 5)
			yVel = 5;
		else if(yVel < -5)
			yVel = -5;
		
		y += yVel;
		
		if(y < 0)
			y = 0;
		
		if(y > HEIGHT - paddleHeight)
			y = HEIGHT - paddleHeight;
	}
	
	public void setUpAccel(Boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(Boolean input) {
		downAccel = input;
	}

	public int getY() {
		return (int)y;
	}
}
