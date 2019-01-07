package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.VehicleBean;

public class SelectVehicleAction {

	public void handleSelectVehicle(RequestMsg req, ResponseMsg resp) {
		
		String plateNumber = req.getArgs().get("plateNumber");
		VehicleBean vehicleBean = new VehicleBean().select(plateNumber);
		if(vehicleBean != null) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
			resp.setData(vehicleBean);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR");
			resp.setData(vehicleBean);
		}
	}
	
}
