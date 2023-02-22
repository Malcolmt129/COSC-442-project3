package edu.towson.cis.cosc442.project1.monopoly;

public interface IOwnable {

	String getName();

	Player getOwner();

	int getPrice();

	boolean isAvailable();

	boolean playAction(String msg);

	void setAvailable(boolean available);

	void setOwner(Player owner);

	String toString();

}