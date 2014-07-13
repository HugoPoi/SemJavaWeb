package org.esgi.module.user;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class Administration extends AbstractAction{
	
	@Override
	public String getRoute() {
		return "/manager";
	}
	
	public void execute(IContext context) throws Exception {
		System.out.println(context.getConnectedUser().login);
	}
}
