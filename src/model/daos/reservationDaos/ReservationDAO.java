package model.daos.reservationDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.reservationBeans.ReservationBean;

public class ReservationDAO extends BaseDAO {

	public ReservationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("ReservationDAO.query sql:" + sql);
		LinkedList<ReservationBean> reservationBeans = new LinkedList<>();
		try {
			//�������ݿ�����
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ReservationBean reservationBean = new ReservationBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "reservation_id":
						reservationBean.setReservationID(rs.getString(i + 1));
						break;
					case "username":
						reservationBean.setUsername(rs.getString(i + 1));
						break;
					case "time":
						reservationBean.setTime(rs.getString(i + 1));
						break;
					case "type":
						reservationBean.setType(rs.getString(i + 1));
						break;
					default:
						break;
					}
				}
				reservationBeans.add(reservationBean);
			}
			rs.close();
			st.close();
			//�ر����ݿ�����
			closeDBConnection(c);
			return reservationBeans;
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
		System.out.println("ReservationDAO.insert sql:" + sql);
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
