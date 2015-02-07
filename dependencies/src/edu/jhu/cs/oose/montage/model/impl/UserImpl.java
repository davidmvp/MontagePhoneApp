package edu.jhu.cs.oose.montage.model.impl;

import java.util.Random;

import edu.jhu.cs.oose.montage.model.abs.UserAbs;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;
import edu.jhu.cs.oose.montage.model.iface.User;

/**
 * User class for Montage app.
 * 
 * @author Gregory Kogut
 * @author Andrew Ding
 * @author Tiffany Ko
 * @author Da Lu
 * @author Anthony Lee
 */
public class UserImpl extends UserAbs implements User {

	/** Unique user ID for this user */
	private String userID;
	private Coordinates coordinates;

	private boolean newsfeedIsValid;
	private Newsfeed newsfeed;

	static final int REQUEST_IMAGE_CAPTURE = 1;

	/**
	 * User constructor assigns userID to user object
	 */
	public UserImpl() {
		this.userID = generateUID();
		// TODO don't hardcode
		//this.coordinates = new CoordinatesImpl(39.33, -76.61);
		this.newsfeedIsValid = false;
		
		/*this.newsfeedIsValid = true;
		this.newsfeed = new NewsfeedImpl(0);
		this.newsfeed.addToNewsfeed(new TextPostImpl("hello world", new CoordinatesImpl(39.33, -76.61)));*/
	}

	/**
	 * Generates a random 128 character alphanumeric string for this user.
	 * 
	 * @return the alphanumeric string
	 */
	private String generateUID() {
		Random rand = new Random();

		String uid = "";
		for (int i = 0; i < 128; i++) {
			uid += (char) (rand.nextInt(42) + 48);
		}

		return uid;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.jhu.cs.oose.montage.model.User#getLatitude()
	 */
	@Override
	public double getLatitude() {
		return this.coordinates.getLatitude();
	}

	@Override
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.jhu.cs.oose.montage.model.User#getLongitude()
	 */
	@Override
	public double getLongitude() {
		return this.coordinates.getLongitude();
	}	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.jhu.cs.oose.montage.model.User#getUId()
	 */
	@Override
	public String getUId() {
		return this.userID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.jhu.cs.oose.montage.model.User#setNewsfeed(edu.jhu.cs.oose.montage
	 * .model.Newsfeed)
	 */
	@Override
	public void setNewsfeed(Newsfeed newsfeed) {
		this.newsfeed = newsfeed;
		
		if (this.newsfeed == null) {
			this.newsfeedIsValid = false;
		} else {
			this.newsfeedIsValid = true;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.jhu.cs.oose.montage.model.User#getNewsfeed()
	 */
	@Override
	public Newsfeed getNewsfeed() {
		if (this.newsfeedIsValid) {
			return newsfeed;
		} else {
			throw new UninitializedFieldException();
		}
	}

	@Override
	public boolean isNewsfeedValid() {
		return this.newsfeedIsValid;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

}
