import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	final double GRAVITY = 0.94;
	final int paddleAccel = 2;
	
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	
	Ball b1;
	
	public AIPaddle(int player, Ball b) {
		upAccel = false; downAccel = false;
		y = HEIGHT/2 - paddleHeight/2;
		yVel = 0;
		
		b1 = b;
		
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
		
		y = b1.getY() - paddleHeight/2;
		
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
