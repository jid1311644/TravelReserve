package model.daos.reservationDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.reservationBeans.HotelReservationBean;

public class HotelReservationDAO extends BaseDAO {

	public HotelReservationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("HotelReservationDAO.query sql:" + sql);
		LinkedList<HotelReservationBean> hotelReservationBeans = new LinkedList<>();
		try {
			//�������ݿ�����
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				HotelReservationBean hotelReservationBean = new HotelReservationBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "reservation_id":
						hotelReservationBean.setReservationID(rs.getString(i + 1));
						break;
					case "username":
						hotelReservationBean.setUsername(rs.getString(i + 1));
						break;
					case "hotel_number":
						hotelReservationBean.setHotelNumber(rs.getString(i + 1));
						break;
					case "room_type":
						hotelReservationBean.setRoomType(rs.getString(i + 1));
						break;
					case "room_number":
						hotelReservationBean.setRoomNumber(rs.getInt(i + 1));
						break;
					default:
						break;
					}
				}
				hotelReservationBeans.add(hotelReservationBean);
			}
			rs.close();
			st.close();
			//�ر����ݿ�����
			closeDBConnection(c);
			return hotelReservationBeans;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error executing sql.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(String sql) {
		// TODO Auto-generated method stub
		System.out.println("HotelReservationDAO.insert sql:" + sql);
		boolean f = true;
		try {
			//�������ݿ�����
			Connection c = openDBConnection();
			//��������
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			//�ر����ݿ�����
			closeDBConnection(c);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error executing sql.");
			f = false;
		}
		return f;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}



}
