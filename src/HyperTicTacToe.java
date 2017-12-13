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
	
	public void fillTicTacToeMatrix()
	{
		// Variable to identify the boards
		int numberOfBoard = 1;
		
		// Cycle to fill the matrix with new ticTacToes in each cell
		for ( int row = 0; row < NUMBER_OF_ROWS; ++row )
		{
			for ( int col = 0; col < NUMBER_OF_COLUMNS; ++col )
			{
				this.ticTacToesMatrix[row][col] = new TicTacToe();
				
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
	
	// Primer llama a este, le devuelve true si la juegada que hizo fue valida
	public boolean checkPlayerMove(int bigPosX, int bigPosY, int posX, int posY)
	{
		// If the cell clicked had not been used
		if ( this.ticTacToesMatrix[bigPosX][bigPosY].get(posX, posY) == '-')
		{
			// Sets the char of the cell to the char of the current player ('X' or 'O')
			this.ticTacToesMatrix[bigPosX][bigPosY].set(posX,posY, this.currentPlayer);
			
			// Calls the method to detect if the last move changed the state of the board
			checkBoard(bigPosX, bigPosY);
			
			return true;
		}	
		
		return false;
	}
	
	// Luego llama a este para saber si el juego continua (devuelve '-', 'X', 'O' o '=')
	public char gameState() 
	{
		return this.hyperBoard.getBoardState();
	}
	
	// Este lo llama de tercero, le devuelve el "gato grande"
	public TicTacToe getHyperBoard()
	{
		return this.hyperBoard;
	}
	
	// Este lo llama de ultimo, le devuelve la matriz de gatos
	public TicTacToe[][] getTicTacToeMatrix()
	{
		return this.ticTacToesMatrix;
	}
}
