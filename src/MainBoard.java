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
	
	private boolean bigSimbol= false;
	
	private boolean simbol= false;
	
	private int x= 0;
	
	private int y= 0;
	
	private int row= 0;
	
	private int col= 0;
	
	private String currentSimbol= null;
	
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
		
		if(this.simbol)
		{
			this.drawSimbol(this.currentSimbol, this.x, this.y, g);
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
	 * @param simbol
	 * @param x
	 * @param y
	 */
	public void drawSimbol(String simbol, int x, int y, Graphics g)
	{
		int xPosition= x / ( 2 * this.scaleWidth / 3);
		
		int yPosition= y / ( 2* this.scaleHeight / 3);
		
		this.drawXorO(simbol, yPosition, xPosition, this.scaleWidth, this.scaleHeight, g);
	}
	
	/**
	 * 
	 */
	public void drawBigSimbol(Graphics g, String simbol, int row, int col)
	{
		this.createMiniBoards(g, row, col, "black");
		
		this.drawXorO(simbol, row, col, g);
	}
	
	/**
	 * 
	 */
	public void drawXorO(String simbol, int row, int col, Graphics g)
	{
		g.setColor(Color.RED);
		
		int horizontalJump= col * 2 * this.scaleWidth;
		
		int verticalJump= row * 2 * this.scaleHeight;
		
		if(simbol.equals("X"))
		{
			g.drawLine(this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, 3 * this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
			
			g.drawLine(3* this.scaleHeight + horizontalJump, verticalJump + this.scaleHeight, this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
		}
		else
		{
			g.drawOval(4 * this.scaleWidth / 3 + horizontalJump, 5 + verticalJump + this.scaleHeight, 4 * this.scaleWidth / 3, 4 * this.scaleWidth / 3);
		}
	}
	
	public void drawXorO(String simbol, int row, int col, int width, int hieght, Graphics g)
	{
		g.setColor(Color.RED);
		
		int horizontalJump= col * 2 * width / 3;
		
		int verticalJump= row * 2 * hieght / 3;
		
		int x1= this.scaleWidth + horizontalJump;
		
		int y1= this.scaleWidth + horizontalJump - 7;
		
		if(simbol.equals("X"))
		{
			
			
			g.drawLine( x1, y1, x1 + 2 * this.scaleWidth / 3, y1 + 2 * this.scaleHeight / 3);
			
			g.drawLine(x1, y1 + 2 * this.scaleHeight / 3, x1 + 2 * this.scaleWidth / 3, y1);
		}
		else
		{
			g.drawOval(x1 + horizontalJump, y1, 2 * this.scaleWidth / 3, 2 * this.scaleWidth / 3);
		}
	}
	
	/**
	 * 
	 */
	public void changeState( int x, int y)
	{
		this.simbol= true;
		
		this.x= x;
		
		this.y= y;
		
		if(this.currentSimbol== null)
		{
			this.currentSimbol= "X";
		}
		else if(this.currentSimbol.equals("X"))
		{
			this.currentSimbol= "O";
		}
		else
		{
			this.currentSimbol= "X";
		}
		
		this.repaint();
	}
}
