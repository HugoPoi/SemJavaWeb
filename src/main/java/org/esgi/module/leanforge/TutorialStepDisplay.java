package org.esgi.module.leanforge;

import java.util.Properties;
import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

import dev.leanforge.tutorialschema.Tutorial.Content;
import dev.leanforge.tutorialschema.Tutorial.Content.Step;

public class TutorialStepDisplay extends AbstractAction {
	
	TutorialModel mdata;
	Properties mainConfig;
	
	public TutorialStepDisplay(Properties config, TutorialModel mdata) {
		super(config);
		this.mdata = mdata;
		mainConfig = config;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		context.addCSSDependency(context.getConfig("context")+ "/res/css/style.css");
		context.setPageTitle(context.getParameter("tutorial") + " " + context.getParameter("step"));
		
		dev.leanforge.tutorialschema.Tutorial tutorialData = mdata.loadedTutorials.get(context.getParameter("tutorial"));
		
		context.getVelocityContext().put("tutorial", tutorialData);
		
		String lang = context.getRequest().getHeader("Accept-Language");
		Content selectedContent = TutorialModel.getContentForLang(tutorialData, lang);


		Step selectedStep = selectedContent.getStep().get(Integer.parseInt((String) context.getParameter("step")));
		
		context.getVelocityContext().put("metas", tutorialData.getMeta());
		context.getVelocityContext().put("tutorialBaseURL", context.getConfig("context") + "/tutorial/" + context.getParameter("tutorial"));
		context.getVelocityContext().put("tutorialStep", selectedStep);
		context.getVelocityContext().put("tutorialContent", selectedContent);
		context.getVelocityContext().put("title", selectedContent.getTitle() + " - " + selectedStep.getName());
		context.getVelocityContext().put("tutorialressources", context.getConfig("context") + mainConfig.getProperty("tutorial.ressources.repository") + "/" + context.getParameter("tutorial"));
		
		Integer currentStep = Integer.parseInt((String) context.getParameter("step"));
		
		if(currentStep + 1 < selectedContent.getStep().size()) context.getVelocityContext().put("next", context.getConfig("context") + "/tutorial/" + context.getParameter("tutorial") + "/" + (currentStep+1));
		if(currentStep - 1 >= 0) context.getVelocityContext().put("previous", context.getConfig("context") + "/tutorial/" + context.getParameter("tutorial") + "/" + (currentStep-1));
	}
	
	public String getRoute() {
		return "^/tutorial/([^/]+)/([^/]+)$";
	}


	public String[] getRewriteGroups() {
		return new String[]{"tutorial","step"};
	}

}
