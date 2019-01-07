package controller;

import java.util.LinkedList;

import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.actions.AddContactAction;
import model.actions.LoginAction;
import model.actions.RegisterAction;
import model.actions.ReserveAction;
import model.actions.SearchContactAction;
import model.actions.SearchFlightAction;
import model.actions.SearchHotelAction;
import model.actions.SearchVehicleAction;
import model.actions.SelectBusAction;
import model.actions.SelectCityNameAction;
import model.actions.SelectFlightAction;
import model.actions.SelectHotelAction;
import model.actions.SelectHotelRoomAction;
import model.actions.SelectPassengerAction;
import model.actions.SelectReservationAction;
import model.actions.SelectVehicleAction;

public class Controller {
	
	public static LinkedList<String> cities;
	
	private static RequestMsg request;

	public static RequestMsg getRequest() {
		return request;
	}

	public static void setRequest(RequestMsg req) {
		request = req;
	}
	
	public static ResponseMsg handle() {
		ResponseMsg response = new ResponseMsg("", "");
		switch (request.getRequestType()) {
		case RequestMsg.LOGIN:
			new LoginAction().handleLogin(request, response);
			break;
		case RequestMsg.REGISTER:
			new RegisterAction().handleRegister(request, response);
			break;
		case RequestMsg.SEARCH_FLIGHT:
			new SearchFlightAction().handleSearchFlight(request, response);
			break;
		case RequestMsg.GET_CITIES_NAME:
			new SelectCityNameAction().handleSelectCity(request, response);
			break;
		case RequestMsg.SEARCH_HOTEL:
			new SearchHotelAction().handleSearchHotel(request, response);
			break;
		case RequestMsg.SEARCH_VEHICLE:
			new SearchVehicleAction().handleSearchVehicle(request, response);
			break;
		case RequestMsg.SEARCH_CONTACT:
			new SearchContactAction().handleSearchContact(request, response);
			break;
		case RequestMsg.SELECT_FLIGHT:
			new SelectFlightAction().handleSelectFlight(request, response);
			break;
		case RequestMsg.ADD_CONTACT:
			new AddContactAction().handleAddContact(request, response);
			break;
		case RequestMsg.SELECT_VACANT_ROOMS:
			new SelectHotelRoomAction().handleSelectVacantRooms(request, response);
			break;
		case RequestMsg.SELECT_ROOM_PRICE:
			new SelectHotelRoomAction().handleSelectRoomsPrice(request, response);
			break;
		case RequestMsg.SELECT_BUS_FREE_SEAT:
			new SelectBusAction().handleSelectBusFreeSeats(request, response);
			break;
		case RequestMsg.SELECT_CITY_NAME_BY_ID:
			new SelectCityNameAction().handleSelectCityName(request, response);
			break;
		case RequestMsg.SELECT_RESERVATION:
			new SelectReservationAction().handleSelectReservation(request, response);
			break;
		case RequestMsg.SELECT_FLIGHT_RESERVATION:
			new SelectReservationAction().handleSelectFlightReservation(request, response);
			break;
		case RequestMsg.SELECT_HOTEL_RESERVATION:
			new SelectReservationAction().handleSelectHotelReservation(request, response);
			break;
		case RequestMsg.SELECT_VEHICLE_RESERVATION:
			new SelectReservationAction().handleSelectVehicleReservation(request, response);
			break;
		case RequestMsg.SELECT_BUS_DESTINATION:
			new SelectBusAction().handleSelectBusDestination(request, response);
			break;
		case RequestMsg.SELECT_HOTEL:
			new SelectHotelAction().handleSelectHotel(request, response);
			break;
		case RequestMsg.SELECT_VEHICLE:
			new SelectVehicleAction().handleSelectVehicle(request, response);
			break;
		case RequestMsg.SELECT_PASSENGER:
			new SelectPassengerAction().handleSelectPassenger(request, response);
			break;
		case RequestMsg.RESERVE_FLIGHT:
			new ReserveAction().handleReserveFlightAction(request, response);
			break;
		case RequestMsg.RESERVE_HOTEL:
			new ReserveAction().handleReserveHotelAction(request, response);
			break;
		case RequestMsg.RESERVE_VEHICLE:
			new ReserveAction().handleReserveVehicleAction(request, response);
			break;
		default:
			break;
		}
		return response.sendResponse();
	}

}
