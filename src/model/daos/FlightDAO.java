package model.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.FlightBean;

public class FlightDAO extends BaseDAO {

	public FlightDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("FlightDAO.query sql:" + sql);
		LinkedList<FlightBean> flightBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				FlightBean flightBean = new FlightBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "flight_number":
						flightBean.setFlightNumber(rs.getString(i + 1));
						break;
					case "price":
						flightBean.setPrice(rs.getFloat(i + 1));
						break;
					case "seats":
						flightBean.setSeats(rs.getInt(i + 1));
						break;
					case "free_seats":
						flightBean.setFreeSeats(rs.getInt(i + 1));
						break;
					case "departure_city":
						flightBean.setDepartureCity(rs.getString(i + 1));
						break;
					case "departure_time":
						flightBean.setDepartureTime(rs.getString(i + 1));
						break;
					case "destination_city":
						flightBean.setDestinationCity(rs.getString(i + 1));
						break;
					case "destination_time":
						flightBean.setDestinationTime(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				flightBeans.add(flightBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return flightBeans;
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
