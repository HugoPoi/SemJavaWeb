package org.esgi.web;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.Velocity;
import org.esgi.module.leanforge.Home;
import org.esgi.module.leanforge.TutorialCategories;
import org.esgi.module.leanforge.TutorialCategory;
import org.esgi.module.leanforge.TutorialManager;
import org.esgi.module.leanforge.TutorialSoftware;
import org.esgi.module.leanforge.TutorialSoftwares;
import org.esgi.module.leanforge.TutorialStepDisplay;
import org.esgi.module.leanforge.TutorialUpload;
import org.esgi.module.leanforge.model.TutorialModel;
import org.esgi.module.user.Administration;
import org.esgi.module.user.Login;
import org.esgi.web.action.IAction;
import org.esgi.web.action.IContext;
import org.esgi.web.layout.LayoutRenderer;
import org.esgi.web.route.Router;

/**
 * Le frontcontroller est
 * le lien entre tomcat et votre
 * framework. Il génère le context pour 
 * chaque requete et peu contenir des filtres 
 * d'entree et de sortie pour chaque requette
 * exemple validateur de champs ou compression gzip.
 *
 */
public class FrontController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Router router = new Router();
	Properties mainConfig = new Properties();
	private LayoutRenderer layoutRender;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Do the init config operations behind this
		String path = config.getServletContext().getRealPath("/");
		System.out.println("try load config");
		try {
			mainConfig.load(this.getClass().getClassLoader().getResourceAsStream("config.ini"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Config Loaded bordel !!");
		mainConfig.setProperty("realpath", path);
		mainConfig.put("imgbaseurl", mainConfig.getProperty("context") + mainConfig.getProperty("image.path"));
		
		Properties configVelocity = new Properties();
		configVelocity.setProperty("file.resource.loader.path", config.getServletContext().getRealPath("/") + mainConfig.getProperty("template.path")+ "/");
		configVelocity.setProperty("input.encoding", "UTF-8");
		configVelocity.setProperty("output.encoding", "UTF-8");
		configVelocity.setProperty("default.contentType", "UTF-8");
		Velocity.init(configVelocity);
		
		//Model
		TutorialModel data = new TutorialModel(mainConfig);
		
		// register and inject dependencies
		// registerAction(new Module());
		registerAction(new Home());
		registerAction(new TutorialStepDisplay(mainConfig, data));
		registerAction(new TutorialUpload(mainConfig,data));
		registerAction(new TutorialCategory(mainConfig,data));
		registerAction(new TutorialCategories(mainConfig,data));
		registerAction(new Login());
		registerAction(new Administration(mainConfig, data));
		registerAction(new TutorialManager(mainConfig, data));
		registerAction(new TutorialSoftwares(mainConfig, data));
		registerAction(new TutorialSoftware(mainConfig, data));
		
		layoutRender = new LayoutRenderer();
	}
	@Override
	public void service(HttpServletRequest 
			request, HttpServletResponse response)
					throws ServletException, IOException {

		request.getSession(true);
		String url = request.getPathInfo();
		IContext context = createContext(request, response);
		IAction action = router.find(url, context);
		
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Content-Type", "text/html; charset=utf-8");

		if (null != action){
			
			if(action.getMinimumRole() != null){
				if(context.getConnectedUser() == null){
					response.sendRedirect(context.getConfig("context") + "/login");
					return;
				}
			}

			if (null == action.getLayout()) {
				try {
					action.execute(context);
				} catch (Exception e) {
					throw new ServletException(e);
				}
			} else {
				try {
					layoutRender.render(action, context, router);
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
		}

	}

	private IContext createContext(HttpServletRequest request, 
			HttpServletResponse response) {
		return new Context(request, response, mainConfig);
	}

	public void registerAction(IAction action) {
		router.register(action);
	}
}
