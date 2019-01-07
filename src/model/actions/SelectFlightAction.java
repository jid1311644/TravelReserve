package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.FlightBean;

public class SelectFlightAction {
	
	public void handleSelectFlight(RequestMsg req, ResponseMsg resp) {
		
		String flightNumber = req.getArgs().get("flightNumber");
		FlightBean flightBean = new FlightBean().select(flightNumber);
		if(flightBean != null) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
			resp.setData(flightBean);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR");
			resp.setData(flightBean);
		}
	}

}
