package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.BusBean;

public class SelectBusAction {
	
	public void handleSelectBusFreeSeats(RequestMsg req, ResponseMsg resp) {
		String plateNumber = req.getArgs().get("plateNumber");
		int n = new BusBean().selectFreeSeats(plateNumber);
		if(n != -1) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
		}
		resp.setData(n);
	}
	
	public void handleSelectBusDestination(RequestMsg req, ResponseMsg resp) {
		String plateNumber = req.getArgs().get("plateNumber");
		String d = new BusBean().selectDestination(plateNumber);
		if(d != null) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
		}
		resp.setData(d);
	}
	
}
