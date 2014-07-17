package org.esgi.module.leanforge;

import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class TutorialSoftwares extends AbstractAction{
	TutorialModel mdata;
	
	public TutorialSoftwares(Properties config, TutorialModel mdata){
		super(config);
		this.mdata = mdata;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		context.addCSSDependency(context.getConfig("context")+ "/res/css/style.css");
		context.setPageTitle("Software liste");
		context.getVelocityContext().put("softwareBaseUrl",context.getConfig("context")+"/software/");
		

		
		context.getVelocityContext().put("softwares", mdata.getSoftwares());
	}
	
	@Override
	public String getRoute() {
		return "^/softwares$";
	}
}
