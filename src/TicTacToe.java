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
	 * Matrix that will hold the board itself, it will have 3X3 
	 * dimensions
	 */
	private char[][] board;
	
	/**
	 * Variable to keep track if the board is full
	 */
	private boolean isFull = false;
	
	/**
	 * A variable to identify the number of the current board
	 */
	private int boardNumber= 0;
	
	/**
	 * Variable that determines if the ticTacToe is not locked
	 */
	private boolean isUnlocked = true;
	
	/**
	 * Constructor of the class
	 */
	public TicTacToe()
	{
		// Creates a char matrix of 3x3 dimensions
		this.board = new char[3][3];
		
		// Calls the method to fill the board with its starting position
		fillHyperBoard();
	}
	
	/**
	 * Method to fill the ticTacToe matrix with '-' as its
	 * starting position
	 */
	public void fillHyperBoard()
	{
		for (int row = 0; row < 3; ++row)
		{
			for (int col = 0; col < 3; ++col)
			{
				this.board[row][col] = '-';
			}
		}
	}
	
	/**
	 * Method to return the state of the board, that it
	 * if it is unlocked or not
	 */
	public boolean isUnlocked()
	{
		return this.isUnlocked;
	}
	
	/**
	 * Method that sets the unLocked variable to the parameter received
	 */
	public void unlock(boolean unlock)
	{
		this.isUnlocked = unlock;
	}
	
	/**
	 * 
	 */
	public void setBoardNumber(int number)
	{
		this.boardNumber = number;
	}
	
	public int getBoardNumber()
	{
		return this.boardNumber;
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
	 * Method to get the character of a giving cell of the board
	 * @param row the row of the cell 
	 * @param col the column of the cell
	 * @return the char on the given (row, col)
	 */
	public char get(int row, int col)
	{
		return this.board[row][col];
	}
	
	/**
	 * Method to set the character of a giving cell of the board
	 * @param row the row of the cell 
	 * @param col the column of the cell
	 * @param playerCharacter it is either 'X' or 'O'
	 */
	public void set(int row, int col, char playerCharacter)
	{
		// Sets the given cell to the char received
		this.board[row][col] = playerCharacter;
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
	private boolean checkHorizontal( char player)
	{
		// Variable to determine if the board is full
		boolean isFull = true;
		
		// Checks every row to see if the player won
		for ( int row = 0; row < this.board.length; ++row)
		{
			// Variable to check if the player won a row
			boolean wonRow = true;
			
			// Checks all the columns
			for ( int col = 0; col < this.board.length; ++col)
			{
				// Checks if all the cells are filled by the player
				if ( this.board[row][col] != player)
					wonRow = false;
				
				// Checks if the game is not full
				if ( this.board[row][col] == '-')
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
	private boolean checkVertical( char player)
	{
		// Checks every row to see if the player won
		for ( int col = 0; col < this.board.length; ++col)
		{
			// The variable to determine if the player won starts as true
			boolean wonCol = true;
				
			// Goes through every row
			for ( int row = 0; row < this.board.length; ++row)
			{
				// If one of the cells of the row is not the player
				// then he did not win with that column
				if ( this.board[row][col] != player)
				{
					// Sets false the variable to determine if the player won
					wonCol = false;
					
					// Makes the cycle end
					row = this.board.length;
				}
			}
					
			// If all the cells of the column were the same as the player
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
	private boolean checkDiagonal( char player)
	{
		boolean wonDiag = true;
		
		// Checks the first diagonal
		for ( int row = 0, col = 0 ; row < this.board.length; ++col, ++row) 
		{
			if ( this.board[row][col] != player) 
			{
				wonDiag = false;
				row = this.board.length; 
			}
		}
		
		// If the prisoner won by using the first diagonal
		if ( wonDiag)
			return true;
		
		wonDiag = true;
		
		// Checks every row to see if the player won
		for ( int row = 0, col = 0 ; row < this.board.length; ++col, ++row)
		{
			if ( this.board[row][col] != player)
			{
				wonDiag = false;
				row = this.board.length;
			}
		}
						
		return wonDiag;
	}
	
}