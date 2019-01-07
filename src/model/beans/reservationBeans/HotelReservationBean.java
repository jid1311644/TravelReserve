package model.beans.reservationBeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import model.beans.HotelBean;
import model.beans.HotelRoomBean;
import model.daos.HotelDAO;
import model.daos.HotelRoomDAO;
import model.daos.reservationDaos.FlightReseverationDAO;
import model.daos.reservationDaos.HotelReservationDAO;
import model.daos.reservationDaos.ReservationDAO;

public class HotelReservationBean {
	
	private String reservationID;
	private String username;
	private String hotelNumber;
	private String roomType;
	private Integer roomNumber;
	
	@SuppressWarnings("unchecked")
	public HotelReservationBean select(String reserID) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel_reservation where reservation_id='" + reserID + "'";
		LinkedList<HotelReservationBean> hrbs = (LinkedList<HotelReservationBean>) 
				new HotelReservationDAO().query(sql);
		if(hrbs.size() == 1) {
			return hrbs.poll();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean reserve(String uname, HotelReservationBean hrb) {
		// TODO Auto-generated method stub
		String sql = "select vacant_rooms from hotel_room where "
				+ "hotel_number='" + hrb.getHotelNumber() + "' and "
				+ "room_type='" + hrb.getRoomType() + "'";
		LinkedList<HotelRoomBean> hbs = (LinkedList<HotelRoomBean>) new HotelRoomDAO().query(sql);
		if(hbs.size() != 1) {
			return false;
		}
		int vacants = hbs.poll().getVacantRooms();
		if(vacants < hrb.getRoomNumber()) {
			return false;
		}
		else {
			ReservationDAO rDAO = new ReservationDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			String reserID = "H" + sdf.format(new Date());
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String time = sdf.format(new Date());
			sql = "insert into reservation (reservation_id,username,time,type)values("
					+ "'" + reserID + "',"
					+ "'" + uname + "',"
					+ "'" + time + "',"
					+ "'H')";
			if(!rDAO.insert(sql)) {
				return false;
			}
			
			HotelReservationDAO hrDAO = new HotelReservationDAO();
			sql = "insert into hotel_reservation (reservation_id,username,hotel_number,room_type,room_number)"
					+ "values('" + reserID + "',"
					+ "'" + uname + "',"
					+ "'" + hrb.getHotelNumber() + "',"
					+ "'" + hrb.getRoomType() + "',"
					+ "'" + hrb.getRoomNumber() + "')";
			if(!hrDAO.insert(sql)) {
				return false;
			}
			
			sql = "update hotel_room set vacant_rooms='" + (vacants - hrb.getRoomNumber())
					+ "' where hotel_number='" + hrb.getHotelNumber()
					+ "' and room_type='" + hrb.getRoomType() + "'";
			return new HotelRoomDAO().update(sql);
		}
	}
	
	public String getReservationID() {
		return reservationID;
	}
	public String getUsername() {
		return username;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

}
