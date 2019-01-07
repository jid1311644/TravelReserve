package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.UserBean;

public class RegisterAction {

	public void handleRegister(RequestMsg req, ResponseMsg resp) {

		String username = req.getArgs().get("username");
		String password = req.getArgs().get("password");
		String tele = req.getArgs().get("teleNumber");
		String id = req.getArgs().get("idNumber");
		String name = req.getArgs().get("name");
		Boolean sex = Boolean.parseBoolean(req.getArgs().get("sex"));
		if(new UserBean().register(username, password, tele, id, name, sex)) {
			resp.setResult("success");
			resp.setMsg("Register successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Username has already existed!!");
		}
		
	}
	
}
