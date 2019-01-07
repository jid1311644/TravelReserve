package controller.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public abstract class BaseDAO {

	protected String driver; //���ݿ�������
	protected String url;
	protected String userName;
	protected String userPassword;
	
	public BaseDAO() {
		// TODO Auto-generated constructor stub
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/radb_reserve?serverTimezone=GMT%2B8&useSSL=false";
		this.userName = "root";
		this.userPassword = "Jellal20143647";
	}
	
	//�����ݿ�����
	public Connection openDBConnection() {
		//�������ݿ�
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(
					this.url, this.userName, this.userPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading DBMS Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting DBMS!");
			e.printStackTrace();
		}
		return c;

	}
	
	//�ر����ݿ�����
	public boolean closeDBConnection(Connection c) {
		if(c == null) {
			return false;
		}
		else {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	
	//ִ��sql��䲢���ؽ������
	public abstract Object query(String sql);
	//ִ�в������ݵ�sql��䲢����ִ�н��
	public abstract boolean insert(String sql);
	//ִ�и������ݵ�sql��䲢����ִ�н��
	public abstract boolean update(String sql);
	//ִ��ɾ�����ݵ�sql��䲢����ִ�н��
	public abstract boolean delete(String sql);
	
}