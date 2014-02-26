package org.esgi.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.esgi.web.action.IContext;

public class Context implements IContext {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private VelocityContext velocityContext;
	public Properties properties;

	Context(HttpServletRequest _request, HttpServletResponse _response, Properties properties){
		request = _request;
		response = _response;
		this.properties = properties;
		this.velocityContext = new VelocityContext();
		this.velocityContext.put("context", this);
	}
	@Override
	public Object getAttribute(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String key, Object o) {
		// TODO Auto-generated method stub

	}

	Map<String, Object> mapParameters = new HashMap<>();
	Map<String, Object> mapFragments = new HashMap<>();
	
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
	public Properties getProperties() {
		return properties;
	}
	@Override
	public Object getFragment(String fragment) {
		return mapFragments.get(fragment);
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFragment(String fragment, Object o) {
		mapFragments.put(fragment, o);
		
	}
	
	public VelocityContext getVelocityContext(){
		return velocityContext;
	}

}
