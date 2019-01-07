package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.ContactBean;

public class ContactDAO extends BaseDAO {

	public ContactDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("ContactDAO.query sql:" + sql);
		LinkedList<ContactBean> contactBeans = new LinkedList<>();
		try {
			//建立数据库链接
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ContactBean contactBean = new ContactBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "username":
						contactBean.setUsername(rs.getString(i + 1));
						break;
					case "id_number":
						contactBean.setIdNumber(rs.getString(i + 1));
						break;
					case "name":
						contactBean.setName(rs.getString(i + 1));
						break;
					case "tele_number":
						contactBean.setTeleNumber(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				contactBeans.add(contactBean);
			}
			rs.close();
			st.close();
			//关闭数据库链接
			closeDBConnection(c);
			return contactBeans;
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
		System.out.println("ContactDAO.insert sql:" + sql);
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
			//插入失败说明用户已存在
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
