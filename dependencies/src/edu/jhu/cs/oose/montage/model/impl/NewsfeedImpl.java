package edu.jhu.cs.oose.montage.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.jhu.cs.oose.montage.model.abs.NewsfeedAbs;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Newsfeed class for Montage app. A Newsfeed is basically a list of media.
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class NewsfeedImpl extends NewsfeedAbs  {

    /**A list that represent the current newsfeed.*/
	private List<Media> currentNewsFeed;
	/** ID of this object*/
	private int id;
	/**
     * Creates a new Newsfeed object.
	 * @param sortType the type of sorting for the newsFeed.
     */
    public NewsfeedImpl(int sortType) {
        this.currentNewsFeed = new ArrayList<Media>();
    }
    
    /**
     * Default constructor for Kryonet. 
     */
    public NewsfeedImpl() {
    	this(0);
    }

    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.Newsfeed#getCurrentNewsFeed()
	 */
    @Override
	public List<Media> getCurrentNewsFeed() {
        return this.currentNewsFeed;
    }
    
    @Override
	public void addToNewsfeed(Media media) {
		this.currentNewsFeed.add(media);
	}
    

	
    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.Newsfeed#toString()
	 */
    @Override
	public String toString() {
		return "Newsfeed [currentNewsFeed=" + this.currentNewsFeed + "]";
	}

	@Override
	public int getID() {
		
		return this.id;
	}

	@Override
	public void clear() {
		this.currentNewsFeed.clear();
	}

}
