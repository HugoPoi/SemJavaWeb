package org.esgi.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.esgi.orm.model.User;

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
	Map<String,String> getErrors();
	void addError(String identifier, String message);
}