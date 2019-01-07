package model.beans;

import java.util.LinkedList;

import model.daos.BusDAO;

public class BusBean {
	
	private String plateNumber;
	private String destination;
	private Integer seats;
	private Integer freeSeats;
	
	@SuppressWarnings("unchecked")
	public int selectFreeSeats(String plateNumber) {
		// TODO Auto-generated method stub
		String sql = "select free_seats from bus where "
				+ "plate_number='" + plateNumber + "'";
		LinkedList<BusBean> busBeans = (LinkedList<BusBean>) new BusDAO().query(sql);
		if(busBeans.size() == 1) {
			return busBeans.poll().getFreeSeats();
		}
		else {
			return -1;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectDestination(String plateNumber) {
		// TODO Auto-generated method stub
		String sql = "select destination from bus where "
				+ "plate_number='" + plateNumber + "'";
		LinkedList<BusBean> busBeans = (LinkedList<BusBean>) new BusDAO().query(sql);
		if(busBeans.size() == 1) {
			return busBeans.poll().getDestination();
		}
		else {
			return null;
		}
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	public String getDestination() {
		return destination;
	}
	public Integer getSeats() {
		return seats;
	}
	public Integer getFreeSeats() {
		return freeSeats;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public void setFreeSeats(Integer freeSeats) {
		this.freeSeats = freeSeats;
	}

}
