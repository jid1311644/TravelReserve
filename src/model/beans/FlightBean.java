package model.beans;

import java.util.LinkedList;

import model.daos.CityDAO;
import model.daos.FlightDAO;

public class FlightBean {
	
	private String flightNumber;
	private Float price;
	private Integer seats;
	private Integer freeSeats;
	private String departureCity;
	private String destinationCity;
	private String departureTime;
	private String destinationTime;
	
	@SuppressWarnings("unchecked")
	public LinkedList<FlightBean> search(String departureCity, String destinationCity){
		
		CityDAO cityDAO = new CityDAO();
		String sql = "select city_id from city where city_name = '" + departureCity + "'";
		LinkedList<CityBean> cityBeans = (LinkedList<CityBean>) cityDAO.query(sql);
		if(cityBeans == null || cityBeans.size() != 1) {
			return null;
		}
		else {
			String departureCityID = cityBeans.poll().getCityID();
			sql = "select city_id from city where city_name = '" + destinationCity + "'";
			cityBeans = (LinkedList<CityBean>) cityDAO.query(sql);
			if(cityBeans == null || cityBeans.size() != 1) {
				return null;
			}
			else {
				String destinationCityID = cityBeans.poll().getCityID();
				sql = "select flight_number,price,departure_time,destination_time from flight "
						+ "where departure_city='" + departureCityID + "' and "
						+ "destination_city='" + destinationCityID + "'";
				LinkedList<FlightBean> flightBeans = (LinkedList<FlightBean>) new FlightDAO().query(sql);
				return flightBeans;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public FlightBean select(String flightNumber) {
		
		String sql = "select * from flight where flight_number='" + flightNumber + "'";
		LinkedList<FlightBean> fbs = (LinkedList<FlightBean>) new FlightDAO().query(sql);
		if(fbs.size() == 1) {
			return fbs.poll();
		}
		else {
			return null;
		}
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public Float getPrice() {
		return price;
	}
	public Integer getSeats() {
		return seats;
	}
	public Integer getFreeSeats() {
		return freeSeats;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public String getDestinationTime() {
		return destinationTime;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public void setFreeSeats(Integer freeSeats) {
		this.freeSeats = freeSeats;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}
	
	

}
