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
	
	private int currentPlayerNumber= 1;
	
	private int turns= 1;
	
	private HyperTicTacToe hyperTicTacToe= null;
	
	private MainBoard mainBoard= null;
	
	private JPanel indicators= null;
	
	private JLabel labelPlayer = null;
	
	private JLabel labelTurns = null;
	
	private JFrame finalFrame= null;
	
	private JButton playAgain= null;
	
	private JButton quit= null;
	
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
		
		this.setSize(this.screenWidth, this.screenHeight);
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

	@Override
	public void actionPerformed(ActionEvent event) {
		Object targedButton= event.getSource();
		
		if(targedButton == this.quit)
		{
			this.finalFrame.dispose();
			this.dispose();
			System.exit(0);
		}
		else if(targedButton == this.playAgain)
		{
			
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
		if( positionX > this.screenWidth / 8 && positionX < 7 * this.screenWidth / 8 && positionY > this.screenHeight / 8 && positionY < 7 * this.screenHeight / 8)
		{
			//Revisar##############################
			int bigPosX= (positionX - this.screenWidth / 8) / (2 * this.screenWidth / 8);
			int bigPosY= (positionY - this.screenHeight / 8) / (2 * this.screenHeight / 8);;
			int xPosCell = ((positionX + 19 - this.screenWidth / 8) / (2 * this.screenWidth / 24)) % 3;
			int yPosCell = ((positionY - this.screenHeight / 8) / (2 * this.screenHeight / 24)) % 3;
			
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
					this.finalScreen(this.hyperTicTacToe.gameState());
				}
			}
		}			
	}
	
	/**
	 * 
	 */
	public void finalScreen(char winner)
	{
		this.finalFrame= new JFrame("WINNER");
		
		this.finalFrame.setSize(320, 240);
		
		BorderLayout finalLayout= new BorderLayout();
		
		this.finalFrame.setLayout(finalLayout);
		
		JPanel finalPanel= new JPanel();
		
		finalPanel.setLayout(finalLayout);
		
		JLabel playerWinner = new JLabel("CONGRATULATIONS " + this.currentPlayer + "WINS");
		Font font = new Font("Names", Font.CENTER_BASELINE, 15);
		playerWinner.setFont(font);
		
		JPanel buttonPanel= new JPanel();
		FlowLayout innerLayout= new FlowLayout();
		buttonPanel.setLayout(innerLayout);
		
		this.playAgain= new JButton("PLAY AGAIN");
		this.quit= new JButton("QUIT");
		buttonPanel.add(playAgain);
		buttonPanel.add(quit);
		
		finalPanel.add(playerWinner, BorderLayout.PAGE_START);
		finalPanel.add(buttonPanel, BorderLayout.CENTER);
		
		this.finalFrame.add(finalPanel, BorderLayout.CENTER);
		
		this.finalFrame.setVisible(true);
	}
}
