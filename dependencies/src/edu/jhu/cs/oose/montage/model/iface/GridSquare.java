package edu.jhu.cs.oose.montage.model.iface;

import java.util.Collection;
import java.util.List;

import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * GridSquare Interface.
 * @author Greg, Da Lu, Zachary Palmer
 *
 */
public interface GridSquare {
	/**
	 * Retrieves the unique ID of this object
	 * 
	 * @return the ID.
	 */
	public abstract int getID();
	
	/**
	 * Determines if a piece of media belongs in this square.
	 * @param m media we are checking
	 * @return true this media belongs within the boundaries of this square
	 */
	public abstract boolean belongsHere(Media m);

	/**
	 * Determines if the given coordinates belong in this square.
	 * @param lat latitude
	 * @param longit longitude
	 * @return true if these coordinates belong here
	 */
	public abstract boolean belongsHere(double lat, double longit);

	/**
	 * Getter for the upperleft boundary.
	 * @return upper left coordinate
	 */
	public abstract Coordinates getUpperLeft();

	/**
	 * Getter for the upper right boundary.
	 * @return the upper right coordinate
	 */
	public abstract Coordinates getUpperRight();

	/**
	 * Getter for the lower left boundary.
	 * @return the lower left coordinate
	 */
	public abstract Coordinates getLowerLeft();

	/**
	 * Getter for the lower right boundary.
	 * @return the lower right coordinate
	 */
	public abstract Coordinates getLowerRight();

	/**
	 * Adds a piece of media to this grid square
	 * @param m
	 */
	public abstract void addMedia(Media m);

	/**
	 * Updates a piece of media (i.e. its upvotes)
	 * @param m media to update
	 */
	public abstract void updateMedia(Media m);

	/**
	 * Returns all the media in this square
	 * @return an AdrrayList of media
	 */
	public abstract List<Media> getMedia();

	public abstract String toString();

	

}