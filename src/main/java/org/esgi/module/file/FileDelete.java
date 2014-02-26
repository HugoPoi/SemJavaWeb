package org.esgi.module.file;

import java.io.File;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class FileDelete extends AbstractAction {

	@Override
	public void execute(IContext context) throws Exception {
		File file = new File (context.getProperties().get("file.repository").toString() +"/"+ context.getParameter("path"));
		file.delete();
		context.getResponse().sendRedirect("file/list/" + context.getParameter("path").toString().substring(0,context.getParameter("path").toString().lastIndexOf("/")) + "/");
	}

	@Override
	public String getRoute() {
		return "/file/delete/((.+)[^/])$";
	}

	@Override
	public String[] getRewriteGroups() {
		return new String[]{"path"};
	}

}
