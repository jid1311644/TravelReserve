package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;
import model.beans.UserBean;

public class SelectPassengerAction {
	
	public void handleSelectPassenger(RequestMsg req, ResponseMsg resp) {
		ContactBean cb = new ContactBean().selectPassenger(req.getArgs().get("idNumber"));
		if(cb == null) {
			UserBean ub = new UserBean().selectPassenger(req.getArgs().get("idNumber"));
			if(ub == null) {
				resp.setResult("failure");
				resp.setMsg("ERROR!");
				resp.setData(null);
			}
			else {
				cb = new ContactBean();
				cb.setIdNumber(ub.getIdNumber());
				cb.setName(ub.getName());
				cb.setTeleNumber(ub.getTeleNumber());
				resp.setResult("success");
				resp.setMsg("Select successful!");
				resp.setData(cb);
			}
		}
		else {
			resp.setResult("success");
			resp.setMsg("Select successful!");
			resp.setData(cb);
		}
	}

}
