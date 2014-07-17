package org.esgi.module.leanforge.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.esgi.orm.ORM;
import org.esgi.orm.model.UploadedTutorial;

import dev.leanforge.tutorialschema.Tutorial;
import dev.leanforge.tutorialschema.Tutorial.Content;

public class TutorialModel {

	Properties mainConfig;
	public HashMap<String, dev.leanforge.tutorialschema.Tutorial> loadedTutorials;

	JAXBContext jc = null;
	Unmarshaller unmarshaller = null;
	
	public TutorialModel(Properties config) {
		mainConfig = config;
		loadedTutorials = new HashMap<>();

		// jaxb2 init
		try {
			jc = JAXBContext.newInstance("dev.leanforge.tutorialschema");
			unmarshaller = jc.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loadAllTutorials();
	}

	public void loadAllTutorials() {
		// init and load all files
		File tutorialsDir = new File(mainConfig.getProperty("realpath")
				+ mainConfig.getProperty("tutorial.repository"));

		loadedTutorials = new HashMap<>();
		for (File tutorialfile : tutorialsDir.listFiles()) {
			try {
				loadOneFile(tutorialfile);
			} catch (JAXBException e) {
				e.printStackTrace();
				tutorialfile.delete();
			}
		}
	}

	public void reloadOneTutorial(String idname) throws JAXBException {
		File tutorialfile = new File(mainConfig.getProperty("realpath")
				+ mainConfig.getProperty("tutorial.repository") + "/" + idname + ".xml");
		loadOneFile(tutorialfile);
	}

	public void loadOneFile(File tutorialfile) throws JAXBException {
		//TODO : utf8 formating problem
		if (tutorialfile.isFile() && tutorialfile.getName().endsWith(".xml")) {
				dev.leanforge.tutorialschema.Tutorial tutorialData = (dev.leanforge.tutorialschema.Tutorial) unmarshaller
						.unmarshal(tutorialfile);
				loadedTutorials.put(tutorialfile.getName().split(".xml")[0],
						tutorialData);
		}
	}
	
	public static Content getContentForLang(Tutorial tutorialData, String lang){
		Content selectedContent = null;
		for (Content content : tutorialData.getContent()) {
			if(content.getLang().toLowerCase().equals("fr-fr")){
				selectedContent = content;
			}
			if(content.getLang().toLowerCase().equals(lang)){
				selectedContent = content;
			}
		}
		return selectedContent;
	}
	
	public void deleteTutorial(String idname){
		File tutorialfile = new File(mainConfig.getProperty("realpath") + mainConfig.getProperty("tutorial.repository") + "/" + idname + ".xml");
		tutorialfile.delete();
		loadedTutorials.remove(idname);
		HashMap<String, Object> filter = new HashMap<String, Object>();
		filter.put("tutorialName", idname);
		List<Object> result = ORM.find(UploadedTutorial.class, null, filter, null, 1, null);
		if (result.size() >= 1) {
			UploadedTutorial ut = (UploadedTutorial) result.get(0);
			ORM.remove(ut);
		}
		
	}
	
	public Map<String, String> getSoftwares(){
		Map<String, String> Softwares = new HashMap<String, String>();
		
		for (Tutorial el : loadedTutorials.values()) {
			try{
			Softwares.put(el.getMeta().getSoftware().getId(), el.getMeta().getSoftware().getName());
			}
			catch(Exception e){
				
			}
		}
		return Softwares;
	}
	

}
