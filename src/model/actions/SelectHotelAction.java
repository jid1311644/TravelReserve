package model.actions;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.HotelBean;

public class SelectHotelAction {

	public void handleSelectHotel(RequestMsg req, ResponseMsg resp) {
		
		String hotelNumber = req.getArgs().get("hotelNumber");
		HotelBean hotelBean = new HotelBean().select(hotelNumber);
		if(hotelBean != null) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
			resp.setData(hotelBean);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR");
			resp.setData(hotelBean);
		}
	}
	
}
