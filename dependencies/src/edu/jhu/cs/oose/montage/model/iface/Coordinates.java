package edu.jhu.cs.oose.montage.model.iface;

/**
 * Coordiantes Interface
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public interface Coordinates {

	/**
	 * Retrieves the unique ID of this object
	 * 
	 * @return the ID.
	 */
	public abstract int getID();

	/**
	 * Getter for latitude
	 * 
	 * @return the current latitude
	 */
	public abstract double getLatitude();

	/**
	 * Getter for the longitude
	 * 
	 * @return the current longitude
	 */
	public abstract double getLongitude();

	public abstract String toString();

}