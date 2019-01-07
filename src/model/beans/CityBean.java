package model.beans;

import java.util.LinkedList;

import model.daos.CityDAO;

public class CityBean {
	
	private String cityID;
	private String cityName;
	private String provinceName;
	
	@SuppressWarnings("unchecked")
	public LinkedList<String> getAllCities() {
		String sql = "select city_name from city";
		LinkedList<CityBean> cityBeans = (LinkedList<CityBean>) new CityDAO().query(sql);
		LinkedList<String> cityNames = new LinkedList<>();
		while(!cityBeans.isEmpty()) {
			cityNames.add(cityBeans.pollFirst().getCityName());
		}
		return cityNames;
	}
	
	@SuppressWarnings("unchecked")
	public String selectCityName(String cityID) {
		String sql = "select city_name from city where city_id='" + cityID + "'";
		LinkedList<CityBean> cityBeans = (LinkedList<CityBean>) new CityDAO().query(sql);
		if(cityBeans.size() == 1) {
			return cityBeans.poll().getCityName();
		}
		else {
			return null;
		}
	}
	
	public String getCityID() {
		return cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
