package model.beans;

import java.util.LinkedList;

import model.daos.BusDAO;
import model.daos.CityDAO;
import model.daos.VehicleDAO;

public class VehicleBean {

	public static final String CAR = "小轿车";
	public static final String BUSSINESS = "商务车";
	public static final String BUS = "机场大巴";
	
	private String plateNumber;
	private String carType;
	private Float price;
	private String locationCity;
	
	private String destination;
	
	@SuppressWarnings("unchecked")
	public LinkedList<VehicleBean> search(String city, boolean isBus) {
		CityDAO cityDAO = new CityDAO();
		String sql = "select city_id from city where city_name = '" + city + "'";
		LinkedList<CityBean> cityBeans = (LinkedList<CityBean>) cityDAO.query(sql);
		if(cityBeans == null || cityBeans.size() != 1) {
			return null;
		}
		else {
			String cityID = cityBeans.poll().getCityID();
			LinkedList<VehicleBean> vehicleBeans;
			if(isBus) {
				sql = "select * from vehicle where location_city='" + cityID
						+ "' and car_type='机场大巴'";
				vehicleBeans = (LinkedList<VehicleBean>) new VehicleDAO().query(sql);
			
				for(VehicleBean vb: vehicleBeans) {
					sql = "select destination from bus where plate_number='"
							+ vb.getPlateNumber() + "'";
					LinkedList<BusBean> busBeans = (LinkedList<BusBean>) new BusDAO().query(sql);
					if(busBeans.size() == 1) {
						vb.setDestination(busBeans.poll().getDestination());
					}
					else {
						vb.setDestination("ERROR");
					}
				}
			}
			else {
				sql = "select * from vehicle where location_city='" + cityID
						+ "' and car_type!='机场大巴'";
				vehicleBeans = (LinkedList<VehicleBean>) new VehicleDAO().query(sql);
				for(VehicleBean vb: vehicleBeans) {
					vb.setDestination("");
				}
			}
			return vehicleBeans;
		}
	}
	
	@SuppressWarnings("unchecked")
	public VehicleBean select(String plateNumber) {
		// TODO Auto-generated method stub
		String sql = "select * from vehicle where plate_number='" + plateNumber + "'";
		LinkedList<VehicleBean> vbs = (LinkedList<VehicleBean>) new VehicleDAO().query(sql);
		if(vbs.size() == 1) {
			return vbs.poll();
		}
		return null;
	}

	
	public String getPlateNumber() {
		return plateNumber;
	}
	public String getCarType() {
		return carType;
	}
	public Float getPrice() {
		return price;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
