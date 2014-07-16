package org.esgi.module.leanforge;


import java.util.Properties;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.module.leanforge.model.TutorialRessource;
import org.esgi.web.NotifyError;
import org.esgi.web.NotifyType;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class TutorialManager extends AbstractAction {
	
	TutorialModel mdata;
	TutorialRessource ressource;
	
	public TutorialManager(Properties config, TutorialModel mdata) {
		super(config);
		this.mdata = mdata;
		ressource = new TutorialRessource(config);
	}
	
	@Override
	public void execute(IContext context) throws Exception {

		if(context.getFiles().get("zipfile") != null){
				ressource.loadRessource(context.getMultipartParameters().get("idname"), context.getFiles().get("zipfile").getInputStream());
				context.addError("successaddzip", new NotifyError("Le zip a été décompressé pour "+ context.getMultipartParameters().get("idname") + ".", NotifyType.Success));
		}
		
		if(context.getMultipartParameters().get("delete") != null){
			mdata.deleteTutorial(context.getMultipartParameters().get("delete"));
			context.addError("infodeletetutorial", new NotifyError("Le tutorial "+ context.getMultipartParameters().get("delete") + "a été supprimé.", NotifyType.Info));
		}
	}
	
	
	
	@Override
	public String getRoute() {
		return "^/manager/tutorial$";
	}

}
