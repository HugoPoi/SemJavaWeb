package org.esgi.module.file;

import java.io.File;
import java.io.Writer;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class FileUpload extends AbstractAction {

	@Override
	public void execute(IContext context) throws Exception {
		System.out.println("ok up");
boolean isMultipart = ServletFileUpload.isMultipartContent(context.getRequest());
Writer writer = context.getResponse().getWriter();
		if(isMultipart){
			//La factory qui cr�e des FileItem, pour lire les infos de fichiers:
			FileItemFactory fif = new DiskFileItemFactory(); 
			
			//La classe qui parse les headers a la recherche de fichiers upload�s
			ServletFileUpload servletFileUpload = new ServletFileUpload(fif); 
			
			//Lire les infos du fichier
			try{

				List<FileItem> fileList = servletFileUpload.parseRequest(context.getRequest());
				FileItem uploadedFile = fileList.get(0);
				
				//Si aucun fichier n'a �t� saisi dans le form
				if(uploadedFile.getName().equals("")){
					writer.append("<p>Pas de fichier re�u</p>");
					writer.append("<a href='/FileUpload/site/upload.jsp'>Retour au formulaire</a>");
					return;
				}
				
				//On �crit le fichier
				
				File file = new File(context.getProperties().get("file.repository") + "/" + context.getParameter("path") + "/" + uploadedFile.getName());
				uploadedFile.write(file);
				context.getResponse().sendRedirect("file/list/" + context.getParameter("path") + "/");
				
				//On affiche la liste des fichiers upload�s
			}
			catch (FileUploadException fue){
				System.out.println("Exception: parseRequest a echoue");
				fue.printStackTrace();
			} catch (Exception e) {
				System.out.println("Exception: write file a echoue");
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getRoute() {
		return "/file/upload/((.+)[^/])$";
	}

	@Override
	public String[] getRewriteGroups() {
		return new String[]{"path"};
	}

}
