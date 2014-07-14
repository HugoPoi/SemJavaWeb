package org.esgi.orm.model;

import java.sql.Date;

import org.esgi.orm.annotations.ORM_AUTO_INCREMENT;
import org.esgi.orm.annotations.ORM_PK;
import org.esgi.orm.annotations.ORM_TABLE;

@ORM_TABLE("uploadedtutorial")
public class UploadedTutorial {
	@ORM_PK
	@ORM_AUTO_INCREMENT
	public Integer id;
	
	public Integer user_id;
	public String tutorialName;
	public Date uploaded;
	
	public UploadedTutorial(Integer user_id, String tutorialName, Date uploaded) {
		super();
		this.user_id = user_id;
		this.tutorialName = tutorialName;
		this.uploaded = uploaded;
	}
	
	public UploadedTutorial(){
		super();
	}
}
