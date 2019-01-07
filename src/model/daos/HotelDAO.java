package model.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.HotelBean;

public class HotelDAO extends BaseDAO {

	public HotelDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("HotelDAO.query sql:" + sql);
		LinkedList<HotelBean> hotelBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				HotelBean hotelBean = new HotelBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "hotel_number":
						hotelBean.setHotelNumber(rs.getString(i + 1));
						break;
					case "hotel_name":
						hotelBean.setHotelName(rs.getString(i + 1));
						break;
					case "address":
						hotelBean.setAddress(rs.getString(i + 1));
						break;
					case "location_city":
						hotelBean.setLocationCity(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				hotelBeans.add(hotelBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return hotelBeans;
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
		return false;
	}

	@Override
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}


}
