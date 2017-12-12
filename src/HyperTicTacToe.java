import java.util.Scanner;

public class HyperTicTacToe
{
	private MainWindow mainWindow = null;
	
	private String playerOne = null;
	
	private String playerTwo = null;
	
	private HyperTicTacToeGame game = null;
	
	Scanner input = null;
	
	TicTacToe ticTacToe = null;
	
	public static void main (String[] args)
	{
		HyperTicTacToe solution = new HyperTicTacToe();
		solution.run();
	}
	
	public void run()
	{
		// Creates a new Game
		game = new HyperTicTacToeGame();
				
		this.mainWindow= new MainWindow();
		
		this.mainWindow.setVisible(true);
		
		input = new Scanner(System.in);
		
		this.playerOne= input.next();
		
		this.playerTwo= input.next();
		
		this.mainWindow.setPlayers(this.playerOne, this.playerTwo);
	}
	
}

