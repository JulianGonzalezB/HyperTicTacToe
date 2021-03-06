import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * A class for the main window of the game. The main window contains the main board and pass information to it from the control class Game.
 * This class contains too the name of the players and the number of turns.
 *
 */
public class MainWindow extends JFrame implements MouseListener, ActionListener
{
	private String playerOne= "Player 1";
	
	private String playerTwo= "Player 2";
	
	private String currentPlayer= this.playerOne;
	
	private int currentPlayerNumber= 0;
	
	private HyperTicTacToe hyperTicTacToe= null;
	
	private MainBoard mainBoard= null;
	
	private JPanel indicators= null;
	
	private JButton restart = null;
	
	private JButton players= null;
	
	private JLabel playerInTurn= null;
	
	private int screenWidth= 640;
	
	private int screenHeight= 480;
	
	private boolean firstPlay= true;
	
	/**
	 * Constructor of the class
	 */
	public MainWindow()
	{
		super("Hyper Tic-Tac-Toe");
		
		this.hyperTicTacToe= new HyperTicTacToe();
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		
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
		if(playerOne != null)
		{
			this.playerOne= playerOne;
		}
		if(playerTwo != null)
		{
			this.playerTwo= playerTwo;
		}
		
		this.setCurrentPlayer();
	}
	
	/**
	 * A method that creates 2 indicators, one for the name of the player who is playing in the current turn 
	 * And one indicator for the number of turns played
	 */
	public void creategameIndicators()
	{
		this.indicators= new JPanel();
		indicators.setLayout(new BorderLayout());
		
		this.players= new JButton("Players");
		this.players.addActionListener(this);
		
		this.playerInTurn= new JLabel();
		
		JPanel name= new JPanel();
		name.setLayout(new FlowLayout());
		name.add(players);
		name.add(playerInTurn);
		indicators.add(name, BorderLayout.LINE_START);
		
		this.restart = new JButton("RESTART");
		this.restart.addActionListener(this);
		
		
		JPanel restartPanel= new JPanel();
		restartPanel.setLayout(new FlowLayout());
		restartPanel.add(restart);
		indicators.add(restartPanel, BorderLayout.LINE_END);
		
		this.add(indicators, BorderLayout.PAGE_START);
	}
	
	/**
	 * A methods that sets the current playing who have to play according with the last player who played.
	 * This method change directly the corresponding label
	 */
	public void setCurrentPlayer()
	{
		//Cheack the player in the current turn and sets and switch players
		if(this.currentPlayerNumber == 1 || this.currentPlayerNumber == 0)
		{
			this.currentPlayer= this.playerOne;
			
			this.currentPlayerNumber= 2;
		}
		else if(this.currentPlayerNumber == 2)
		{
			this.currentPlayer= this.playerTwo;
			
			this.currentPlayerNumber= 1;
		}
		
		//Change the label for showing the name of the next current player
		this.playerInTurn.setText("Player : " + this.currentPlayer);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		//Detects which button was pushed
		if(event.getSource() == this.restart)
		{
			int answer= JOptionPane.showConfirmDialog(null, "Are you sure?");
			
			if(answer == JOptionPane.OK_OPTION)
			{
				this.reset();
			}
		}
		else if(event.getSource() == this.players)
		{
			String firstPlayer= JOptionPane.showInputDialog("Player 1");
			
			String secondPlayer= JOptionPane.showInputDialog("Player 2");
			
			this.setPlayers(firstPlayer, secondPlayer);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
		// Gets the position of where the mouse was clicked
		int positionX =  event.getX(); 
		int positionY =  event.getY();
		
		
		// If the player clicked on a valid position
		if( positionX > this.screenWidth / 8 && positionX < 7 * this.screenWidth / 8 && positionY > this.screenHeight / 8 && positionY < 50 + 7 * this.screenHeight / 8)
		{
			int bigPosX= (positionX - this.screenWidth / 8) / (2 * this.screenWidth / 8);
			int bigPosY= (positionY - 105) / (2 * (this.screenHeight) / 8);
			int xPosCell = ((positionX - this.screenWidth / 8) / (2 * this.screenWidth / 24)) % 3;
			int yPosCell = ((positionY - 105) / (2 * this.screenHeight / 24)) % 3;
			
			if(this.hyperTicTacToe.checkPlayerMove(bigPosX, bigPosY, xPosCell, yPosCell))
			{
				if(this.hyperTicTacToe.gameState() == '-')
				{
					TicTacToe bigPositions= this.hyperTicTacToe.getHyperBoard();
					
					TicTacToe[][] allPositions= this.hyperTicTacToe.getTicTacToeMatrix();
					
					this.mainBoard.newPlay(allPositions, bigPositions);
				}
				else
				{
					TicTacToe bigPositions= this.hyperTicTacToe.getHyperBoard();
					
					TicTacToe[][] allPositions= this.hyperTicTacToe.getTicTacToeMatrix();
					
					this.mainBoard.newPlay(allPositions, bigPositions);
					
					this.finalScreen(this.hyperTicTacToe.gameState());
				}
				
				this.setCurrentPlayer();
			}
		}			
	}
	
	/**
	 * This method displays a dialog with a text that congratulates the winner and show 
	 * ask if players want to play again.
	 * This method is called when a player wins the game
	 */
	public void finalScreen(char winner)
	{
		String playerWinner= "";
		
		if(winner == 'X')
		{
			playerWinner= this.playerOne;
		}
		else if(winner == 'O')
		{
			playerWinner= this.playerTwo;
		}
		
		int answer= JOptionPane.showConfirmDialog(null, "Congratulations  " + playerWinner + " .  " + "Do you want to play again?");
		
		if(answer == JOptionPane.OK_OPTION)
		{
			this.reset();
		}
		else if(answer == JOptionPane.NO_OPTION)
		{
			System.exit(0);
		}
	}
	
	/**
	 *This method resets the game.
	 *This method is called when the games has ended and player want to play again or the button "restart" is pushed. 
	 */
	private void reset()
	{
		//Resets all attributes of the class
		this.playerOne= "Player 1";
		
		this.playerTwo= "Player 2";
		
		this.currentPlayer= this.playerOne;
		
		this.currentPlayerNumber= 1;
		
		this.hyperTicTacToe= new HyperTicTacToe();
		
		this.mainBoard= null;
		
		this.indicators= null;
		
		this.restart = null;
		
		this.playerInTurn= null;
		
		this.players= null;
		
		this.screenWidth= 640;
		
		this.screenHeight= 480;
		
		this.firstPlay= true;
		
		this.createBoard();
		
		this.mainBoard.restart();
		
		this.creategameIndicators();
	}
}
