package edu.jhu.cs.oose.montage.model.hibernate.media;

import javax.persistence.Entity;
import javax.persistence.Lob;





import edu.jhu.cs.oose.montage.model.iface.media.Photo;
@Entity
public class PhotoHib extends MediaHib implements Photo{

	private byte[] photo;
	@Lob
	public byte[] getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(byte[] p) {
		this.photo = p;
		
	}

}
