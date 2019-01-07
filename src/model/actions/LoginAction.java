package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.UserBean;

public class LoginAction {
	
	public void handleLogin(RequestMsg req, ResponseMsg resp) {

		String username = req.getArgs().get("username");
		String password = req.getArgs().get("password");
		if(new UserBean().login(username, password)) {
			resp.setResult("success");
			resp.setMsg("Login successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Username or password ERROR!");
		}
		
	}

}
