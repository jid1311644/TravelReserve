package model.beans.reservationBeans;

import java.util.LinkedList;

import model.daos.reservationDaos.ReservationDAO;

public class ReservationBean {

	public static final String FLIGHT = "F";
	public static final String HOTEL = "H";
	public static final String VEHICLE = "V";
	
	private String reservationID;
	private String username;
	private String time;
	private String type;
	

	@SuppressWarnings("unchecked")
	public LinkedList<ReservationBean> selectReservation(String uname, String type) {
		// TODO Auto-generated method stub
		String sql = "select * from reservation where username='" + uname + "' "
				+ "and type='" + type + "'";
		return (LinkedList<ReservationBean>) new ReservationDAO().query(sql);
	}

	
	public String getReservationID() {
		return reservationID;
	}
	public String getUsername() {
		return username;
	}
	public String getTime() {
		return time;
	}
	public String getType() {
		return type;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setType(String type) {
		this.type = type;
	}

}
