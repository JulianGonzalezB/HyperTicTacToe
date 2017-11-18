import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainBoard extends JPanel
{
	public MainBoard()
	{
		
	}
	
	/**
	 * 
	 */
	@Override public void paintComponent(Graphics g)
	{
		int frameHeight= 480;
		int frameWidth= 640;
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawLine(10, (frameHeight - 10) / 3, frameWidth - 10, (frameHeight - 10) / 3);
		g.drawLine(10, 2* (frameHeight - 10) / 3, frameWidth - 10, 2* (frameHeight - 10) / 3);
		g.drawLine((frameWidth - 10) / 3, 10, (frameHeight - 10) / 3, frameHeight - 10);
		g.drawLine(2* (frameWidth - 10) / 3, 10, 2* (frameHeight - 10) / 3, frameHeight - 10);
	}
}
