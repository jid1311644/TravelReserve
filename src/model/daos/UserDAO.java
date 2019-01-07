package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.UserBean;

public class UserDAO extends BaseDAO {

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("UserDAO.query sql:" + sql);
		LinkedList<UserBean> userBeans = new LinkedList<>();
		try {
			//�������ݿ�����
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				UserBean userBean = new UserBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "username":
						userBean.setUsername(rs.getString(i + 1));
						break;
					case "password":
						userBean.setPassword(rs.getString(i + 1));
						break;
					case "tele_number":
						userBean.setTeleNumber(rs.getString(i + 1));
						break;
					case "id_number":
						userBean.setIdNumber(rs.getString(i + 1));
						break;
					case "name":
						userBean.setName(rs.getString(i + 1));
						break;
					case "sex":
						userBean.setSex(rs.getBoolean(i + 1));
						break;
					default:
						break;
					}
				}
				userBeans.add(userBean);
			}
			rs.close();
			st.close();
			//�ر����ݿ�����
			closeDBConnection(c);
			return userBeans;
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
		System.out.println("UserDAO.insert sql:" + sql);
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
			//����ʧ��˵���û��Ѵ���
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
