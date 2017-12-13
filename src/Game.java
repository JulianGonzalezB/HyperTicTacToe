import java.util.Scanner;

public class Game
{
	private MainWindow mainWindow = null;
	
	private String playerOne = null;
	
	private String playerTwo = null;
	
	private HyperTicTacToe game = null;
	
	Scanner input = null;
	
	TicTacToe ticTacToe = null;
	
	public static void main (String[] args)
	{
		Game solution = new Game();
		solution.run();
	}
	
	public void run()
	{
		// Creates a new Game
		game = new HyperTicTacToe();
				
		this.mainWindow= new MainWindow();
		
		this.mainWindow.setVisible(true);
		
		input = new Scanner(System.in);
		
		this.playerOne= input.next();
		
		this.playerTwo= input.next();
		
		this.mainWindow.setPlayers(this.playerOne, this.playerTwo);
	}
	
}

