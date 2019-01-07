package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.FlightBean;

public class SearchFlightAction {

	public void handleSearchFlight(RequestMsg req, ResponseMsg resp) {

		String departureCity = req.getArgs().get("departureCity");
		String destinationCity = req.getArgs().get("destinationCity");
		LinkedList<FlightBean> flightBeans = new FlightBean().search(departureCity, destinationCity);
		if(!flightBeans.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(flightBeans);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("There is no flight on this route yet!");
			resp.setData(flightBeans);
		}
		
	}
	
}
