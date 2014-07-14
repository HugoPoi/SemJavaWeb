package org.esgi.web;

public enum NotifyType {

	  Error ("danger"),
	  Warning ("warning"),
	  Success ("success"),
	  Info ("info");
	   
	  private String name = "";
	   
	  //Constructeur
	  NotifyType(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }

}
