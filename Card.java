/**
 * Card.java
 *
 * File:
 *	$Id: Card.java,v 1.1 2013/04/24 03:03:59 aa2635 Exp $
 *
 * Revisions:
 *	$Log: Card.java,v $
 *	Revision 1.1  2013/04/24 03:03:59  aa2635
 *	Done
 *
 */

/**
 * Class definition for a card in the concentration card game.
 *
 *
 */

public class Card implements CardFace {
    
    /**
     * The number on the card.
     */
    private final int number;

    /**
     * The flag indicating whether or not the card is face-up.
     */
    private boolean isFaceUp;

    /**
     * Construct a Card object.
     * 
     * @param number The number on the card.
     */
    public Card(int number) {
	this.number = number;
	this.isFaceUp = false;
    }

    /**
     * Get the flag indicating whether or not the card is face-up.
     *
     * @return A boolean indicating whether or not the card is face-up.
     */
    @Override
    public boolean isFaceUp() {
	return this.isFaceUp;
    }

    /**
     * Get the number on the card.
     *
     * @return An integer that is the number on the card.
     */
    @Override
    public int getNumber() {
	return this.number;
    }


    /**
     * Toggle the flag indicating whether or not the card is face-up.
     *
     */
    public void toggleFace() {
	this.isFaceUp = !this.isFaceUp;
    }

    /**
     * Get the String representing the card.
     *
     * @return A String representing the card.
     */
    @Override
    public String toString() {
	return "-" + this.number + "-";
    }

}