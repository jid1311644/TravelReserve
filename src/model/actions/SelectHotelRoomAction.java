package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.HotelRoomBean;

public class SelectHotelRoomAction {
	
	public void handleSelectVacantRooms(RequestMsg req, ResponseMsg resp) {
		String hotelNumber = req.getArgs().get("hotelNumber");
		int[] vacants = new HotelRoomBean().selectVacantRooms(hotelNumber);
		if(vacants != null && vacants.length == 3) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
			resp.setData(vacants);
		}
		resp.setData(vacants);
	}

	public void handleSelectRoomsPrice(RequestMsg req, ResponseMsg resp) {
		String hotelNumber = req.getArgs().get("hotelNumber");
		float[] prices = new HotelRoomBean().selectRoomsPrice(hotelNumber);
		if(prices != null && prices.length == 3) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
		}
		resp.setData(prices);
	}
	
}
