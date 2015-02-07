package edu.jhu.cs.oose.montage.model.iface;

import java.util.List;

import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Newsfeed Interface
 * @author Greg Kogut, Da Lu, Zachary Palmer
 *
 */
public interface Newsfeed {
	/**
	 * Retrieves the unique ID of this object
	 * 
	 * @return the ID.
	 */
	public abstract int getID();
	/**
	 * Adds a media object to the list of media objects for this Newsfeed.
	 * @param media The media object to add.
	 */
	public abstract void addToNewsfeed(Media media);

	/**
	 * Returns the list of media in this Newsfeed.
	 * @return The list of media in this Newsfeed.
	 */
	public abstract List<Media> getCurrentNewsFeed();
	
	/**
	 * Clears the current media in this newsfeed.
	 */
	public abstract void clear();

	public abstract String toString();

}