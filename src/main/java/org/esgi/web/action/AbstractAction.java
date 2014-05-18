package org.esgi.web.action;

import java.util.Properties;

public class AbstractAction implements IAction {
	
	protected Properties config;
	
	public AbstractAction(Properties config) {
		this.config = config;
	}
	
	public AbstractAction() {
		this.config = null;
	}

	@Override
	public void execute(IContext context) throws Exception {
		
	}

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRewriteGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLayout() {
		return "default";
	}

}
