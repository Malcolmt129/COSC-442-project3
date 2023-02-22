package edu.towson.cis.cosc442.project1.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class GoCell.
 */
public class GoCell extends Cell {
	
	/**
	 * Instantiates a new go cell.
	 */
	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	/**
	 * Play action.
	 *
	 * @param msg the msg
	 * @return true, if successful
	 */
	public boolean playAction(String msg) {
		return true;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name) {
	}
}
