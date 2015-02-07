package edu.jhu.cs.oose.montage.model.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.jhu.cs.oose.montage.model.abs.GridSquareAbs;
import edu.jhu.cs.oose.montage.model.hibernate.media.MediaHib;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.media.Media;

/**
 * GridSquare Hibernate class for persistence.
 * @author Greg Kogut, Da Lu
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class GridSquareHib extends GridSquareAbs {
	private List<Media> allMedia;
	    
	/**A boundary of this square*/
	private Coordinates upperLeft;
	/**A boundary of this square*/
	private Coordinates upperRight;
	/**A boundary of this square*/
	private Coordinates lowerLeft;
	/**A boundary of this square*/
	private Coordinates lowerRight;
	/**Id for this entry in the database.*/
	private int id;
	
	/**
	 * GridSquareHib constructor.
	 * @param upperLeft upper left point of square
	 * @param upperRight upper right point of square
	 * @param lowerLeft lower left point of square
	 * @param lowerRight lower right point of square
	 */
	public GridSquareHib(Coordinates upperLeft, Coordinates upperRight,
			Coordinates lowerLeft, Coordinates lowerRight) {
		super();
		this.allMedia = new ArrayList<Media>();
		this.upperLeft = upperLeft;
		this.upperRight = upperRight;
		this.lowerLeft = lowerLeft;
		this.lowerRight = lowerRight;
	}

	/**
	 * Getter for this entry's id in the database.
	 */
	@Id
	@GeneratedValue 
	public int getID() {
		return this.id;
	}
	
	/**
	 * Setter for id
	 * @param id id in the database
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	
	public void setUpperLeft(Coordinates c) {
		
		this.upperLeft = c;
	}

	
	public void setUpperRight(Coordinates c) {
		
		this.upperRight = c;
	}
	
	
	public void setLowerLeft(Coordinates c) {
		
		this.lowerLeft = c;
	}
	
	
	public void setLowerRight(Coordinates c) {
		
		this.lowerRight = c;
	}

	@Override
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getUpperLeft() {
		
		return this.upperLeft;
	}

	@Override
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getUpperRight() {
	
		return this.upperRight;
	}


	@Override
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getLowerLeft() {
		
		return this.lowerLeft;
	}

	@Override
	@OneToOne(targetEntity=CoordinatesHib.class)
	public Coordinates getLowerRight() {
		
		return this.lowerRight;
	}

	@SuppressWarnings("unchecked")
	@Override
	@OneToMany(targetEntity=MediaHib.class)
	public List<Media> getMedia() {
		
		return  this.allMedia;
	}
	
	public void setMedia(List<Media> m) {
		this.allMedia =   m;
	}
	

}
