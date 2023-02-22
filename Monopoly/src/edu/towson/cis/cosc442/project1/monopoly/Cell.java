package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class Cell.
 */
public abstract class Cell implements IOwnable {
	
	/** The available. */
	private boolean available = true;
	
	/** The name. */
	private String name;
	
	/** The owner. */
	protected Player owner;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	@Override
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	@Override
	public int getPrice() {
		return 0;
	}

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	@Override
	public boolean playAction(String msg) {
		return true;
	}

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
	public String toString() {
        return name;
    }
}
