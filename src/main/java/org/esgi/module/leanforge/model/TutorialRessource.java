package org.esgi.module.leanforge.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TutorialRessource {
	
	Properties mainConfig;
	public TutorialRessource(Properties config) {
		super();
		mainConfig = config;
	}
	public void loadRessource(String idname, InputStream zipfile){
		byte[] buffer = new byte[4096];
		 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(mainConfig.getProperty("realpath") + mainConfig.getProperty("tutorial.ressources.repository") + "/" + idname);
	    	if(folder.exists()){
	    		folder.delete();
	    		folder.mkdir();
	    	}else{
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = new ZipInputStream(zipfile);
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(folder, fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Done");
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
	}

}
