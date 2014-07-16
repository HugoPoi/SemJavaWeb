package org.esgi.module.leanforge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBException;

import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.orm.ORM;
import org.esgi.orm.model.UploadedTutorial;
import org.esgi.web.NotifyError;
import org.esgi.web.NotifyType;
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
	public void execute(IContext context){
		context.setPageTitle("Upload a new tutorial");
		
		if(context.getFiles().get("file") != null){
			File fileOnDisk = null;
			try {
				
				if(context.getFiles().get("file").getName().isEmpty() || !context.getFiles().get("file").getName().endsWith(".xml")){
					throw new FileNotFoundException("Nom de fichier incorrect.");
				}
				
				fileOnDisk = new File(mainConfig.getProperty("realpath")
						+ mainConfig.getProperty("tutorial.repository") + "/" + context.getFiles().get("file").getName());
				context.getFiles().get("file").write(fileOnDisk);
				
				mdata.reloadOneTutorial(fileOnDisk.getName().split(".xml$")[0]);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				context.addError("notxml", new NotifyError("Vous devez uploader un fichier XML", NotifyType.Error));
				fileOnDisk.delete();
				return;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				context.addError("parsingexception", new NotifyError("Votre fichier ne respecte pas le format XML.", NotifyType.Error));
				context.getVelocityContext().put("errordetails", e.getCause().toString().split(";"));
				fileOnDisk.delete();
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				context.addError("parsingexception", new NotifyError("Votre fichier ne respecte pas le format XML.", NotifyType.Error));
				context.getVelocityContext().put("errordetails", e.getCause().toString().split(";"));
				fileOnDisk.delete();
				e.printStackTrace();
				return;
			}
			HashMap<String, Object> filter = new HashMap<String, Object>();
			filter.put("user_id", context.getConnectedUser().id);
			filter.put("tutorialName", fileOnDisk.getName().split(".xml$")[0]);
			List<Object> result = ORM.find(UploadedTutorial.class, null, filter, null, 1, null);
			if (result.size() == 1) {
				UploadedTutorial ut = (UploadedTutorial) result.get(0);
				ut.uploaded = new java.sql.Date((new Date()).getTime());
				ORM.save(ut);
			}else{
				ORM.save(new UploadedTutorial(context.getConnectedUser().id,fileOnDisk.getName().split(".xml$")[0], new java.sql.Date((new Date()).getTime())));
			}
			context.addError("successupload", new NotifyError("Votre tutorial a été ajouté avec succès.", NotifyType.Success));
		}	

	}
	
	public String getRoute() {
		return "^/manager/upload$";
	}
	
	@Override
	public String getLayout() {
		return "leanforgebo";
	}
	
	@Override
	public String getMinimumRole() {
		return "editor";
	}


	public String[] getRewriteGroups() {
		return new String[]{};
	}

}
