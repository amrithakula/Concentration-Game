/**
 * GViewControl.java
 * 
 * Version:
 * $1$
 * 
 * Revisions:
 * $1$
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/**
 * The graphic view controller for the concentration game which initializes the layout and 
 * the methods associated with the graphical user interface and the game.
 * 
 * @author Amrith Akula
 *
 */
public class GViewControl extends JFrame implements Observer {
	//An array of colors to vividly represent matched cards
	public static final Color[] myColors = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE,
		Color.LIGHT_GRAY, Color.YELLOW};
	//model object to get methods from
	static ConcentrationModel model;
	//a list of buttons to manipulate
	ArrayList<CardButton> buttonsList = new ArrayList<CardButton>();
	//The label at the top of the window that displays what move you are in
	private JLabel moveCounter = new JLabel();
	
	//Constructor for the frame and gui
	public GViewControl(ConcentrationModel model){
		this.model=model;
		model.addObserver(this);
		//the frame
		JFrame window = new JFrame();
		//overall panel is in a border layout
		JPanel panel = new JPanel (new BorderLayout());
			moveCounter.setText("Moves: 0 Select the first card"); //default message
			panel.add(moveCounter, BorderLayout.NORTH); //adding the label to the top of the window
		
		//The cards of the game represented as buttons
		JPanel buttons = new JPanel(new GridLayout(model.BOARD_SIZE,model.BOARD_SIZE));
			//buttons are added ot the panel in the center
			panel.add(buttons, BorderLayout.CENTER);
			ArrayList<CardFace> theCards = new ArrayList<CardFace>(); //cardfaces are stired in a list
			theCards = model.getCards(); //cards are populated from the model
			
			CardButton.sharedCards = theCards;
			//each cardbutton is made and then a listener is added, then added to the grid
			for(int i =0; i<theCards.size(); i++){
				CardButton eachButton = new CardButton(i);
				eachButton.addActionListener(new CardButtonListener());
				buttonsList.add(eachButton);
				buttons.add(eachButton);
			}
		//the south panel contains three buttons in a reverse flow layout
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
			//each button is made with a listener
			JButton reset = new JButton("Reset");
			reset.addActionListener(new ResetListener());
			JButton cheat = new JButton("Cheat");
			cheat.addActionListener(new CheatListener());
			JButton undo = new JButton("Undo");
			undo.addActionListener(new UndoListener());
			//the buttons are added to the panel
			southPanel.add(reset);
			southPanel.add(cheat);
			southPanel.add(undo);
			//the panel is added to the south in the larger panel
			panel.add(southPanel, BorderLayout.SOUTH);
			
		window.add(panel);
		window.setTitle("Concentration Game");
		window.setSize(500, 500);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	


	@Override
	//The update method that will match the cards and count moves
	public void update(Observable o, Object arg) {
		//Cardfaces are stored in a list
		ArrayList<CardFace> updateCards = model.getCards();
		//counter for the moves
		int cardsRevealed = 0;
		
		//Adds the number and color for each card
		for (int i=0; i<updateCards.size(); i++){
			if(updateCards.get(i).isFaceUp()){
				cardsRevealed++;
				buttonsList.get(i).setText(""+updateCards.get(i).getNumber());
				buttonsList.get(i).setBackground(myColors[updateCards.get(i).getNumber()]);
			}
			else{
				buttonsList.get(i).setText("");
				buttonsList.get(i).setBackground(Color.WHITE);
			}
			//Updates the label for moves played
			if(model.howManyCardsUp()==1){
				moveCounter.setText("Move: "+model.getMoveCount()+" Select the second card");
			}
			else{
				moveCounter.setText("Move: "+model.getMoveCount()+" Select the first card");
			}
			
		}
		
	}
	//Action Listener for each card
	class CardButtonListener implements ActionListener{

		//Cast cardbutton to get getSource method, and retrieve the position of the card selected
		public void actionPerformed(ActionEvent arg0) {
			CardButton cButton = (CardButton) arg0.getSource();
			GViewControl.this.model.selectCard(cButton.getPos());
		}
		
	}
	//Resets the game if the reset button is pressed
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.reset();
		}
	}
	//Opens a cheat window if the cheat button is pressed
	class CheatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new CheatFrame(buttonsList,model.BOARD_SIZE);
		}
	}
	//Undoes the last move if pressed
	class UndoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.undo();
		}
		
	}
	/**
	 * The main method that instantiates the GUI.
	 * 
	 * @param args - unused
	 */
	public static void main(String[] args){
		ConcentrationModel model = new ConcentrationModel();
		GViewControl game = new GViewControl(model);
	}

	
}
