package org.esgi.module.leanforge.model;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
		if(tutorialsDir != null) return;
		else{
			for (File tutorialfile : tutorialsDir.listFiles()) {
				loadOneFile(tutorialfile);
			}
		}
	}

	public void reloadOneTutorial(String idname) {
		File tutorialfile = new File(mainConfig.getProperty("realpath")
				+ mainConfig.getProperty("tutorial.repository") + "/" + idname + ".xml");
		loadOneFile(tutorialfile);
	}

	public void loadOneFile(File tutorialfile) {
		//TODO : utf8 formating problem
		if (tutorialfile.isFile() && tutorialfile.getName().endsWith(".xml")) {
			try {
				dev.leanforge.tutorialschema.Tutorial tutorialData = (dev.leanforge.tutorialschema.Tutorial) unmarshaller
						.unmarshal(tutorialfile);
				loadedTutorials.put(tutorialfile.getName().split(".xml")[0],
						tutorialData);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
