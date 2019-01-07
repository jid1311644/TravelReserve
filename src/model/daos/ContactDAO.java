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
			//�������ݿ�����
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
			//�ر����ݿ�����
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
