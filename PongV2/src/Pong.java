import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {
	
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	
	int p1Score = 0, p2Score = 0;
	int p1RectWidth = 62, p2RectWidth = 62;
	
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setVisible(true);
		
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.white);
		
		g.fillRect(WIDTH - 220, 10, p2RectWidth, 72);
		g.fillRect(158, 10, p1RectWidth, 72);
		g.fillOval(WIDTH/2 - 75, HEIGHT/2 - 75, 150, 150);
		
		g.setColor(Color.black);
		
		g.fillRect(WIDTH - 218, 12, p2RectWidth-4, 68);
		g.fillRect(160, 12, p1RectWidth-4, 68);
		g.fillOval(WIDTH/2 - 73, HEIGHT/2 - 73, 146, 146);
		
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.BOLD, 60));
		g.drawString(Integer.toString(p1Score), 174, 65);
		g.drawString(Integer.toString(p2Score), WIDTH - 203, 65);
		g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
		
		p1.draw(g);
		p2.draw(g);
		b1.draw(g);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			
			if(!(b1.getX() < 50 + paddleWidth) && !(b1.getX() > WIDTH - 50 - paddleWidth)) {
				b1.checkCollision(p1, p2);
			}
			
			p1.move();
			p2.move();
			b1.move();
			
			if(b1.p1ScoreBool(b1)) {
				p1Score++;
				b1.reset();
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}else if(b1.p2ScoreBool(b1)) {
				p2Score++;
				b1.reset();
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(p1Score > 9 && p1Score < 11) {
				p1RectWidth = 95;
			}
			if(p2Score > 9 && p2Score < 11) {
				p2RectWidth = 95;
			}
			
			repaint();
						
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		if(key == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
