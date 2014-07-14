package org.esgi.module.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.orm.ORM;
import org.esgi.orm.model.UploadedTutorial;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class Administration extends AbstractAction{
	
	TutorialModel mdata;
	
	public Administration(Properties config, TutorialModel mdata) {
		super(config);
		this.mdata = mdata;
	}
	
	@Override
	public String getRoute() {
		return "^/manager$";
	}
	
	public void execute(IContext context) throws Exception {
		context.setPageTitle("Admin Manager");
		
		context.getVelocityContext().put("tutorials", mdata.loadedTutorials);
		context.getVelocityContext().put("TutorialModel", TutorialModel.class);
		
		if(context.getConnectedUser().role == null || !context.getConnectedUser().role.equals("admin")){
			HashMap<String, Object> filter = new HashMap<String, Object>();
			filter.put("user_id", context.getConnectedUser().id);
			List<Object> result = ORM.find(UploadedTutorial.class, new String[]{"tutorialName"}, filter, null, 1, null);
			List<String> userTutorials = new ArrayList<>();
			for (Object tutoUpload : result) {
				UploadedTutorial rUT = (UploadedTutorial) tutoUpload;
				userTutorials.add(rUT.tutorialName);
			}
			context.getVelocityContext().put("filter",userTutorials);
		}
		
		context.getVelocityContext().put("tutorialBaseURL", context.getConfig("context") + "/tutorial/");
		
	}
	
	@Override
	public String getMinimumRole() {
		return "admin";
	}
	@Override
	public String getLayout() {
		return "leanforgebo";
	}
}
