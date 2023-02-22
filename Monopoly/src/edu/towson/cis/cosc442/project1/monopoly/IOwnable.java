package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Interface IOwnable.
 */
public interface IOwnable {

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	Player getOwner();

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	int getPrice();

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	boolean isAvailable();

	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	boolean playAction(String msg);

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	void setAvailable(boolean available);

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	void setOwner(Player owner);

	/**
	 * To string.
	 *
	 * @return the string
	 */
	String toString();

}