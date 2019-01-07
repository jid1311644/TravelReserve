package model.beans;

import java.util.LinkedList;

import model.daos.HotelRoomDAO;

public class HotelRoomBean {

	public static final String SINGLE = "大床房";
	public static final String DOUBLE = "标准间";
	public static final String DELUXE = "高级套房";
	
	private String hotelNumber;
	private String roomType;
	private Float price;
	private Integer totalRooms;
	private Integer vacantRooms;
	
	@SuppressWarnings("unchecked")
	public float[] selectRoomsPrice(String hotelNumber) {
		float[] p = new float[3];
		String sql = "select price from hotel_room where "
				+ "hotel_number='" + hotelNumber + "' and "
				+ "room_type='" + HotelRoomBean.SINGLE + "'";
		LinkedList<HotelRoomBean> hrbs = (LinkedList<HotelRoomBean>) 
				new HotelRoomDAO().query(sql);
		if(hrbs.size() == 1) {
			p[0] = hrbs.poll().getPrice();
			sql = "select price from hotel_room where "
					+ "hotel_number='" + hotelNumber + "' and "
					+ "room_type='" + HotelRoomBean.DOUBLE + "'";
			hrbs = (LinkedList<HotelRoomBean>) new HotelRoomDAO().query(sql);
			if(hrbs.size() == 1) {
				p[1] = hrbs.poll().getPrice();
				sql = "select price from hotel_room where "
						+ "hotel_number='" + hotelNumber + "' and "
						+ "room_type='" + HotelRoomBean.DELUXE + "'";
				hrbs = (LinkedList<HotelRoomBean>) new HotelRoomDAO().query(sql);
				if(hrbs.size() == 1) {
					p[2] = hrbs.poll().getPrice();
					return p;
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int[] selectVacantRooms(String hotelNumber) {
		int[] v = new int[3];
		String sql = "select vacant_rooms from hotel_room where "
				+ "hotel_number='" + hotelNumber + "' and "
				+ "room_type='" + HotelRoomBean.SINGLE + "'";
		LinkedList<HotelRoomBean> hrbs = (LinkedList<HotelRoomBean>) 
				new HotelRoomDAO().query(sql);
		if(hrbs.size() == 1) {
			v[0] = hrbs.poll().getVacantRooms();
			sql = "select vacant_rooms from hotel_room where "
					+ "hotel_number='" + hotelNumber + "' and "
					+ "room_type='" + HotelRoomBean.DOUBLE + "'";
			hrbs = (LinkedList<HotelRoomBean>) new HotelRoomDAO().query(sql);
			if(hrbs.size() == 1) {
				v[1] = hrbs.poll().getVacantRooms();
				sql = "select vacant_rooms from hotel_room where "
						+ "hotel_number='" + hotelNumber + "' and "
						+ "room_type='" + HotelRoomBean.DELUXE + "'";
				hrbs = (LinkedList<HotelRoomBean>) new HotelRoomDAO().query(sql);
				if(hrbs.size() == 1) {
					v[2] = hrbs.poll().getVacantRooms();
					return v;
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	public String getHotelNumber() {
		return hotelNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public Float getPrice() {
		return price;
	}
	public Integer getTotalRooms() {
		return totalRooms;
	}
	public Integer getVacantRooms() {
		return vacantRooms;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}
	public void setVacantRooms(Integer vacantRooms) {
		this.vacantRooms = vacantRooms;
	}
	
}
