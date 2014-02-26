package net.hugopoi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class IndexesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Boolean autoIndex = false;
	protected String staticRoot = ".";
	
	protected Template indexesTemplate = null;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		autoIndex = Boolean.parseBoolean(config.getInitParameter("autoindex"));
		staticRoot = config.getInitParameter("static-root");
		Properties p = new Properties();
		p.setProperty("file.resource.loader.path", config.getServletContext().getRealPath("/"));
		Velocity.init(p);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		indexesTemplate = Velocity.getTemplate("indexes.vm");
		String cutUrl = request.getPathInfo();
		if(cutUrl == null){
			cutUrl = "";
		}
		System.out.println(cutUrl);
		
		Path path = null;
		try {
			path = Paths.get(this.staticRoot+"/"+ new java.net.URI(cutUrl).getPath());
		} catch (URISyntaxException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		String parenturl = request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"))+"/";
		
		if(!Files.isDirectory(path)){
			if(request.getParameter("delete") != null){
				path.toFile().delete();
				response.sendRedirect(parenturl);
				return;
			}
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
			VelocityContext vcontext = new VelocityContext();
			vcontext.put("title",path.toAbsolutePath().toString());
			DirectoryStream<Path> test = Files.newDirectoryStream(path);
			
//			Hashtable<String, Path> itemlist = new Hashtable<>();
//			for (Path path2 : test) {
//				itemlist.put(path2.getFileName().toString(), path2);
//			}
			
			vcontext.put("items", test.iterator());
			vcontext.put("currenturl", request.getRequestURL());
			System.out.println(request.getRequestURL().toString());
			System.out.println(parenturl);
			
			if(!parenturl.equals(request.getRequestURL().toString())){
				vcontext.put("parenturl",  parenturl);
			}
			indexesTemplate.merge(vcontext, response.getWriter());
			return;
		}else{
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
