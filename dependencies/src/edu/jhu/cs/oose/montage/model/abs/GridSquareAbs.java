package edu.jhu.cs.oose.montage.model.abs;

import java.util.Iterator;

import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.GridSquare;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * Abstract GridSquare class.
 * @author Greg Kogut, Zachary Palmer, Greg Kogut
 *
 */
public abstract class GridSquareAbs implements GridSquare {

	/**
	 * Default constructor.
	 */
	public GridSquareAbs() {
		super();
	}

	@Override
	public boolean belongsHere(Media m) {
		Coordinates loc = m.getCoordinates();
		
		double lat = loc.getLatitude();
		double longit = loc.getLongitude();
		
		
		return this.belongsHere(lat, longit);
	}

	@Override
	public boolean belongsHere(double lat, double longit) {
		
		if (lat >= this.getUpperLeft().getLatitude() && lat < this.getUpperRight().getLatitude()
				&& longit >= this.getUpperLeft().getLongitude() && longit < this.getLowerLeft().getLongitude()) {
			return true;
		}
		
		return false;
	}

	@Override
	public void addMedia(Media m) {
		if (this.belongsHere(m)) {
	    	this.getMedia().add(m);
		}
	}
	

	@Override
	public void updateMedia(Media m) {
		Iterator<Media> it = this.getMedia().iterator();
		
		Media next;
		while (it.hasNext()) {
			next = it.next();
			
			if (next.equals(m)) {
				it.remove();
				break;
			}
		}
		
		this.getMedia().add(m);
	}

	

}