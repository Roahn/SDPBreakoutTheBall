package GamePlay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel  implements KeyListener,ActionListener
{
	
	
		private boolean play = false;
		private int score = 0;
		private Timer timer ;
		private int delay = 3;
		private int speed = 2;
		private int playerX = 310;
		private int ballPosX=124;
		private int ballPosY=350;
		private int ballYdir = -1;
		private int ballXdir = -2;
		
		public void moveRight()
		{
			play =true;
			playerX= playerX+20;
		}
		public void moveLeft()
		{
			play =true;
			playerX= playerX-20;
			
		}
		
	

		public void paint(Graphics g)
		{	
			//Background
			g.setColor(Color.black);
			g.fillRect(1, 1, 692, 592);
			
			//borders
			g.setColor(Color.yellow);
			g.fillRect(0,0,3,592);
			g.fillRect(0,0,692,3);
			g.fillRect(691,0,3,692);
			
			//paddle
			g.setColor(Color.green);
			g.fillRect(playerX, 550, 100, 8);
			
			//Ball
			g.setColor(Color.yellow);
			g.fillOval(ballPosX, ballPosY, 20, 20);
			
			
		}
	
		public void keyTyped(KeyEvent e) 
		{
			
		}

	
	
	
		public void keyReleased(KeyEvent e) 
		{
		
		
		}
	
		public void actionPerformed(ActionEvent e) 
		{
			timer.start();
			
			
			if(play)
			{
				if( new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(playerX,550,100,8)))
				{
					ballYdir= -ballYdir;
				}
				ballPosX = ballPosX+ (ballXdir*speed);
				ballPosY = ballPosY+ (ballYdir*speed);
				
				if(ballPosX<0)
				{
					ballXdir = -ballXdir;
				}
				if(ballPosY<0)
				{
					ballYdir = -ballYdir;
				}
				if(ballPosX>670)
				{
					ballXdir = -ballXdir;
				}
				
			}
			repaint();
			
		}
		
		
		public void keyPressed(KeyEvent e) 
		{
		
			if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			{
					if(playerX >=580)
					{
						playerX = 580;
					}
					else
					{
							
						moveRight();
					}
			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT)
			{
				if(playerX <= 10)
				{
					playerX = 10;
				}
				else
				{
						
					moveLeft();
				}
			}
		
		}
	




	
	public Gameplay()
	{	
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
			
	}

	
	
}
