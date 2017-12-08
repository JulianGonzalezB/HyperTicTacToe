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
 * 
 * 
 *
 */
public class MainWindow extends JFrame implements MouseListener, ActionListener
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
	 * 
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
		this.addMouseListener(this);
	}
	
	/**
	 * 
	 */
	public void createBoard()
	{
		this.mainBoard= new MainBoard(this.getWidth(), this.getHeight());
		this.add(mainBoard, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	public void setPlayers(String playerOne, String playerTwo)
	{
		this.playerOne= "Julian";
		this.playerTwo= "Jostin";
		this.currentPlayer= this.playerOne;
	}
	
	/**
	 * 
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
	 * 
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
	public void mouseClicked(MouseEvent event)
	{
		int x= event.getX();
		
		int y= event.getY();
		
		//If the player clicked over a valid space
		if(x > this.boardLimitX / 8 && x < 7 * this.boardLimitX / 8 && y > this.boardLimitY / 8 && y < 7 * this.boardLimitY / 8)
		{
			this.setCurrentPlayer();
			
			this.mainBoard.changeState(event.getX(), event.getY(), "symbol");
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
}
