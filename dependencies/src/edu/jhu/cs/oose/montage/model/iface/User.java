package edu.jhu.cs.oose.montage.model.iface;

import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * User interface.
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public interface User {

	/**
	 * Adds the user to the list of upvoted users in the Media class
	 * @param media The Media class that the user is being added to.
	 */
	public abstract void upVoteMedia(Media media);

	/**
	 * Adds the user to the list of downvoted users in the Media class.
	 * @param media The Media class that the user is being added to.
	 */
	public abstract void downVoteMedia(Media media);

	/**
	 * Returns longitude of the user.
	 * @return The longitude position of the user.
	 */
	public abstract double getLongitude();

	/**
	 * Returns latitude of the user.
	 * @return The latitude position of the user.
	 */
	public abstract double getLatitude();

	

	/**
	 * Getter for UID.
	 * @return this user's uid
	 */
	public abstract String getUId();

	/**
	 * Setter for this user's newsfeed
	 * @param newsfeed newsfeed we want to set our field to
	 */
	public abstract void setNewsfeed(Newsfeed newsfeed);

	/**
	 * Getter for Newsfeed.
	 * @return this user's newsfeed
	 */
	public abstract Newsfeed getNewsfeed();
	
	/**
	 * Determines if the Newsfeed is valid.  If this method returns <code>false</code>, then the {@link User#getNewsfeed()} method may raise an exception when called.
	 */
	public boolean isNewsfeedValid();
	
	/**
	 * Sets the coordiantes for this user.
	 * @param c Coordinates of the user
	 */
	public void setCoordinates(Coordinates c);
	
	/**
	 * Geter for user coordinates.
	 * @return
	 */
	public Coordinates getCoordinates();
}