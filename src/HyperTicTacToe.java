/**
 * Controller to the hyperTicTacToe game. It controls the 
 * rounds of the players by determining where each player
 * does his move and checking if the game is won or lost
 * by one of the players
 */
public class HyperTicTacToe
{
	/**
	 * Constants to determine the number of rows and columns 
	 * of the matrix
	 */
	public static final int NUMBER_OF_ROWS = 3;
	public static final int NUMBER_OF_COLUMNS = 3;
	
	/**
	 * Variable to keep track of the number of boards
	 * in the matrix
	 */
	public static final int NUMBER_OF_BOARDS = 9;
	
	/**
	 * Matrix that contains 9 ticTacToes
	 */
	private TicTacToe[][] ticTacToesMatrix = null;
	
	/**
	 * A ticTacToe that will hold the main game.
	 * It will be the big board shown in the game,
	 * and will depend on the other 9 smaller boards.
	 */
	private TicTacToe hyperBoard = null;
	
	/**
	 * The character of the player, it can be 'X' or 'O'
	 */
	private char currentPlayer = ' ';
	
	/**
	 * Constructor of the class
	 */
	public HyperTicTacToe() 
	{
		// Creates a new TicTacToe board of 3x3 dimensions
		this.hyperBoard = new TicTacToe();
		
		// Creates the array of 9 different TicTacToe boards
		this.ticTacToesMatrix = new TicTacToe[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		
		// Sets the initial player to 'X'
		this.currentPlayer = 'X';
		
		// Calls the method to create the matrix and fill it with new ticTacToes
		fillTicTacToeMatrix();
	}
	
	/**
	 * Method that fills the ticTacToeMatrix attribute with new 
	 * ticTacToes in all of the positions of the matrix
	 */
	public void fillTicTacToeMatrix()
	{
		// Variable to identify the boards
		int numberOfBoard = 1;
		
		// Cycle to fill the matrix with new ticTacToes in each cell
		for ( int row = 0; row < NUMBER_OF_ROWS; ++row )
		{
			for ( int col = 0; col < NUMBER_OF_COLUMNS; ++col )
			{
				// Creates a new TicTacToe
				this.ticTacToesMatrix[row][col] = new TicTacToe();
				
				// Sets the number of the board
				this.ticTacToesMatrix[row][col].setBoardNumber(numberOfBoard);
				
				numberOfBoard++;	
			}
		}
	}
	
	/**
	 * Method to check the current state of the game, first it
	 * checks if the ticTacToe where the last player clicked has
	 * been won or drawn, then it checks if that move made changes
	 * to the state of the hyperBoard
	 * @param row the row of the ticTacToe played
	 * @param col the column of the ticTacToe played
	 */
	public void checkBoard(int row, int col)
	{
		this.ticTacToesMatrix[row][col].checkState();
		this.hyperBoard.checkState();
	}
	
	/**
	 * Method that determines if the last move made by the player was valid.
	 * If so, it returns true
	 * @param bigPosX the row of the hyperBoard (big TicTacToe)
	 * @param bigPosY the column of a board (big TicTacToe)
	 * @param posX the row of the board (small TicTacToe)
	 * @param posY the column of the board (small TicTacToe)
	 * @return true if the player made a valid move
	 */
	public boolean checkPlayerMove(int bigPosX, int bigPosY, int posX, int posY)
	{
		// If the ticTacToe clicked is unlocked
		if ( this.ticTacToesMatrix[bigPosX][bigPosY].isUnlocked() )
		{
			// If the cell clicked had not been used
			if ( this.ticTacToesMatrix[bigPosX][bigPosY].get(posX, posY) == '-')
			{
				// Sets the char of the cell to the char of the current player ('X' or 'O')
				this.ticTacToesMatrix[bigPosX][bigPosY].set(posX,posY, this.currentPlayer);
				
				// Changes the current player
				this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';
						
				// Calls the method to detect if the last move changed the state of the board
				checkBoard(bigPosX, bigPosY);
				
				// Calls the method to set the lock property of the ticTacToes
				setUnlockedCells(posX, posY);
				
				// Returns true if the move was valid
				return true;
			}	
		}
		
		// Returns false if the move was not made in a valid place
		return false;
	}
	
	/**
	 * Method that returns the current state of the game (if it has been won by someone 
	 * or if it still is in play)
	 * @return the current state of the hyperBoard
	 */
	public char gameState() 
	{
		// Returns the state of the game (X, O, = or -)
		return this.hyperBoard.getBoardState();
	}
	
	/**
	 * Method that returns a reference of the hyperBoard property
	 * @return this.hyperBoard
	 */
	public TicTacToe getHyperBoard()
	{
		// Returns the hyperBoard property
		return this.hyperBoard;
	}
	
	/**
	 * Method that returns a reference of the ticTacToeMatrix property
	 * @return this.hyperBoard
	 */
	public TicTacToe[][] getTicTacToeMatrix()
	{
		// Returns the ticTacToesMatrix property
		return this.ticTacToesMatrix;
	}
	
	/**
	 * Method that unlocks or locks all the matrixes that are still in play
	 */
	private void unlockAll(boolean unlock)
	{
		// Runs the matrix by each row and column
		for (int row = 0; row < 3; ++row)
		{
			for (int col = 0; col < 3; ++col)
			{
				// If the matrix is still in play
				if ( this.hyperBoard.get(row, col) == '-')
				{
					// Sets the lock element to the according boolean
					this.ticTacToesMatrix[row][col].unlock(unlock);
				}
			}
		}
	}
	
	/**
	 * Method that determines if a ticTacToe must by locked or unlocked
	 * @param row the row of the cell clicked
	 * @param col the column of the cell clicked
	 */
	public void setUnlockedCells(int row, int col)
	{
		// If the ticTacToe was still in play
		if ( this.hyperBoard.get(row, col) == '-')
		{
			// Locks all the ticTacToes
			unlockAll(false);
			
			// Sets the only unlocked matrix to the one clicked
			this.ticTacToesMatrix[row][col].unlock(true);;
		}
		
		// If the player chose a finished matrix, all of them are unlocked
		else
		{
			// Unlocks all the matrixes
			unlockAll(true);
		}
	}
}
