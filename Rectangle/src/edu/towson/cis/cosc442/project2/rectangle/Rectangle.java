package edu.towson.cis.cosc442.project2.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/*
	 * Get the length of the triangle given the points
	 */
	public double getLength() {
		return Math.abs(this.p1.y - this.p2.y);
	}
	
	/*
	 * Get the length of the triangle given the points
	 */
	public double getWidth() {
		return Math.abs(this.p1.x - this.p2.x);
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		return this.getLength() * this.getWidth();
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		return Math.sqrt(Math.pow(this.getWidth(), 2) + Math.pow(this.getLength(), 2));
	}
}
