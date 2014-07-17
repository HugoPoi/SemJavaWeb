package org.esgi.module.leanforge;

import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class TutorialCategories extends AbstractAction {
	TutorialModel mdata;
	
	public TutorialCategories(Properties config, TutorialModel mdata){
		super(config);
		this.mdata = mdata;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		context.addCSSDependency(context.getConfig("context")+ "/res/css/style.css");
		context.setPageTitle("Start coding");
		context.getVelocityContext().put("categoryBaseUrl",context.getConfig("context")+"/category/");
		context.getVelocityContext().put("categories", dev.leanforge.tutorialschema.Leancategory.values());
	}
	
	@Override
	public String getRoute() {
		return "^/categories$";
	}
	
}
