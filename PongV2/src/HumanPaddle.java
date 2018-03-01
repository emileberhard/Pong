import java.awt.Graphics;

public class HumanPaddle implements Paddle{
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;

	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	
	public HumanPaddle(int player) {
		upAccel = false; downAccel = false;
		y = HEIGHT/2 - paddleHeight/2;
		yVel = 0;
		if(player == 1) {
			x = 30;
		}
		else
			x = 660;
	}
	
	public void draw(Graphics g) {
		
	}

	public void move() {
		
	}

	public int getY() {
		return (int)y;
	}
}
