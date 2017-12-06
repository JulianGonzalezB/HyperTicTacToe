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
	private String playerOne= "Julian";
	
	private String playerTwo= "Jostin";
	
	private String currentPlayer= "Satan";
	
	private int turns= 0;
	
	private MainBoard mainBoard= null;
	
	private JPanel indicators= null;
	
	private JLabel labelPlayer = null;
	
	private JLabel labelTurns = null;
	
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
	public void creategameIndicators()
	{
		this.indicators= new JPanel();
		indicators.setLayout(new BorderLayout());
		Font font = new Font("Names", Font.CENTER_BASELINE, 15);
		
		this.labelPlayer = new JLabel("Player :" + this.currentPlayer);
		labelPlayer.setFont(font);
		indicators.add(labelPlayer, BorderLayout.LINE_START);
		
		this.labelTurns = new JLabel("turns :" + this.turns);
		labelTurns.setFont(font);
		indicators.add(labelTurns, BorderLayout.LINE_END);
		
		this.add(indicators, BorderLayout.PAGE_START);
	}
	
	/**
	 * 
	 */
	public void setPlayers(String playerOne, String playerTwo)
	{
		this.playerOne= playerOne;
		this.playerTwo= playerTwo;
	}
	
	/**
	 * 
	 */
	public void setCurrentPlayer(int player)
	{
		if(player == 1)
		{
			this.currentPlayer= this.playerOne;
		}
		else if(player == 2)
		{
			this.currentPlayer= this.playerTwo;
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void changePlayer()
	{
		if(this.currentPlayer.equals(this.playerOne))
		{
			this.currentPlayer = this.playerTwo;
		}
		else
		{
			this.currentPlayer = this.playerOne;
		}
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		String simbol = "O";
		if(this.currentPlayer.equals(this.playerTwo))
		{
			simbol= "X";
		}
		
		this.changePlayer();
		
		//this.mainBoard.drawSimbol(simbol, event.getX(), event.getY());
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
