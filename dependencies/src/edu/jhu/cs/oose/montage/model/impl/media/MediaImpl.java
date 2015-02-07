package edu.jhu.cs.oose.montage.model.impl.media;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.jhu.cs.oose.montage.model.abs.media.MediaAbs;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.User;


/**
 * Media abstract class for Montage app.
 * Inherited by: Photo, TextPost, Drawing
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public abstract class MediaImpl extends MediaAbs  {
	
    private Coordinates location;
	
    private int id;
    /**Users that have upvoted this media.*/
	private List<User> userUpVotes;
	/**Users that have downvoted this media.*/
	private List<User> userDownVotes;
	/**Anonymous comments attached to this media.*/
	private List<String> comments;

	private Calendar uploadTime ;

    /**
     * Constructor for the Media class.
     * @param location The location of the user when the Media was created.
     */
    public MediaImpl(Coordinates location) {
        this.location = location;
        this.userUpVotes = new ArrayList<User>();
        this.userDownVotes = new ArrayList<User>();
        this.comments = new ArrayList<String>();

        uploadTime = Calendar.getInstance();
    }
    
    /**
     * Default constructor for kryonet.
     */
    public MediaImpl() {
    	
    }
    
    
    public List<String> getComments() {
		return this.comments;
	}

    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#getUserUpVotes()
	 */
    @Override
	public List<User> getUserUpVotes() {
        return this.userUpVotes;
    }

    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#getUserDownVotes()
	 */
    @Override
	public List<User> getUserDownVotes() {
        return this.userDownVotes;
    }

    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#getUploadTime()
	 */
    @Override
	public Calendar getUploadTime() {
        return this.uploadTime;
    }

    /* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#getCoordinates()
	 */
    @Override
	public Coordinates getCoordinates() {
        return this.location;
    }

    

	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#hashCode()
	 */

	
	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.media.Media#toString()
	 */
	
	@Override
	public String toString() {
		return "Media [location=" + location + ", uploadTime=" + uploadTime
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((userDownVotes == null) ? 0 : userDownVotes.hashCode());
		result = prime * result
				+ ((userUpVotes == null) ? 0 : userUpVotes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MediaImpl other = (MediaImpl) obj;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (userDownVotes == null) {
			if (other.userDownVotes != null)
				return false;
		} else if (!userDownVotes.equals(other.userDownVotes))
			return false;
		if (userUpVotes == null) {
			if (other.userUpVotes != null)
				return false;
		} else if (!userUpVotes.equals(other.userUpVotes))
			return false;
		return true;
	}

	@Override
	public int getID() {
		
		return this.id;
	}
	
	
    
}
