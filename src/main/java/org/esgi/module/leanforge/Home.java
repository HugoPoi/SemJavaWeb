package org.esgi.module.leanforge;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class Home extends AbstractAction{
	
	@Override
	public void execute(IContext context) throws Exception {
		context.getVelocityContext().put("title", "Lean Forge | Home");
	}
	
	@Override
	public String getRoute() {
		return "^/$";
	}

}
