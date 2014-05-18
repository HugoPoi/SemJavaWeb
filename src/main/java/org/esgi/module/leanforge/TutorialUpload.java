package org.esgi.module.leanforge;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class TutorialUpload extends AbstractAction {
	
	TutorialModel mdata;
	Properties mainConfig;
	
	public TutorialUpload(Properties config,TutorialModel mdata) {
		super();
		this.mainConfig = config;
		this.mdata = mdata;
	}
	
	@Override
	public void execute(IContext context) throws Exception {
		context.setPageTitle("Upload a Tutorial or an update");
		boolean isMultipart = ServletFileUpload.isMultipartContent(context.getRequest());
		if(isMultipart){

			FileItemFactory fif = new DiskFileItemFactory(); 
			
			ServletFileUpload servletFileUpload = new ServletFileUpload(fif); 
			
			try{

				List<FileItem> fileList = servletFileUpload.parseRequest(context.getRequest());
				FileItem uploadedFile = fileList.get(0);
				
				//test if form have filename
				if(uploadedFile.getName().equals("")){
					throw new Exception("Empty filename");
				}
				
				//Save new file
				File fileOnDisk = new File(mainConfig.getProperty("realpath")
						+ mainConfig.getProperty("tutorial.repository") + "/" + uploadedFile.getName());
				System.out.println("New tutorial uploaded to : " + fileOnDisk.getAbsolutePath());
				uploadedFile.write(fileOnDisk);
				
				mdata.reloadOneTutorial(fileOnDisk.getName().split(".xml$")[0]);
				
			}
			catch (Exception e){
				throw e;
			}
		}
		
		//Send an error correctly :
		//context.getResponse().sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		//throw new Exception("500");

	}
	
	public String getRoute() {
		return "^/upload$";
	}


	public String[] getRewriteGroups() {
		return new String[]{};
	}

}
