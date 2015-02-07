package edu.jhu.cs.oose.montage.model.hibernate.media;

import javax.persistence.Basic;
import javax.persistence.Entity;

import edu.jhu.cs.oose.montage.model.iface.media.TextPost;
@Entity
public class TextPostHib extends MediaHib implements TextPost{

	private String textPost;
	
	
	@Basic
	public String getTextPost(){
		return this.textPost;
	}


	public void setTextPost(String t) {
		this.textPost = t;
	}


	
}
