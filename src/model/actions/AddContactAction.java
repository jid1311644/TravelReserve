package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;

public class AddContactAction {

	public void handleAddContact(RequestMsg req, ResponseMsg resp) {

		String username = req.getArgs().get("username");
		String tele = req.getArgs().get("teleNumber");
		String id = req.getArgs().get("idNumber");
		String name = req.getArgs().get("name");
		if(new ContactBean().add(username, tele, id, name)) {
			resp.setResult("success");
			resp.setMsg("Add contact successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Contact has already existsed!");
		}
		
	}
	
}
