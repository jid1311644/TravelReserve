package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.HotelRoomBean;

public class HotelRoomDAO extends BaseDAO {

	public HotelRoomDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("HotelRoom.query sql:" + sql);
		LinkedList<HotelRoomBean> hotelRoomBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				HotelRoomBean hotelRoomBean = new HotelRoomBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "hotel_number":
						hotelRoomBean.setHotelNumber(rs.getString(i + 1));;
						break;
					case "room_type":
						hotelRoomBean.setRoomType(rs.getString(i + 1));;
						break;
					case "price":
						hotelRoomBean.setPrice(rs.getFloat(i + 1));;
						break;
					case "total_rooms":
						hotelRoomBean.setTotalRooms(rs.getInt(i + 1));
						break;
					case "vacant_rooms":
						hotelRoomBean.setVacantRooms(rs.getInt(i + 1));
						break;
					default:
						break;
					}
				}
				hotelRoomBeans.add(hotelRoomBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return hotelRoomBeans;
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
		return false;
	}

	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("HotelRoomDAO.update sql:" + sql);
		boolean f = true;
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			//插入数据
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			//关闭数据库链接
			closeDBConnection(c);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error executing sql.");
			f = false;
		}
		return f;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}



}
