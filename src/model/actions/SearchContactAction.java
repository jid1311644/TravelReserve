package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;

public class SearchContactAction {
	
	public void handleSearchContact(RequestMsg req, ResponseMsg resp) {
		String username = req.getArgs().get("username");
		LinkedList<ContactBean> contactBeans = new ContactBean().search(username);
		if(!contactBeans.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(contactBeans);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
			resp.setData(contactBeans);
		}
	}

}
