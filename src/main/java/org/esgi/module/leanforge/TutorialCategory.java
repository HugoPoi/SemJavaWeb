package org.esgi.module.leanforge;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

import dev.leanforge.tutorialschema.Leancategory;
import dev.leanforge.tutorialschema.Tutorial;


public class TutorialCategory extends AbstractAction {
	
	TutorialModel mdata;
	
	public TutorialCategory(Properties config, TutorialModel mdata){
		super(config);
		this.mdata = mdata;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		context.getResponse().addHeader("Content-Type", "text/html; charset=utf-8");
		context.addCSSDependency(context.getConfig("context")+ "/res/css/style.css");
		context.setPageTitle((String) context.getParameter("category"));
		
		context.getVelocityContext().put("category", context.getParameter("category"));
		ArrayList<String> selectedTutos = new ArrayList<>();
		for(Entry<String, Tutorial> t : mdata.loadedTutorials.entrySet()){
			if(t.getValue().getMeta().getCategories().getCategory().contains(Leancategory.fromValue((String) context.getParameter("category")))){
				selectedTutos.add(t.getKey());
			}
		}
		context.getVelocityContext().put("TutorialModel", TutorialModel.class);
		context.getVelocityContext().put("tutorials", selectedTutos);
		context.getVelocityContext().put("tutorialsData", mdata.loadedTutorials);
		context.getVelocityContext().put("tutorialBaseURL", context.getConfig("context") + "/tutorial/");
	}
	
	@Override
	public String getRoute() {
		return "^/category/([^/]*)$";
	}
	
	@Override
	public String[] getRewriteGroups() {
		return new String[]{"category"};
	}
	

}
