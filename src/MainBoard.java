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
	
	private boolean bigsymbol= false;
	
	private boolean symbol= false;
	
	private int x= 0;
	
	private int y= 0;
	
	private int row= 0;
	
	private int col= 0;
	
	private boolean highlight= false;
	
	private String currentsymbol= null;
	
	public MainBoard(int width, int height)
	{
		this.scaleWidth= (width) / 8;
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
		
		//vertical lines
		g.drawLine(3 * this.scaleWidth, this.scaleHeight, 3 * this.scaleWidth, 7 * this.scaleHeight);
		g.drawLine(5 * this.scaleWidth, this.scaleHeight, 5 * this.scaleWidth, 7 * this.scaleHeight);
		
		//Horizontal lines
		g.drawLine(this.scaleWidth, 3 * this.scaleHeight, 7 * this.scaleWidth, 3 * this.scaleHeight);
		g.drawLine(this.scaleWidth, 5 * this.scaleHeight, 7 * this.scaleWidth, 5 * this.scaleHeight);
		
		//highlight the corresponding miniBoard
		if( this.highlight)
		{
			//this.highlightBoard(this.x, this.y, g);
		}
		
		//Draw the miniBoards
		for(int row= 0; row < 3; row++)
		{
			for(int col= 0; col < 3; col++)
			{
				this.createMiniBoards(g, row, col, "blue");
			}
		}
		
		//draw the corresponding symbol
		if(this.symbol)
		{
			this.drawsymbol(this.currentsymbol, this.x, this.y, g);
			this.highlight= true;
		}
		else if(this.bigsymbol)
		{
			this.drawBigsymbol(g, this.currentsymbol, this.x, this.y);
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
	 * @param symbol
	 * @param x
	 * @param y
	 */
	public void drawsymbol(String symbol, int x, int y, Graphics g)
	{
		int xPosition= (x + 19) / ( 2 * this.scaleWidth / 3);
		
		int yPosition= y / ( 2* this.scaleHeight / 3);
		
		this.drawXorO(symbol, yPosition, xPosition, this.scaleWidth, this.scaleHeight, g);
	}
	
	/**
	 * 
	 */
	public void drawBigsymbol(Graphics g, String symbol, int row, int col)
	{
		this.createMiniBoards(g, row, col, "black");
		
		this.drawXorO(symbol, row, col, g);
	}
	
	/**
	 * 
	 */
	public void drawXorO(String symbol, int row, int col, Graphics g)
	{
		g.setColor(Color.RED);
		
		int horizontalJump= col * 2 * this.scaleWidth;
		
		int verticalJump= row * 2 * this.scaleHeight;
		
		if(symbol.equals("X"))
		{
			g.drawLine(this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, 3 * this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
			
			g.drawLine(3* this.scaleHeight + horizontalJump, verticalJump + this.scaleHeight, this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
		}
		else
		{
			g.drawOval(4 * this.scaleWidth / 3 + horizontalJump, 5 + verticalJump + this.scaleHeight, 4 * this.scaleWidth / 3, 4 * this.scaleWidth / 3);
		}
	}
	
	/**
	 * Method for printing "X" or "O" in small cells of miniBoards
	 * @param symbol is the symbol to print
	 * @param row
	 * @param col
	 * @param width
	 * @param hieght
	 * @param g
	 */
	public void drawXorO(String symbol, int row, int col, int width, int height, Graphics g)
	{
		g.setColor(Color.RED);
		
		int horizontalJump= (col - 2) * 2 * width / 3;
		
		int verticalJump= (row - 3) * 2 * height / 3;
		
		int x1= this.scaleWidth + horizontalJump;
		
		int y1= this.scaleHeight + verticalJump;
		
		if(symbol.equals("X"))
		{
			
			// print the X
			g.drawLine( x1, y1, x1 + 2 * this.scaleWidth / 3, y1 + 2 * this.scaleHeight / 3);
			
			g.drawLine(x1, y1 + 2 * this.scaleHeight / 3, x1 + 2 * this.scaleWidth / 3, y1);
		}
		else
		{
			// print the O
			g.drawOval(x1, y1, 2 * this.scaleWidth / 3, 2 * this.scaleHeight / 3);
		}
	}
	
	/**
	 * 
	 */
	public void changeState( int x, int y, String symbolControl)
	{
		if(symbolControl.equals("symbol"))
		{
			this.symbol= true;
			this.bigsymbol= false;
		}
		else if(symbolControl.equals("bigsymbol"))
		{
			this.symbol= false;
			this.bigsymbol= true;
		}
		
		this.x= x;
		
		this.y= y;
		
		if(this.currentsymbol== null)
		{
			this.currentsymbol= "X";
		}
		else if(this.currentsymbol.equals("X"))
		{
			this.currentsymbol= "O";
		}
		else
		{
			this.currentsymbol= "X";
		}
		
		this.repaint();
	}
	
	/**
	 * Method for highlighting a board
	 * @param col
	 * @param row
	 * @param g
	 */
	public void highlightBoard(int col, int row, Graphics g)// Cambiar lo de los Jump para que no se repita
	{
		int horizontalJump= col * 2 * this.scaleWidth;
		
		int verticalJump= row * 2 * this.scaleHeight;
		
		g.setColor(Color.LIGHT_GRAY);
		
		//Draw a rectangle
		g.drawRect(this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, 3 * this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
		
		//Fill the rectangle
		g.fillRect(col, row, this.scaleWidth * 2, this.scaleHeight * 2);
		
	}
}
