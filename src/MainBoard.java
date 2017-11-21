import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * 
 *
 */
public class MainBoard extends JPanel
{
	private int scaleHeight= 0;
	
	private int scaleWidth= 0;
	
	public MainBoard(int width, int height)
	{
		this.scaleWidth= (width - 30) / 8;
		this.scaleHeight= (height - 30) / 8;
	}
	
	/**
	 * 
	 */
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.drawLine(3 * this.scaleWidth, this.scaleHeight, 3 * this.scaleWidth, 7 * this.scaleHeight);
		g.drawLine(5 * this.scaleWidth, this.scaleHeight, 5 * this.scaleWidth, 7 * this.scaleHeight);
		g.drawLine(this.scaleWidth, 3 * this.scaleHeight, 7 * this.scaleWidth, 3 * this.scaleHeight);
		g.drawLine(this.scaleWidth, 5 * this.scaleHeight, 7 * this.scaleWidth, 5 * this.scaleHeight);
		
		for(int row= 0; row < 3; row++)
		{
			for(int col= 0; col < 3; col++)
			{
				this.createMiniBoards(g, row, col, "blue");
			}
		}
	}
	
	/**
	 * 
	 */
	public void createMiniBoards(Graphics g, int row, int col, String color)
	{
		int cellWidth= this.scaleWidth * 2;
		int cellHeight= this.scaleHeight * 2;
		
		int horizontalJump= col * 2 * this.scaleWidth;
		int verticalJump= row * 2 * this.scaleHeight;
		
		if(color.equals("blue"))
		{
			g.setColor(Color.BLUE);
		}
		else
		{
			g.setColor(Color.BLACK);
		}
		
		g.drawLine(horizontalJump + this.scaleWidth + cellWidth / 3, verticalJump + this.scaleHeight, horizontalJump + this.scaleWidth + cellWidth / 3, verticalJump + 3 * this.scaleHeight);
		g.drawLine(horizontalJump + this.scaleWidth + 2 * cellWidth / 3, verticalJump + this.scaleHeight, horizontalJump + this.scaleWidth + 2 * cellWidth / 3, verticalJump + 3 * this.scaleHeight);
		g.drawLine(horizontalJump + this.scaleWidth, verticalJump + this.scaleHeight + cellHeight / 3, horizontalJump + 3 * this.scaleWidth, verticalJump + this.scaleHeight + cellHeight / 3);
		g.drawLine(horizontalJump + this.scaleWidth, verticalJump + this.scaleHeight + 2 * cellHeight / 3, horizontalJump + 3 * this.scaleWidth, verticalJump + this.scaleHeight + 2 * cellHeight / 3);
	}
	
	/**
	 * 
	 */
	public void drawBigSimbol(String simbol, int row, int col)
	{
		Graphics g= getGraphics();
		this.createMiniBoards(g, row, col, "black");
		g.setColor(Color.BLUE);
		
		int horizontalJump= col * 2 * this.scaleWidth;
		int verticalJump= row * 2 * this.scaleHeight;
		
		if(simbol.equals("X"))
		{
			g.drawLine(this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, 3 * this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
			g.drawLine(3* this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
		}
		else
		{
			g.drawOval(2 * this.scaleWidth + horizontalJump, verticalJump + 2 * this.scaleHeight, 2 * this.scaleWidth, 2 * this.scaleWidth);
		}
	}
}
