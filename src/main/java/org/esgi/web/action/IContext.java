package org.esgi.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.velocity.VelocityContext;
import org.esgi.orm.model.User;
import org.esgi.web.NotifyError;

public interface IContext {

	Object getParameter(String key);
	void setParameter(String key, Object o);
	String getConfig(String key);
	// Object instance must have a toString implementation.
	Object getFragment(String fragment);
	void setFragment(String fragment, Object o);
	String getPageTitle();
	void setPageTitle(String title);
	HttpServletRequest getRequest();
	HttpServletResponse getResponse();
	VelocityContext getVelocityContext();
	void addKeyword(String keyword);
	void setDescription(String description);
	void addJSDependency(String url);
	void addCSSDependency(String url);
	void addInlineCSS(String cssRule);
	void addRawHeader(String rawHeadLine);
	void addOnJsReady(String str);
	User getConnectedUser();
	void setConnectedUser(User in);
	Map<String,NotifyError> getErrors();
	void addError(String identifier, NotifyError error);
	Map<String, String> getMultipartParameters();
	Map<String, FileItem> getFiles();
}