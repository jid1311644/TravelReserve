package model.beans;

import java.util.LinkedList;

import model.daos.CityDAO;
import model.daos.FlightDAO;
import model.daos.HotelDAO;
import model.daos.HotelRoomDAO;

public class HotelBean {

	private String hotelNumber;
	private String hotelName;
	private String address;
	private String locationCity;
	
	private int floorPrice;
	
	@SuppressWarnings("unchecked")
	public LinkedList<HotelBean> search(String city) {
		CityDAO cityDAO = new CityDAO();
		String sql = "select city_id from city where city_name = '" + city + "'";
		LinkedList<CityBean> cityBeans = (LinkedList<CityBean>) cityDAO.query(sql);
		if(cityBeans == null || cityBeans.size() != 1) {
			return null;
		}
		else {
			String cityID = cityBeans.poll().getCityID();
			sql = "select * from hotel where location_city = '" + cityID + "'";
			LinkedList<HotelBean> hotelBeans = (LinkedList<HotelBean>) new HotelDAO().query(sql);
			
			for(HotelBean hb: hotelBeans) {
				sql = "select min(price) price from hotel_room where hotel_number='" 
						+ hb.getHotelNumber() + "'";
				LinkedList<HotelRoomBean> hotelRoomBeans = (LinkedList<HotelRoomBean>) 
						new HotelRoomDAO().query(sql);
				if(hotelRoomBeans.size() == 1) {
					float p = hotelRoomBeans.poll().getPrice();
					hb.setFloorPrice((int) p);
				}
				else {
					hb.setFloorPrice(-1);
				}
			}
			return hotelBeans;
		}
	}
	
	@SuppressWarnings("unchecked")
	public HotelBean select(String hotelNumber) {
		// TODO Auto-generated method stub
		String sql = "select * from hotel where hotel_number='" + hotelNumber + "'";
		LinkedList<HotelBean> hbs = (LinkedList<HotelBean>) new HotelDAO().query(sql);
		if(hbs.size() == 1) {
			return hbs.poll();
		}
		return null;
	}
	
	public String getHotelNumber() {
		return hotelNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public String getAddress() {
		return address;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public int getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(int floorPrice) {
		this.floorPrice = floorPrice;
	}

	
}
