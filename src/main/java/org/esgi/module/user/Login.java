package org.esgi.module.user;

import org.esgi.orm.model.User;
import org.esgi.web.NotifyError;
import org.esgi.web.NotifyType;
import org.esgi.web.action.AbstractAction;
import org.esgi.web.action.IContext;

public class Login extends AbstractAction{
	@Override
	public String getRoute() {
		return "/login";
	}

	@Override
	public void execute(IContext context) throws Exception {
		String login = context.getRequest().getParameter("login");
		String password = context.getRequest().getParameter("password");
		
		if(context.getConnectedUser() != null){
			context.getResponse().sendRedirect(context.getConfig("context") + "/manager");
		}else{
			if(login != null && password != null){
				if(!login.isEmpty() && !password.isEmpty()){
					User loggedUser = User.checkPassword(login, password);
					if(loggedUser != null){
						context.setConnectedUser(loggedUser);
						context.getResponse().sendRedirect(context.getConfig("context") + "/manager");
					}else{
						context.addError("wronglogin", new NotifyError("bad login or password.", NotifyType.Warning));
					}
				}else{
					context.addError("emptylogin", new NotifyError("login or password are empty.", NotifyType.Warning));
				}
			}
		}
	}
	
	@Override
	public String getLayout() {
		return "leanforgebo";
	}
}
