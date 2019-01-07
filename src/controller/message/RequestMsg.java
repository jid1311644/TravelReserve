package controller.message;

import java.util.Map;

import controller.Controller;

public class RequestMsg {

	public static final int LOGIN = 0;
	public static final int REGISTER = 1;
	public static final int SEARCH_FLIGHT = 2;
	public static final int GET_CITIES_NAME = 3;
	public static final int SEARCH_HOTEL = 4;
	public static final int SEARCH_VEHICLE = 5;
	public static final int SEARCH_CONTACT = 6;
	public static final int SELECT_FLIGHT = 7;
	public static final int ADD_CONTACT = 8;
	public static final int SELECT_VACANT_ROOMS = 9;
	public static final int SELECT_ROOM_PRICE = 10;
	public static final int SELECT_BUS_FREE_SEAT = 11;
	public static final int SELECT_CITY_NAME_BY_ID = 12;
	public static final int SELECT_RESERVATION = 13;
	public static final int SELECT_FLIGHT_RESERVATION = 14;
	public static final int SELECT_HOTEL_RESERVATION = 15;
	public static final int SELECT_VEHICLE_RESERVATION = 16;
	public static final int SELECT_HOTEL = 17;
	public static final int SELECT_VEHICLE = 18;
	public static final int SELECT_BUS_DESTINATION = 19;
	public static final int SELECT_BUS_TICKET = 20;
	public static final int RESERVE_FLIGHT = 21;
	public static final int RESERVE_HOTEL = 22;
	public static final int RESERVE_VEHICLE = 23;
	public static final int SELECT_PASSENGER = 24;
	
	private int requestType;
	private Map<String, String> args;
	
	public RequestMsg(int requestType) {
		// TODO Auto-generated constructor stub
		this.requestType = requestType;
	}
	
	public void sendRequest() {
		Controller.setRequest(this);
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	public int getRequestType() {
		return requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

}
