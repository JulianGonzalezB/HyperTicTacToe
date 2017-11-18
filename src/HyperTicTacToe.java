import java.util.Scanner;

public class HyperTicTacToe
{
	private MainWindow mainWindow= null;
	
	private String playerOne= null;
	
	private String playerTwo= null;
	
	private TicTacToe[][] gameMatrix= null;
	
	private int rows= 3;
	
	private int cols= 3;
	
	Scanner input = null;
	TicTacToe ticTacToe = null;
	
	public void main (String[] args)
	{
		HyperTicTacToe solution = new HyperTicTacToe();
		solution.run();
	}
	
	public void run()
	{
		input = new Scanner(System.in);
		
		this.playerOne= input.next();
		
		this.playerTwo= input.next();
		
		this.createGameMatrices();
		
		this.mainWindow= new MainWindow();
		
		this.mainWindow.setVisible(true);
		
		this.mainWindow.setPlayers(this.playerOne, this.playerTwo);
	}
	
	/**
	 * 
	 */
	public void createGameMatrices()
	{
		int numberOfBoard= 1;
		
		for(int row= 0; row < 3; row++)
		{
			for(int col= 0; col < 3; col++)
			{
				this.gameMatrix[row][col]= new TicTacToe(this.rows, this.cols);
				
				this.gameMatrix[row][col].setBoardNumber(numberOfBoard);
				
				numberOfBoard++;
			}
		}
	}
}

