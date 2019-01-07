package model.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.CityBean;

public class CityDAO extends BaseDAO {

	public CityDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("CityDAO.query sql:" + sql);
		LinkedList<CityBean> cityBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				CityBean cityBean = new CityBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "city_id":
						cityBean.setCityID(rs.getString(i + 1));
						break;
					case "city_name":
						cityBean.setCityName(rs.getString(i + 1));
						break;
					case "province_name":
						cityBean.setProvinceName(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				cityBeans.add(cityBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return cityBeans;
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
