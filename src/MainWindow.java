import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A class for the main window of the game. The main window contains the main board and pass information to it from the control class Game.
 * This class contains too the name of the players and the number of turns.
 *
 */
public class MainWindow extends JFrame
{
	private String playerOne= null;
	
	private String playerTwo= null;
	
	private String currentPlayer= "Player 1";
	
	private int currentPlayerNumber= 1;
	
	private int turns= 1;
	
	private MainBoard mainBoard= null;
	
	private JPanel indicators= null;
	
	private JLabel labelPlayer = null;
	
	private JLabel labelTurns = null;
	
	private int boardLimitY= 480;
	
	private int boardLimitX= 640;
	
	/**
	 * Constructor of the class
	 */
	public MainWindow()
	{
		super("Hyper Tic-Tac-Toe");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout mainLayout= new BorderLayout();
		this.setLayout(mainLayout);
		
		this.createBoard();
		this.creategameIndicators();
	}
	
	/**
	 * Method for creating and adding a main board to the main window of the game.
	 */
	public void createBoard()
	{
		//Creates a new instance of MainBoard with its width and its height
		this.mainBoard= new MainBoard(this.getWidth(), this.getHeight());
		this.add(mainBoard, BorderLayout.CENTER);
	}
	
	/**
	 * A method that sets the name of the 2 players. CurrentPlayer is set as playerOne because playerOne plays first
	 * @param playerOne is the name of the first player
	 * @param playerTwo is the name of the second player
	 */
	public void setPlayers(String playerOne, String playerTwo)
	{
		this.playerOne= playerOne;
		this.playerTwo= playerTwo;
		this.currentPlayer= this.playerOne;
	}
	
	/**
	 * A method that creates 2 indicators, one for the name of the player who is playing in the current turn 
	 * And one indicator for the number of turns played
	 */
	public void creategameIndicators()
	{
		this.indicators= new JPanel();
		indicators.setLayout(new BorderLayout());
		Font font = new Font("Names", Font.CENTER_BASELINE, 15);
		
		this.labelPlayer = new JLabel("Player : " + this.currentPlayer);
		labelPlayer.setFont(font);
		indicators.add(labelPlayer, BorderLayout.LINE_START);
		
		this.labelTurns = new JLabel("turns : " + this.turns);
		labelTurns.setFont(font);
		indicators.add(labelTurns, BorderLayout.LINE_END);
		
		this.add(indicators, BorderLayout.PAGE_START);
	}
	
	/**
	 * A methods that sets the current playing who have to play according with the last player who played.
	 * This method change directly the corresponding label
	 */
	public void setCurrentPlayer()
	{
		if(this.currentPlayerNumber == 1)
		{
			this.currentPlayer= this.playerOne;
			
			this.currentPlayerNumber= 2;
		}
		else if(this.currentPlayerNumber == 2)
		{
			this.currentPlayer= this.playerTwo;
			
			this.currentPlayerNumber= 1;
		}
		
		this.labelPlayer.setText("Player : " + this.currentPlayer);
		this.labelTurns.setText("turns : " + this.turns);
		this.turns++;
	}
	
	/**
	 * This method communicates the state of the game to the main board. This method pass two arrays with all the information
	 * the main board needs for repaint.
	 * @param allPositions is the array that contains the state of all cells of all 9 mini-boards while they are in play.
	 * @param bigPositions is the array that contains the general state (if is in play or not and what player won each miniboard) 
	 * of each of the 9 mini-boards.
	 */
	public void communicateEvent(char[][] allPositions, char[][] bigPositions)
	{
		this.setCurrentPlayer();
		
		this.mainBoard.newPlay(allPositions, bigPositions);
	}
	
	
	/* MOUSE LISTENER LOGIC:
	 * 
	 *  @Override
	public void mouseClicked(MouseEvent event)
	{
		// Gets the position of where the mouse was clicked
		int bigPosX =  event.getX() / 160; 
		int bigPosY =  event.getY() / 120;
		
		// If the player clicked on a valid position
		if( bigPosX == this.boardLimitX && bigPosY == this.boardLimitY )
		{
			// RECEIVES THE SIZE FROM THE MAIN WINDOW SEND ARGUMENT (getX())
			
			int xPosition = (event.getX() + 19) / 53;
			int yPosition = event.getY() / 80; 
			
			int posX = xPosition % 3;
			int posY = yPosition % 3;
			
			// If the cell clicked had not been used
			if ( this.ticTacToesMatrix[bigPosX][bigPosY].get(posX, posY) == '-')
			{
				// Sets the char of the cell to the char of the current player ('X' or 'O')
				this.ticTacToesMatrix[bigPosX][bigPosY].set(posX,posY, this.currentPlayer);
				
				// Calls the method to detect if the last move changed the state of the board
				checkBoard(bigPosX, bigPosY);
				
				// The limits will now be where the last player did his move
				this.boardLimitX = posX;
				this.boardLimitY = posY;
				
				mainWindow.communicateEvent(this.ticTacToesMatrix, this.hyperBoard);
				
				// If the game already ended
				if ( this.hyperBoard.getBoardState() != '-')
				{
					// Call the method to print the ending screen
					// main.endGame()
				}
			}
		}			
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	MOUSE LISTENER LOGIC END*/
}
