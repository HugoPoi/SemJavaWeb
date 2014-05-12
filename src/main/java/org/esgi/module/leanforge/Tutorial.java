package org.esgi.module.leanforge;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class Tutorial extends AbstractAction {
	
	@Override
	public void execute(IContext context) throws Exception {
		context.setPageTitle(context.getParameter("tutorial") + " " + context.getParameter("step"));
		context.getVelocityContext().put("title", context.getParameter("tutorial") + " " + context.getParameter("step"));
	}
	
	public String getRoute() {
		return "^/tutorial/([^/]+)/([^/]+)$";
	}


	public String[] getRewriteGroups() {
		return new String[]{"tutorial","step"};
	}

}
