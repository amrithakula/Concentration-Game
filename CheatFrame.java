/**
 * CheatFrame.java
 * 
 * Version:
 * $1$
 * 
 * Revisions:
 * $0$
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * The cheat frame that will have the solved game upon a click of the cheat button
 * 
 * @author Amrith Akula
 *
 */
public class CheatFrame extends JFrame {
	//Local list of cardbuttons
	ArrayList<CardButton> cardButtons = new ArrayList<CardButton>();
	//the size of grid
	private int size;
	//Constructor of the cheat frame to create the buttons
	public CheatFrame(ArrayList<CardButton> cardButtons, int size){
		this.cardButtons = cardButtons;
		this.size = size;
		Container window = getContentPane();
		//Gridlayout organization
		window.setLayout(new GridLayout(size,size));
		//Title of the frame
		setTitle("Cheat Concentration Game");
		ArrayList<CardFace> cheatFaces = new ArrayList<CardFace>();
		//Takes the values from the cheat method
		cheatFaces = GViewControl.model.cheat();
		//For all the cardbuttons a new gui button is created with matching colors for pairs
		for(int i=0; i<cardButtons.size();i++){
			CardButton Cheat = new CardButton(i); //creates cardbuttons for cheat frame
			Cheat.setText(""+cheatFaces.get(i).getNumber()); //adds the number to the each button
			Cheat.setBackground(GViewControl.myColors[cheatFaces.get(i).getNumber()]); //matches the color
			window.add(Cheat); //added to the frame
		}
		setSize(375,375);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	

}
