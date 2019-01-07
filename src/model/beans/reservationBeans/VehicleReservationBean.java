package model.beans.reservationBeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import model.beans.BusBean;
import model.daos.BusDAO;
import model.daos.reservationDaos.FlightReseverationDAO;
import model.daos.reservationDaos.ReservationDAO;
import model.daos.reservationDaos.VehicleReservationDAO;

public class VehicleReservationBean {
	
	private String reservationID;
	private String username;
	private String plateNumber;
	private Integer ticket;
	
	@SuppressWarnings("unchecked")
	public VehicleReservationBean select(String reserID) {
		// TODO Auto-generated method stub
		String sql = "select * from vehicle_reservation where reservation_id='" + reserID + "'";
		LinkedList<VehicleReservationBean> vbs = (LinkedList<VehicleReservationBean>) 
				new VehicleReservationDAO().query(sql);
		if(vbs.size() == 1) {
			return vbs.poll();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean reserve(boolean isBus, VehicleReservationBean vrb) {
		// TODO Auto-generated method stub
		if(isBus) {
			String sql = "select free_seats from bus where plate_number='"
					+ vrb.getPlateNumber() + "'";
			LinkedList<BusBean> bbs = (LinkedList<BusBean>) new BusDAO().query(sql);
			if(bbs.size() != 1) {
				return false;
			}
			int freeSeats = bbs.poll().getFreeSeats();
			if(freeSeats < vrb.getTicket()) {
				return false;
			}
			else {
				ReservationDAO rDAO = new ReservationDAO();
				SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
				String reserID = "V" + sdf.format(new Date());
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String time = sdf.format(new Date());
				sql = "insert into reservation (reservation_id,username,time,type)values("
						+ "'" + reserID + "',"
						+ "'" + vrb.getUsername() + "',"
						+ "'" + time + "',"
						+ "'V')";
				if(!rDAO.insert(sql)) {
					return false;
				}
				
				VehicleReservationDAO vrDAO = new VehicleReservationDAO();
				sql = "insert into vehicle_reservation (reservation_id,username,plate_number,ticket)"
						+ "values('" + reserID + "',"
						+ "'" + vrb.getUsername() + "',"
						+ "'" + vrb.getPlateNumber() + "',"
						+ "'" + vrb.getTicket() + "')";
				if(!vrDAO.insert(sql)) {
					return false;
				}
				
				sql = "update bus set free_seats='" + (freeSeats - vrb.getTicket()) + "'"
						+ " where plate_number='" + vrb.getPlateNumber() + "'";
				return vrDAO.update(sql);
			}
		}
		else {
			ReservationDAO rDAO = new ReservationDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
			String reserID = "V" + sdf.format(new Date());
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String time = sdf.format(new Date());
			String sql = "insert into reservation (reservation_id,username,time,type)values("
					+ "'" + reserID + "',"
					+ "'" + vrb.getUsername() + "',"
					+ "'" + time + "',"
					+ "'V')";
			if(!rDAO.insert(sql)) {
				return false;
			}

			VehicleReservationDAO vrDAO = new VehicleReservationDAO();
			sql = "insert into vehicle_reservation (reservation_id,username,plate_number)"
					+ "values('" + reserID + "',"
					+ "'" + vrb.getUsername() + "',"
					+ "'" + vrb.getPlateNumber() + "')";
			return vrDAO.insert(sql);
		}
	}
	
	public String getReservationID() {
		return reservationID;
	}
	public String getUsername() {
		return username;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public Integer getTicket() {
		return ticket;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

}
