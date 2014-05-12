package org.esgi.module.leanforge;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

import dev.leanforge.tutorialschema.Tutorial.Content;
import dev.leanforge.tutorialschema.Tutorial.Content.Step;

public class Tutorial extends AbstractAction {
	
	@Override
	public void execute(IContext context) throws Exception {
		context.setPageTitle(context.getParameter("tutorial") + " " + context.getParameter("step"));
		
		
		File tutorialfile = new File(context.getConfig("realpath") + context.getConfig("tutorial.repository") + "/" +context.getParameter("tutorial") + ".xml");
		
		JAXBContext jc = JAXBContext.newInstance("dev.leanforge.tutorialschema");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		dev.leanforge.tutorialschema.Tutorial tutorialData = (dev.leanforge.tutorialschema.Tutorial) unmarshaller.unmarshal(tutorialfile);
		
		context.getVelocityContext().put("tutorial", tutorialData);
		
		String lang = context.getRequest().getHeader("Accept-Language");
		Content selectedContent = null;
		for (Content content : tutorialData.getContent()) {
			if(content.getLang().toLowerCase().equals("fr-fr")){
				selectedContent = content;
			}
			if(content.getLang().toLowerCase().equals(lang)){
				selectedContent = content;
			}
		}

		Step selectedStep = selectedContent.getStep().get(Integer.parseInt((String) context.getParameter("step")));
		
		context.getVelocityContext().put("tutorialBaseURL", context.getConfig("context") + "/tutorial/" + context.getParameter("tutorial"));
		context.getVelocityContext().put("tutorialStep", selectedStep);
		context.getVelocityContext().put("tutorialContent", selectedContent);
		context.getVelocityContext().put("title", selectedContent.getTitle() + " - " + selectedStep.getName());
		
	}
	
	public String getRoute() {
		return "^/tutorial/([^/]+)/([^/]+)$";
	}


	public String[] getRewriteGroups() {
		return new String[]{"tutorial","step"};
	}

}
