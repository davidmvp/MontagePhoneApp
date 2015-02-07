package edu.jhu.cs.oose.montage.kryonet.request;

/**
 * A class that lets the user ask for a newsfeed.
 * @author Greg Kogut
 *
 */
public class NewsfeedRequest {
	/**Latitude of the user sending the request.*/
	double latitude;
	/**Longitude of the user sending the request.*/
	double longitude;
	/**Sort type of the newsfeed.*/
	int sort;
	
	/**
	 * NewsfeedRequest constructor.
	 * @param latitude latitude of the user
	 * @param longitude longitude of the user
	 * @param sort sort type
	 */
	public NewsfeedRequest(double latitude, double longitude, int sort) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.sort = sort;
	}
	
	/**
	 * Default constructor for kryonet.
	 */
	public NewsfeedRequest() {
	}

	/**
	 * Gets the latitude of the user who sent the request.
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Gets the longitude of the user who sent the request.
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Gets the sort type of the requested Newsfeed.
	 * @return the sort type
	 */
	public int getSort() {
		return sort;
	}
	
}
