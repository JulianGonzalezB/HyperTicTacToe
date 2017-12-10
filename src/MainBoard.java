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
	
	private String[][] allPositions= null;
	
	private String[][] bigPositions= null;
	
	private int nextRow= 0;
	
	private int nextCol= 0;
	
	private boolean highlight= true;
	
	private String currentsymbol= "X";
	
	/**
	 * The constructor of the class. it sets a scale for the width and the height to work with.
	 * @param width
	 * @param height
	 */
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
			//Highlight the next board to be played in.
			this.highlightBoard( this.nextCol, this.nextRow, g);
		}
		
		//Draw the miniBoards
		for(int row= 0; row < 3; row++)
		{
			for(int col= 0; col < 3; col++)
			{
				this.createMiniBoards(g, row, col, "blue");
			}
		}
		
		this.checkBigBoard(g);
	}
	
	/**
	 * 
	 * @param color
	 * @param row
	 * @param col
	 * @param g
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
		this.drawXorO(symbol, x, y, this.scaleWidth, this.scaleHeight, g);
	}
	
	/**
	 * 
	 * @param symbol
	 * @param row
	 * @param col
	 * @param g
	 */
	public void drawBigsymbol(Graphics g, int row, int col, String symbol)
	{
		this.createMiniBoards(g, row, col, "black");
		
		this.drawXorO(symbol, row, col, g);
	}
	
	/**
	 * 
	 * @param symbol
	 * @param row
	 * @param col
	 * @param g
	 */
	public void drawXorO(String symbol, int row, int col, Graphics g)
	{
		g.setColor(Color.RED);
		
		int horizontalJump= col * 2 * this.scaleWidth;
		
		int verticalJump= row * 2 * this.scaleHeight;
		
		if(symbol.equals("X"))
		{
			g.drawLine(this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, 3 * this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
			
			g.drawLine(3 * this.scaleWidth + horizontalJump, verticalJump + this.scaleHeight, this.scaleWidth + horizontalJump, verticalJump + 3 * this.scaleHeight);
		}
		else
		{
			g.drawOval(4 * this.scaleWidth / 3 + horizontalJump, 5 + verticalJump + this.scaleHeight, 4 * this.scaleWidth / 3, 4 * this.scaleWidth / 3);
		}
	}
	
	/**
	 * Method for printing "X" or "O" in small cells of miniBoards
	 * @param symbol is the symbol to draw
	 * @param row is the row of the cell
	 * @param col is the column of the cell
	 * @param width is the width for each cell
	 * @param hieght is the height for each cell
	 * @param g is an instance of the class Graphics
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
	 * @param allPositions
	 * @param bigPositions
	 */
	public void newPlay( String[][] allPositions, String[][] bigPositions)
	{
		this.allPositions= allPositions;
		
		this.bigPositions= bigPositions;
		
		this.repaint();
	}
	
	/**
	 * A method for checking the general state of each mini-board. This method calls the method that draw a big symbol if necessary
	 * @param g is an instance of the class Graphics
	 */
	public void checkBigBoard(Graphics g)
	{
		for(int row= 0; row < 3; row++)
		{
			for(int col= 0; col < 3; col++)
			{
				if(this.bigPositions[row][col].equals("-"))
				{
					this.checkMiniBoards(row, col, g);
				}
				else if(this.bigPositions[row][col] != null)
				{
					this.drawBigsymbol(g, row, col, this.bigPositions[row][col]);
				}
			}
		}
	}
	
	/**
	 * A method for checking each cell of the mini-board still in play. This method calls the method that draw a symbol if necessary
	 * @param row
	 * @param col
	 * @param g is an instance of the class Graphics
	 */
	public void checkMiniBoards(int row, int col, Graphics g)
	{
		int rowFactor= row * 3;
		
		int colFactor= col * 3;
		
		int rowLimit= 3 + rowFactor;
		
		int colLimit= 3 + colFactor;
		
		for(int currentRow= rowFactor; currentRow < rowLimit ; currentRow++)
		{
			for(int currentCol= colFactor; currentCol < colLimit; currentCol++)
			{
				if(this.allPositions[row][col].equals("x") || this.allPositions[row][col].equals("o"))
				{
					this.drawsymbol(this.allPositions[row][col], row, col, g);
				}
			}
		}
	}
	
	/**
	 * Method for highlighting a mini-board
	 * @param col is the column of the mini-board
	 * @param row is the row if the mini-board
	 * @param g is an instance of the class Graphics
	 */
	public void highlightBoard(int col, int row, Graphics g)
	{
		int horizontalJump= col * 2 * this.scaleWidth;
		
		int verticalJump= row * 2 * this.scaleHeight;
		
		g.setColor(Color.LIGHT_GRAY);
		
		//Draw the fill of a rectangle in light gray
		g.fillRect(this.scaleWidth + horizontalJump,verticalJump + this.scaleHeight, this.scaleWidth * 2, this.scaleHeight * 2);
		
	}
}
