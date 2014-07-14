package org.esgi.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.VelocityContext;
import org.esgi.orm.model.User;
import org.esgi.web.action.IContext;

public class Context implements IContext {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private VelocityContext velocityContext;
	public Properties config;
	
	Map<String, Object> mapParameters;
	Map<String, Object> mapFragments;
	Map<String, NotifyError> errors;
	
	public String pageTitle;
	public String pageMetaDescription;
	public List<String> keywords;
	
	public Set<String> jsUrls;
	public Set<String> cssUrls;
	
	public List<String> inlineCss;
	public List<String> rawHeaders;
	
	Map<String, String> multipartParameters;
	Map<String, FileItem> files;

	Context(HttpServletRequest _request, HttpServletResponse _response, Properties properties){
		request = _request;
		response = _response;
		this.config = properties;
		this.velocityContext = new VelocityContext();
		this.velocityContext.put("context", this);
		
		mapParameters = new HashMap<>();
		mapFragments = new HashMap<>();
		keywords = new ArrayList<String>();
		errors = new HashMap<String, NotifyError>();
		
		jsUrls = new TreeSet<String>();
		cssUrls = new TreeSet<String>();
		
		inlineCss = new ArrayList<>();
		
		multipartParameters = new HashMap<String, String>();
		files = new HashMap<String, FileItem>();
		
		if(ServletFileUpload.isMultipartContent(_request)){
			FileItemFactory fif = new DiskFileItemFactory(); 
			ServletFileUpload servletFileUpload = new ServletFileUpload(fif);
			
			try {
				for (FileItem item : servletFileUpload.parseRequest(_request)) {
				    if (item.isFormField()) {
				        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
				    	multipartParameters.put(item.getFieldName(), item.getString());
				    } else {
				        // Process form file field (input type="file").
				    	multipartParameters.put(item.getFieldName(), FilenameUtils.getName(item.getName()));
				        files.put(item.getFieldName(), item);
				    }
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Set<String> getCssUrls(){
		return cssUrls;
	}
	
	@Override
	public Object getParameter(String key) {
		
		return mapParameters.get(key);
	}

	@Override
	public void setParameter(String key, Object o) {
		mapParameters.put(key, o);
	}

	@Override
	public HttpServletRequest getRequest() {

		return this.request;
	}

	@Override
	public HttpServletResponse getResponse() {
		return this.response;
	}
	
	@Override
	public String getConfig(String key) {
		return config.getProperty(key);
	}
	
	@Override
	public Object getFragment(String fragment) {
		return mapFragments.get(fragment);
	}

	@Override
	public void setFragment(String fragment, Object o) {
		mapFragments.put(fragment, o);
		
	}
	
	@Override
	public VelocityContext getVelocityContext(){
		return velocityContext;
	}
	
	@Override
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}
	@Override
	public void setDescription(String description) {
		pageMetaDescription = description;
	}
	public String getDescription() {
		return pageMetaDescription;
	}
	@Override
	public void addJSDependency(String url) {
		jsUrls.add(url);
	}
	@Override
	public void addCSSDependency(String url) {
		cssUrls.add(url);
	}
	@Override
	public void addInlineCSS(String cssRule) {
		inlineCss.add(cssRule);
	}
	@Override
	public void addRawHeader(String rawHeadLine) {
		rawHeaders.add(rawHeadLine);
	}

	@Override
	public String getPageTitle() {
		if(this.getVelocityContext().get("title") != null){
			return (String) this.getVelocityContext().get("title");
		}
		return pageTitle;
	}

	@Override
	public void setPageTitle(String title) {
		pageTitle = title;
	}
	
	public String genKeywords(){
		if(keywords.size() > 0){
			StringBuffer impKeywords = new StringBuffer();
			Iterator<String> i = this.keywords.iterator();
			while(i.hasNext()) {
				impKeywords.append(i.next());
				if(i.hasNext()) impKeywords.append(",");
			}
			return impKeywords.toString();
		}
		return null;
	}

	List<String> onJsReady = new ArrayList<>();
	@Override
	public void addOnJsReady(String str) {
		onJsReady.add(str);
	}
	public List<String> getOnJsReady(){
		return onJsReady;
	}
	public Set<String> getJsUrls() {
		return jsUrls;
	}
	
	public User getConnectedUser(){
		User currentUser = (User) this.request.getSession().getAttribute("user");
		if(currentUser != null){
			return currentUser;
		}
		return null;
	}

	@Override
	public void setConnectedUser(User in) {
		this.request.getSession().setAttribute("user", in);
	}

	@Override
	public Map<String, NotifyError> getErrors() {
		return errors;
	}

	@Override
	public void addError(String identifier, NotifyError error) {
		errors.put(identifier, error);
	}

	@Override
	public Map<String, String> getMultipartParameters() {
		return multipartParameters;
	}

	@Override
	public Map<String, FileItem> getFiles() {
		return files;
	}
	

}
