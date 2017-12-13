/**
 * 
 * 
 *
 */
public class Game
{
	private MainWindow mainWindow = null;
	
	/**
	 * 
	 * 
	 */
	public static void main (String[] args)
	{
		Game solution = new Game();
		solution.run();
	}
	 /**
	  * 
	  */
	public void run()
	{
		this.mainWindow= new MainWindow();
		
		this.mainWindow.setVisible(true);
	}
	
}

