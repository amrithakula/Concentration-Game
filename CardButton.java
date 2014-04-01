/**
 * CardButton.java
 * 
 * Version:
 * $1$
 * 
 * Revisions:
 * $1$
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * The CardButton class that will represent the cards in the grid display
 * 
 * @author Amrith Akula
 *
 */
public class CardButton extends JButton{
	//local list of cardfaces
	public static ArrayList<CardFace> sharedCards;
	//position of the cardbutton
	private int pos;
	//constructor
	public CardButton(int pos) {
		this.setBackground(Color.WHITE);
		this.setText("");
		this.pos = pos;
		//for mac - allows buttons to be visible
		this.setBorderPainted(false); 
		this.setContentAreaFilled(false);
		this.setOpaque(true);
	}
	/**
	 * Gets the position of the button
	 * 
	 * @return int pos - the position of the button for comparision and to call the arraylist of cards
	 */
	public int getPos() {
		return pos;
	}

	
	
	
}
