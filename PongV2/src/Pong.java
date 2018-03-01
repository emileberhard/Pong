import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener{
	
	final int WIDTH = 1000, HEIGHT = 550;
	final int paddleWidth = 20, paddleHeight = 100;
	
	Thread thread;
	
	// test för syncen 
	
	// branch?
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		
		this.addKeyListener(this);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.green);
		g.fillRect(30, HEIGHT/2-paddleHeight/2, paddleWidth, paddleHeight);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			
			
			
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			
		}
		if(key == KeyEvent.VK_DOWN) {
			
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			
		}
		if(key == KeyEvent.VK_DOWN) {
			
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
