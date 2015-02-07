package edu.jhu.cs.oose.montage.model.hibernate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import edu.jhu.cs.oose.montage.model.abs.CoordinatesAbs;

/**
 * Coordinates hibernate class for persistence.
 * @author Greg Kogut, Da Lu
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class CoordinatesHib extends CoordinatesAbs {

	private double latitude;
	private double longitude;
	/**Id of this entry in the database.*/
	private int id;
	
	public CoordinatesHib(double d, double e) {
		this.latitude = d;
		this.longitude = e;
	}

	@Id
	@GeneratedValue
	@Basic
	public int getID() {
		return this.id;
	}
	
	/**
	 * Setter for database id.
	 * @param id database id
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Getter for latitude.
	 */
	@Basic
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Setter for latitude.
	 * @param latitude desired latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Getter for longitude.
	 */
	@Basic
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Setter for longitude.
	 * @param longitude desired longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CoordinatesHib other = (CoordinatesHib) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

}
