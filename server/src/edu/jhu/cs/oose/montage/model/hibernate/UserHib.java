package edu.jhu.cs.oose.montage.model.hibernate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import edu.jhu.cs.oose.montage.model.abs.UserAbs;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.Newsfeed;

/**
 * User hibernate class.
 * @author Greg Kogut, Da Lu
 *
 */
@Entity
public class UserHib extends UserAbs {
	private String userID;
	private double longitude, latitude;
	private Coordinates coordinates;

	
	private Newsfeed newsfeed;
	

	@Basic
	public double getLongitude() {
		
		return this.longitude;
	}

	/**
	 * Setter for longitude of user.
	 * @param longitude longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Setter for latitude of user.
	 * @param latitude latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Getter for latitude.
	 */
	@Basic
	public double getLatitude() {
		
		return this.latitude;
	}

	/**
	 * Getter for user id.
	 */
	@Id
	public String getUId() {
		
		return this.userID;
	}

	/**
	 * Setter for user id.
	 * @param id id
	 */
	public void setUId(String id) {
		this.userID = id;
	}
	
	/**
	 * Setter for user's newsfeed.
	 */
	public void setNewsfeed(Newsfeed newsfeed) {
		this.newsfeed = newsfeed;
		
	}

	/**
	 * Getter for user's newsfeed.
	 */
	@OneToOne(targetEntity=NewsfeedHib.class)
	public Newsfeed getNewsfeed() {
		
		return this.newsfeed;
	}

	/**
	 * Getter for validity of the user's newsfeed.
	 */
	@Override
	@Transient
	public boolean isNewsfeedValid() {
		
		return true;
	}

	@Override
	public void setCoordinates(Coordinates c) {
		this.coordinates = c;
		
	}

	@Override
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getCoordinates() {
		
		return this.coordinates;
	}

	

}
