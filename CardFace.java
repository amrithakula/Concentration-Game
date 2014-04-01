/**
 * CardFace.java
 *
 * File:
 *	$Id: CardFace.java,v 1.1 2013/04/24 03:03:58 aa2635 Exp $
 *
 * Revisions:
 *	$Log: CardFace.java,v $
 *	Revision 1.1  2013/04/24 03:03:58  aa2635
 *	Done
 *
 */

/**
 * The interface that unites Cards and CardBacks.
 *
 *
 */

public interface CardFace {
    
    /**
     * Get the value indicating whether or not the card is face-up.
     *
     * @return A boolean indicating whether or not the card is face-up.
     */
    public boolean isFaceUp();
    
    /**
     * Get the number on the card.
     *
     * @return An integer that is the number on the card.
     */
    public int getNumber();

}