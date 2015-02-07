package edu.jhu.cs.oose.montage.model.iface.media;

import java.util.Calendar;
import java.util.List;

import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.User;

/**
 * Media interface.
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public interface Media {
	/**
	 * Retrieves the unique ID of this object
	 * 
	 * @return the ID.
	 */
	public abstract int getID();
	/**
	 * Adds a particular user id to this media's upvotes.
	 * @param uId user id
	 * @return True if uId was not already in list. False if uId was already in list
	 */
	public abstract boolean addToUpVotes(User uId);

	/**
	 * Adds a particular user id to this media's downvotes.
	 * @param uId user id
	 * @return True if uId was not already in list. False if uId was already in list
	 */
	public abstract boolean addToDownVotes(User uId);

	/**
	 * Adds a comment to this media.
	 * @param comment comment to add
	 */
	public abstract void addComment(String comment);
	
	/**
	 * Gets the comments for this media.
	 * @return a list of strings containing the comments.
	 */
	public abstract List<String> getComments();
	
	/**
	 * Returns the list of users who have upvoted this media.
	 * @return The list of users who have upvoted this media.
	 */
	public abstract List<User> getUserUpVotes();

	/**
	 * Returns the list of users who have downvoted this media.
	 * @return The list of users who have downvoted this media.
	 */
	public abstract List<User> getUserDownVotes();

	/**
	 * Returns the map containing creation date data.
	 * @return The map of creation date data.
	 */
	public abstract Calendar getUploadTime();

	/**
	 * Returns the Coordinates at which the media was uploaded.
	 * @return The Coordinates at which the media was uploaded.
	 */
	public abstract Coordinates getCoordinates();

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}