import java.awt.BorderLayout;
import java.awt.Font; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow extends JFrame
{
	private String playerOne= "Julian";
	
	private String playerTwo= "Jostin";
	
	private String currentPlayer= "Satan";
	
	private int turns= 0;
	
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
	}
	
	/**
	 * 
	 */
	public void createBoard()
	{
		MainBoard mainBoard= new MainBoard(this.getWidth(), this.getHeight());
		//mainBoard.drawBigSimbol("O", 1, 1);
		this.add(mainBoard, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	public void creategameIndicators()
	{
		JPanel indicators= new JPanel();
		indicators.setLayout(new BorderLayout());
		Font font = new Font("Names", Font.CENTER_BASELINE, 15);
		
		JLabel labelPlayer = new JLabel("Player :" + this.currentPlayer);
		labelPlayer.setFont(font);
		indicators.add(labelPlayer, BorderLayout.LINE_START);
		
		JLabel labelTurns = new JLabel("turns :" + this.turns);
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
}
