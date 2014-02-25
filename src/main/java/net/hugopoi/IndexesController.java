package net.hugopoi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Boolean autoIndex = false;
	protected String staticRoot = ".";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		autoIndex = Boolean.parseBoolean(config.getInitParameter("autoindex"));
		staticRoot = config.getInitParameter("static-root");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String cutUrl = request.getRequestURI().split("/",4)[3];
		Path path = Paths.get(this.staticRoot+"/"+cutUrl);
		
		if(!Files.isDirectory(path)){
			response.setContentType(Files.probeContentType(path));
			byte buffer[] = new byte[16384];
			OutputStream outbin = response.getOutputStream();
			InputStream inbin = Files.newInputStream(path);
			while(inbin.read(buffer) != -1){
				outbin.write(buffer);
			}
			inbin.close();
			outbin.close();
		}else if (Files.isDirectory(path) && autoIndex) {
			request.setAttribute("title", "Mon Titre" );
			request.setAttribute("items", Files.newDirectoryStream(path));
			String parenturl = request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"))+"/";
			System.out.println(request.getRequestURL().toString());
			System.out.println(parenturl);
			if(!parenturl.equals(request.getRequestURL().toString())){
				request.setAttribute("parenturl",  parenturl);
			}
			request.getRequestDispatcher("/indexes.jsp").include(request, response);
		}else{
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
