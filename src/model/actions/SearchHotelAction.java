package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.HotelBean;

public class SearchHotelAction {

	public void handleSearchHotel(RequestMsg req, ResponseMsg resp) {

		String location = req.getArgs().get("location");
		LinkedList<HotelBean> hotelBeans = new HotelBean().search(location);
		if(!hotelBeans.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(hotelBeans);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("There is no hotel in this city!");
			resp.setData(hotelBeans);
		}
		
	}
	
}
