import java.util.Scanner;

public class HyperTicTacToe
{
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
		 
		 // Reads the amount of rows of the board
		 int rows = input.nextInt();
		 
		 // Reads the amount of columns of the board
		 int cols = input.nextInt();
		 
		 // Creates a TicTacToe object of N by N size
		 ticTacToe = new TicTacToe(rows, cols);
		 
		 
	}
}

