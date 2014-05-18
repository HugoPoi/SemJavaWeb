package org.esgi.module.leanforge;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class TutorialCategory extends AbstractAction {
	
	@Override
	public void execute(IContext context) throws Exception {
		
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
