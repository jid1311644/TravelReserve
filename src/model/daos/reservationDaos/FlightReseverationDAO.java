package model.daos.reservationDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.reservationBeans.FlightReseverationBean;

public class FlightReseverationDAO extends BaseDAO {

	public FlightReseverationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("FlightReseverationDAO.query sql:" + sql);
		LinkedList<FlightReseverationBean> flightReseverationBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				FlightReseverationBean flightReseverationBean = new FlightReseverationBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "reservation_id":
						flightReseverationBean.setReservationID(rs.getString(i + 1));;
						break;
					case "username":
						flightReseverationBean.setUsername(rs.getString(i + 1));;
						break;
					case "flight_number":
						flightReseverationBean.setFlightNumber(rs.getString(i + 1));;
						break;
					case "passenger_id":
						flightReseverationBean.setPassengerID(rs.getString(i + 1));;
						break;
	
					default:
						break;
					}
				}
				flightReseverationBeans.add(flightReseverationBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return flightReseverationBeans;
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
		System.out.println("FlightReseverationDAO.insert sql:" + sql);
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
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.update sql:" + sql);
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
