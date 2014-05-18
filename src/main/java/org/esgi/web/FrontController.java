package org.esgi.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.app.Velocity;
import org.esgi.module.leanforge.Home;
import org.esgi.module.leanforge.TutorialStepDisplay;
import org.esgi.module.leanforge.TutorialUpload;
import org.esgi.module.leanforge.model.TutorialModel;
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
		String configFile = config.getServletContext().getInitParameter("config");
		String path = config.getServletContext().getRealPath("/");

		try {
			mainConfig.load(new FileInputStream(path +"/" + configFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainConfig.setProperty("realpath", path);
		mainConfig.put("imgbaseurl", mainConfig.getProperty("context") + mainConfig.getProperty("image.path"));
		
		Properties configVelocity = new Properties();
		configVelocity.setProperty("file.resource.loader.path", config.getServletContext().getRealPath("/") + mainConfig.getProperty("template.path")+ "/");
		Velocity.init(configVelocity);
		
		//Model
		TutorialModel data = new TutorialModel(mainConfig);
		
		// register and inject dependencies
		// registerAction(new Module());
		registerAction(new Home());
		registerAction(new TutorialStepDisplay(mainConfig, data));
		registerAction(new TutorialUpload(mainConfig,data));
		
		layoutRender = new LayoutRenderer();
	}
	@Override
	public void service(HttpServletRequest 
			request, HttpServletResponse response)
					throws ServletException, IOException {

		String url = request.getPathInfo();
		IContext context = createContext(request, response);
		IAction action = router.find(url, context);

		if (null != action){

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
