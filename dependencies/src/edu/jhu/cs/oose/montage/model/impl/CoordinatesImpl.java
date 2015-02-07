package edu.jhu.cs.oose.montage.model.impl;

import edu.jhu.cs.oose.montage.model.abs.CoordinatesAbs;

/**
 * Implementation of GPS coordinates for the Montage app.
 * @author Greg Kogut
 *
 */
public class CoordinatesImpl extends CoordinatesAbs  {

	/**Longitude of this position.*/
	private double latitude;
	/**Latitude of this position.*/
	private double longitude;
	
	/** ID of this object*/
	private int id;
	
	public CoordinatesImpl(double lat, double longit) {
		super();
		this.latitude = lat;
		this.longitude = longit;
	}
	
	public CoordinatesImpl() {
		
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.Coordinates#getLatitude()
	 */
	@Override
	public double getLatitude() {
		return this.latitude;
	}

	/* (non-Javadoc)
	 * @see edu.jhu.cs.oose.montage.model.Coordinates#getLongitude()
	 */
	@Override
	public double getLongitude() {
		return this.longitude;
	}

	@Override
	public int getID() {
		
		return id;
	}

	@Override
	public String toString() {
		return "CoordinatesImpl [latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
}
