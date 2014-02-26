package org.esgi.module.file;

import java.io.File;

import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class FileList extends AbstractAction {

	@Override
	public void execute(IContext context) throws Exception {
		
		File repo = new File((String) context.getProperties().get("file.repository"));

		String path = (String) context.getParameter("path");
		
		if (null != path) {
			repo = new File(repo, path);
		}
		System.out.println("On rentre bien dans fileList");
		context.getVelocityContext().put("items", repo.listFiles());
		context.getVelocityContext().put("title", "Bonjour MAMADOU !!!!");
		/*
		context.setAttribute("files", repo);
		context.getResponse().setContentType("text/html");
		writer.append("<ul>");
		for (File child : repo.listFiles()) {
			String nextChildPath = child.getName() + (child.isDirectory() ? "/" : "");
			if (child.isDirectory()){
				writer.append("<li><a href=\""+nextChildPath+"\">"+child.getName()+"</a></li>");
			}
			else{
				if(path == null){
					writer.append("<li><a href=\""+nextChildPath+"\">"+child.getName()+"</a> - <a href=\"/EsgiRouter/file/delete/"
							+ child.getName() +"\"> DELETE</a> </li>");
				}
				else{
					writer.append("<li><a href=\""+nextChildPath+"\">"+child.getName()+"</a> - <a href=\"/EsgiRouter/file/delete/"
							+ ""+ path +"/"+ child.getName() +"\"> DELETE</a> </li>");	
				}
				
			}
		}
		
		if(path!=null){
			String pathReturn = context.getRequest().getRequestURI().substring(0,context.getRequest().getRequestURI().lastIndexOf("/"));
			pathReturn = pathReturn.substring(0,pathReturn.lastIndexOf("/"));
			writer.append("<li><a href=\""+pathReturn+"/\">RETOUR ...</a></li>");
		}
		writer.append("</ul>");
		System.out.println(path);
		writer.append("<form action=\"/EsgiRouter/file/upload/"+path+"\" method=\"post\" enctype=\"multipart/form-data\">"
				+ "Fichier à uploader:<br/>"
				+ "<input type=\"file\" size=\"50\" name=\"file1\"><br/>"
				+ "<input type=\"submit\" value=\"Upload\">"
				+ "</form>");
	    */
	}


	public String getRoute() {
		return "/file/list/(?:(.+)?/)?$";
	}


	public String[] getRewriteGroups() {
		return new String[]{"path"};
	}

}
