/**
 * Class that manages a single ticTacToe
 * Has a variable to keep track of the state of the game.
 *
 */
public class TicTacToe
{
	/**
	 * Variable to keep track of the state if the game. 
	 * It will be 'X' if the first player won the board, 
	 * 'O' if the second player already won the board, 
	 * '=' if the board is full and was a tie, or '-' if
	 * the game has not finished.
	 */
	private char boardState = '-';
	
	/**
	 * Variable to store the amount of rows of the board
	 */
	private int rows = 0;
	
	/**
	 * Variable to store the amount of columns of the board
	 */
	private int cols = 0;
	
	/**
	 * Matrix that will hold the board itself, it will have 3X3 
	 * dimensions
	 */
	private char[][] ticTacToe;
	
	/**
	 * Variable to keep track if the board is full
	 */
	private boolean isFull = false;
	
	/**
	 * Constructor of the class
	 */
	public TicTacToe(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		
		this.ticTacToe = new char[rows][cols];
	}
	
	/**
	 * Method to return 'X' or 'O' if the game was won 
	 * by one of those players, '=' if the game was a tie,
	 * or '-' if the game is still in play
	 * 
	 * @return the current state of the board
	 */
	public char getBoardState()
	{
		return this.boardState;
	}
	
	/** 
	 * Method to determine if one of the players won
	 * or if the game has finished, if any of these 
	 * happen, it sets the property boardState to the
	 * corresponding state.
	 */
	public void checkState()
	{	
		// If the game was won by the 'X' player, either horizontally, vertically or diagonally
		if ( checkHorizontal('X') || checkVertical('X') || checkDiagonal('X') )
		{
			// Sets the variable board state to the winner of the board ('X')
			this.boardState = 'X';
		}
		
		// If the game was won by the 'O' player, either horizontally, vertically or diagonally
		else if ( checkHorizontal('O') || checkVertical('O') || checkDiagonal('O') )
		{
			// Sets the variable board state to the winner of the board ('O')
			this.boardState = 'O';
		}
		
		// Checks if the board is full, it means it is a draw
		else if ( this.isFull)
		{
			// Sets the property board state to '=' that means it was a tie
			this.boardState = '=';
		}
	}
	
	/**
	 * Method to check if the current board was one in a horizontal
	 * way, that is, a player taking the cells 1, 2 and 3 or 4, 5 and 6
	 * or 7, 8 and 9. Returns true if so
	 * 
	 * @param player it will be 'X' or 'O' 
	 * @return true if the board was one by the player
	 */
	public boolean checkHorizontal( char player)
	{
		// Variable to determine if the board is full
		boolean isFull = true;
		
		// Checks every row to see if the player won
		for ( int row = 0; row < this.rows; ++row)
		{
			// Variable to check if the player won a row
			boolean wonRow = true;
			
			// Checks all the columns
			for ( int col = 0; col < this.cols; ++col)
			{
				// Checks if all the cells are filled by the player
				if ( this.ticTacToe[row][col] != player)
				{
					wonRow = false;
					++row;
				}
				
				// Checks if the game is not full
				if ( this.ticTacToe[row][col] == '-')
					isFull = false;
			}
			
			// If the player won a row
			if ( wonRow)
				return true;
		}
		
		// Sets the property isFull to the corresponding state
		this.isFull = isFull;
		
		// If it got to this point, none of the rows were won
		return false;
	}
	
	/**
	 * Method to check if the current board was one in a horizontal
	 * way, that is, a player taking the cells 1, 4 and 7 or 2, 5 and 8
	 * or 3, 6 and 9. Returns true if so
	 * 
	 * @param player it will be 'X' or 'O' 
	 * @return true if the board was one by the player
	 */
	public boolean checkVertical( char player)
	{
		// Checks every row to see if the player won
		for ( int col = 0; col < this.cols; ++col)
		{
			boolean wonCol = true;
					
			for ( int row = 0; row < this.rows; ++row)
			{
				if ( this.ticTacToe[row][col] != player)
				{
					wonCol = false;
					++col;
				}
			}
					
			if ( wonCol)
				return true;
		}
				
		return false;
	}
	
	/**
	 * Method to check if the current board was one in a horizontal
	 * way, that is, a player taking the cells 1, 5 and 9 or 3, 5 and 7 
	 * 
	 * @param player it will be 'X' or 'O' 
	 * @return true if the board was one by the player
	 */
	public boolean checkDiagonal( char player)
	{
		boolean wonDiag = true;
		
		// Checks the first diagonal
		for ( int row = 0, col = 0 ; row < this.rows; ++col, ++row)
		{
			if ( this.ticTacToe[row][col] != player)
				{
					wonDiag = false;
					row = this.rows;
				}
		}
		
		if ( wonDiag)
			return true;
		
		// Checks every row to see if the player won
		for ( int row = 0, col = 0 ; row < this.rows; ++col, ++row)
				{
					if ( this.ticTacToe[row][col] != player)
						{
							wonDiag = false;
							row = this.rows;
						}
				}
						
		return false;
	}
	
}