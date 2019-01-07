package model.beans.reservationBeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import model.beans.FlightBean;
import model.daos.FlightDAO;
import model.daos.reservationDaos.FlightReseverationDAO;
import model.daos.reservationDaos.ReservationDAO;

public class FlightReseverationBean {
	
	private String reservationID;
	private String username;
	private String flightNumber;
	private String passengerID;
	
	@SuppressWarnings("unchecked")
	public LinkedList<FlightReseverationBean> select(String reserID) {
		// TODO Auto-generated method stub
		String sql = "select * from flight_reservation where reservation_id='" + reserID + "'";
		return (LinkedList<FlightReseverationBean>) new FlightReseverationDAO().query(sql);
	}
	
	@SuppressWarnings("unchecked")
	public boolean reserve(LinkedList<FlightReseverationBean> frbs) {
		// TODO Auto-generated method stub
		String sql = "select free_seats from flight where flight_number='" + frbs.peek().getFlightNumber() + "'";
		LinkedList<FlightBean> fbs = (LinkedList<FlightBean>) new FlightDAO().query(sql);
		if(fbs.size() != 1) {
			return false;
		}
		int freeSeats = fbs.poll().getFreeSeats();
		int passengers = frbs.size();
		if(freeSeats < passengers) {
			return false;
		}
		else {
			ReservationDAO rDAO = new ReservationDAO();
			FlightReseverationDAO frDAO = new FlightReseverationDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			String reserID = "F" + sdf.format(new Date());
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String time = sdf.format(new Date());
			String fn = frbs.peekFirst().getFlightNumber();
			String un = frbs.peekFirst().getUsername();
			
			sql = "insert into reservation (reservation_id,username,time,type)values("
					+ "'" + reserID + "',"
					+ "'" + un + "',"
					+ "'" + time + "',"
					+ "'F')";
			if(!rDAO.insert(sql)) {
				return false;
			}
			
			while(!frbs.isEmpty()) {
				sql = "insert into flight_reservation (reservation_id,username,flight_number,passenger_id)"
						+ "values('"+ reserID + "',"
						+ "'" + un + "',"
						+ "'" + fn + "',"
						+ "'" + frbs.pollFirst().getPassengerID() + "')";
				if(!frDAO.insert(sql)) {
					return false;
				}
			}
			sql = "update flight set free_seats='" + (freeSeats - passengers) + "'"
					+ " where flight_number='" + fn + "'";
			return new FlightReseverationDAO().update(sql);
		}
	}
	
	public String getReservationID() {
		return reservationID;
	}
	public String getUsername() {
		return username;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getPassengerID() {
		return passengerID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}


}
