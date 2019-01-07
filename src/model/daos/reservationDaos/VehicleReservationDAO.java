package model.daos.reservationDaos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import controller.db.dao.BaseDAO;
import model.beans.UserBean;
import model.beans.reservationBeans.VehicleReservationBean;

public class VehicleReservationDAO extends BaseDAO {

	public VehicleReservationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object query(String sql) {
		// TODO Auto-generated method stub
		System.out.println("VehicleReservationDAO.query sql:" + sql);
		LinkedList<VehicleReservationBean> vehicleReservationBeans = new LinkedList<>();
		try {
			//�������ݿ�����
			Connection c = openDBConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				VehicleReservationBean vehicleReservationBean = new VehicleReservationBean();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				for(int i = 0; i < columns; i++) {
					switch (rsmd.getColumnName(i + 1)) {
					case "reservation_id":
						vehicleReservationBean.setReservationID(rs.getString(i + 1));
						break;
					case "username":
						vehicleReservationBean.setUsername(rs.getString(i + 1));
						break;
					case "plate_number":
						vehicleReservationBean.setPlateNumber(rs.getString(i + 1));
						break;
					case "ticket":
						vehicleReservationBean.setTicket(rs.getInt(i + 1));
						break;
					default:
						break;
					}
				}
				vehicleReservationBeans.add(vehicleReservationBean);
			}
			rs.close();
			st.close();
			//�ر����ݿ�����
			closeDBConnection(c);
			return vehicleReservationBeans;
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
		System.out.println("VehicleReservationDAO.insert sql:" + sql);
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
		System.out.println("VehicleReservationDAO.update sql:" + sql);
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
	public boolean delete(String sql) {
		// TODO Auto-generated method stub
		return false;
	}



}
