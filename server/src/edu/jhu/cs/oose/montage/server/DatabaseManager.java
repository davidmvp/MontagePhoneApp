package edu.jhu.cs.oose.montage.server;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.jhu.cs.oose.montage.model.hibernate.CoordinatesHib;
import edu.jhu.cs.oose.montage.model.hibernate.GridSquareHib;
import edu.jhu.cs.oose.montage.model.hibernate.media.PhotoHib;
import edu.jhu.cs.oose.montage.model.hibernate.media.TextPostHib;
import edu.jhu.cs.oose.montage.model.iface.Coordinates;
import edu.jhu.cs.oose.montage.model.iface.GridSquare;
import edu.jhu.cs.oose.montage.model.iface.media.Media;
import edu.jhu.cs.oose.montage.model.impl.media.PhotoImpl;
import edu.jhu.cs.oose.montage.model.impl.media.TextPostImpl;

/**
 * Database logic. An object of this class will be used within MontageServer.java.
 * @author Greg Kogut, Da Lu
 *
 */
public class DatabaseManager {
	/**Entity manager factory.*/
	private EntityManagerFactory emf;
	/**Entity manager*/
	private EntityManager em;
	
	/**
	 * DatabaseManager constructor.
	 */
	public DatabaseManager() {
		this.emf = Persistence.createEntityManagerFactory("MontagePersistence");
	}
	
	public void addUser(String u) {
		//TODO don't add a string to the database
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Add a text post to the database.
	 * @param t textpost to add
	 */
	public void addTextPost(TextPostImpl t) {
		
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		TextPostHib t1 = new TextPostHib();
		//t1.setCoordinates(t.getCoordinates());
		t1.setUploadTime(t.getUploadTime());
		t1.setUserDownVotes(t.getUserDownVotes());
		t1.setUserUpVotes(t.getUserUpVotes());
		t1.setTextPost(t.getTextPost());
		em.persist(t1);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Add a photo post to the database.
	 * @param p photo post to add
	 */
	public void addPhotoPost(PhotoImpl p) {
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		PhotoHib t1 = new PhotoHib();
		//t1.setCoordinates(t.getCoordinates());
		t1.setUploadTime(p.getUploadTime());
		t1.setUserDownVotes(p.getUserDownVotes());
		t1.setUserUpVotes(p.getUserUpVotes());
		t1.setPhoto(p.getPhoto());
		em.persist(t1);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Add media to the database
	 * @param m media to add
	 */
	public void addMedia(Media m) {
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	public void updateCoordinate(Coordinates c ) {
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		
		
		
		
		
		em.persist(c);
		em.getTransaction().commit();
		em.close();	
	}
	public void updateGridSquare(GridSquare g) {
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		
		
		
		
		//GridSquareHib g1 = new GridSquareHib(c,c1,c2,c3);
		//g1.setMedia(g.getMedia());
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public GridSquareHib returnGridSquare(int id) {
		this.em = emf.createEntityManager();
		this.em.getTransaction().begin();
		GridSquareHib g = em.find(GridSquareHib.class, id);
		em.getTransaction().commit();
		em.close();
		return g;
	}
}
