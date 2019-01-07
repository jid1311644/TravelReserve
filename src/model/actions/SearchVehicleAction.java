package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.VehicleBean;

public class SearchVehicleAction {

	public void handleSearchVehicle(RequestMsg req, ResponseMsg resp) {

		String location = req.getArgs().get("location");
		boolean isBus = Boolean.parseBoolean(req.getArgs().get("isBus"));
		LinkedList<VehicleBean> vehicleBeans = new VehicleBean().search(location, isBus);
		if(!vehicleBeans.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(vehicleBeans);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("There is no pick-up service in the city.!");
			resp.setData(vehicleBeans);
		}
		
	}
	
}
