import java.util.Scanner;

public class HyperTicTacToe
{
	private MainWindow mainWindow = null;
	
	private String playerOne = null;
	
	private String playerTwo = null;
	
	private Game game = null;
	
	Scanner input = null;
	
	TicTacToe ticTacToe = null;
	
	public static void main (String[] args)
	{
		HyperTicTacToe solution = new HyperTicTacToe();
		solution.run();
	}
	
	public void run()
	{
		this.mainWindow= new MainWindow();
		
		this.mainWindow.setVisible(true);
		
		this.mainWindow.setPlayers(this.playerOne, this.playerTwo);
		
		input = new Scanner(System.in);
		
		this.playerOne= input.next();
		
		this.playerTwo= input.next();
		
		// Creates a new Game
		game = new Game();
		
		// Calls the method to run the game
		game.runGame();
		
		
	}
	
}

