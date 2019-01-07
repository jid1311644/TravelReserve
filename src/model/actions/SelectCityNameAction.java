package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.CityBean;

public class SelectCityNameAction {

	public void handleSelectCity(RequestMsg req, ResponseMsg resp) {

		LinkedList<String> cityBeans = new CityBean().getAllCities();
		if(!cityBeans.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
			resp.setData(cityBeans);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Select ERROR!");
			resp.setData(cityBeans);
		}
		
	}
	
	public void handleSelectCityName(RequestMsg req, ResponseMsg resp) {
		
		String name = new CityBean().selectCityName(req.getArgs().get("cityID"));
		if(name != null) {
			resp.setResult("success");
			resp.setMsg("Select successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Select ERROR!");
		}
		resp.setData(name);
	}
	
}
