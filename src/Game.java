/**
 * Controller to the hyperTicTacToe game. It controls the 
 * rounds of the players by determining where each player
 * does his move and checking if the game is won or lost
 * by one of the players
 */
public class Game 
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
	private TicTacToe[][] ticTacToesArray = null;
	
	/**
	 * A ticTacToe that will hold the main game.
	 * It will be the big board shown in the game,
	 * and will depend on the other 9 smaller boards.
	 */
	private TicTacToe hyperBoard = null;
	
	/**
	 * Constructor of the class
	 */
	public Game()
	{
		// Creates a new TicTacToe board of 3x3 dimensions
		this.hyperBoard = new TicTacToe(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
		
		// Creates the array of 9 different TicTacToe boards
		this.ticTacToesArray = new TicTacToe[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	}
	
	/**
	 * Method that will control the game, receives the answer of the player
	 * and determines in which board can the player play his move.
	 */
	public void runGame()
	{
		while ( hyperBoard.getBoardState() == '-')
		{
			
		}
	}
}
