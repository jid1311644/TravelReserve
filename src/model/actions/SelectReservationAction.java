package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.reservationBeans.FlightReseverationBean;
import model.beans.reservationBeans.HotelReservationBean;
import model.beans.reservationBeans.ReservationBean;
import model.beans.reservationBeans.VehicleReservationBean;

public class SelectReservationAction {

	public void handleSelectReservation(RequestMsg req, ResponseMsg resp) {
		String username = req.getArgs().get("username");
		String type = req.getArgs().get("type");
		LinkedList<ReservationBean> rbs = new ReservationBean().selectReservation(username, type);
		if(!rbs.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(rbs);
		}
		else {
			resp.setResult("failure");
			switch (type) {
			case ReservationBean.FLIGHT:
				resp.setMsg("There is no flight reservation yet!");
				break;
			case ReservationBean.HOTEL:
				resp.setMsg("There is no hotel reservation yet!");
				break;
			case ReservationBean.VEHICLE:
				resp.setMsg("There is no pick-up service reservation yet!");
				break;
			default:
				break;
			}
			resp.setData(rbs);
		}
	}
	
	public void handleSelectFlightReservation(RequestMsg req, ResponseMsg resp) {
		String reserID = req.getArgs().get("reservationID");
		LinkedList<FlightReseverationBean> frbs = new FlightReseverationBean().select(reserID);
		if(!frbs.isEmpty()) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(frbs);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
			resp.setData(frbs);
		}
	}
	
	public void handleSelectHotelReservation(RequestMsg req, ResponseMsg resp) {
		String reserID = req.getArgs().get("reservationID");
		HotelReservationBean hrb = new HotelReservationBean().select(reserID);
		if(hrb != null) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(hrb);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
			resp.setData(hrb);
		}
	}
	
	public void handleSelectVehicleReservation(RequestMsg req, ResponseMsg resp) {
		String reserID = req.getArgs().get("reservationID");
		VehicleReservationBean vrb = new VehicleReservationBean().select(reserID);
		if(vrb != null) {
			resp.setResult("success");
			resp.setMsg("Search successful!");
			resp.setData(vrb);
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
			resp.setData(vrb);
		}
	}
	
}
