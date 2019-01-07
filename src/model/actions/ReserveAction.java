package model.actions;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.reservationBeans.FlightReseverationBean;
import model.beans.reservationBeans.HotelReservationBean;
import model.beans.reservationBeans.VehicleReservationBean;

public class ReserveAction {
	
	public void handleReserveFlightAction(RequestMsg req, ResponseMsg resp) {
		int passengers = req.getArgs().size();
		if(passengers >= 3) {
			String username = req.getArgs().get("username");
			String flightNumber = req.getArgs().get("flightNumber");
			LinkedList<FlightReseverationBean> frbs = new LinkedList<>();
			for(int i = 0; i < passengers - 2; i++) {
				FlightReseverationBean frb = new FlightReseverationBean();
				frb.setUsername(username);
				frb.setFlightNumber(flightNumber);
				frb.setPassengerID(req.getArgs().get(i + "idNumber"));
				frbs.add(frb);
			}
			boolean f = new FlightReseverationBean().reserve(frbs);
			if(f) {
				resp.setResult("success");
				resp.setMsg("Reserve successful!");
			}
			else {
				resp.setResult("failure");
				resp.setMsg("Insufficient ticket!");
			}
		}
		else {
			resp.setResult("failure");
			resp.setMsg("ERROR!");
		}
	}
	
	public void handleReserveHotelAction(RequestMsg req, ResponseMsg resp) {
		HotelReservationBean hrb = new HotelReservationBean();
		hrb.setHotelNumber(req.getArgs().get("hotelNumber"));
		hrb.setRoomType(req.getArgs().get("roomType"));
		hrb.setRoomNumber(Integer.parseInt(req.getArgs().get("roomNum")));
		if(new HotelReservationBean().reserve(req.getArgs().get("username"), hrb)) {
			resp.setResult("success");
			resp.setMsg("Reserve successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Insufficient room!");
		}
	}
	
	public void handleReserveVehicleAction(RequestMsg req, ResponseMsg resp) {
		VehicleReservationBean vrb = new VehicleReservationBean();
		vrb.setUsername(req.getArgs().get("username"));
		vrb.setPlateNumber(req.getArgs().get("plateNumber"));
		vrb.setTicket(Integer.parseInt(req.getArgs().get("ticket")));
		if(new VehicleReservationBean().reserve(
				Boolean.parseBoolean(req.getArgs().get("isBus")), vrb)) {
			resp.setResult("success");
			resp.setMsg("Reserve successful!");
		}
		else {
			resp.setResult("failure");
			resp.setMsg("Insufficient seat!");
		}
	}

}
