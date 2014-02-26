package org.esgi.web.action;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;

public interface IContext {
	Object getAttribute(String key);
	void setAttribute(String key, Object o);
	Object getParameter(String key);
	void setParameter(String key, Object o);
	Properties getProperties();
	// Object instance must have a toString implementation.
	Object getFragment(String fragment);
	void setFragment(String fragment, Object o);
	String getTitle();
	void setTitle(String title);
	HttpServletRequest getRequest();
	HttpServletResponse getResponse();
	VelocityContext getVelocityContext();
}