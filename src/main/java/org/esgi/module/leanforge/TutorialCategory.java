package org.esgi.module.leanforge;

import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;


public class TutorialCategory extends AbstractAction {
	
	TutorialModel mdata;
	
	public TutorialCategory(Properties config, TutorialModel mdata){
		super(config);
		this.mdata = mdata;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		System.out.println("Category LOG");
		context.getVelocityContext().put("category", "Test de category");
		context.getVelocityContext().put("tutorials", mdata.loadedTutorials.values());
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
