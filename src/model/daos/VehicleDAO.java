package model.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.VehicleBean;

public class VehicleDAO extends BaseDAO {

	public VehicleDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("VehicleDAO.query sql:" + sql);
		LinkedList<VehicleBean> vehicleBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				VehicleBean vehicleBean = new VehicleBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "plate_number":
						vehicleBean.setPlateNumber(rs.getString(i + 1));
						break;
					case "car_type":
						vehicleBean.setCarType(rs.getString(i + 1));
						break;
					case "price":
						vehicleBean.setPrice(rs.getFloat(i + 1));
						break;
					case "location_city":
						vehicleBean.setLocationCity(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				vehicleBeans.add(vehicleBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return vehicleBeans;
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
