package net.hugopoi;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

public class HelloWorldServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE ="text/html";
	private Hashtable<String, String> params = null;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		params = new Hashtable<String, String>();
		Enumeration<String> servletParams = config.getServletContext().getInitParameterNames();
		for (String pname : Collections.list(servletParams)) {
			params.put(pname, config.getServletContext().getInitParameter(pname));
		}
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>TEST !!!<ul>");
		for(String i : params.values()){
			out.print("<li>"+i+"</li>");
		}
		out.println("</ul></body></html>");
	}
	
}
