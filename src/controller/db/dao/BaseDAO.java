package controller.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public abstract class BaseDAO {

	protected String driver; //数据库驱动类
	protected String url;
	protected String userName;
	protected String userPassword;
	
	public BaseDAO() {
		// TODO Auto-generated constructor stub
		this.driver = "com.mysql.cj.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/radb_reserve?serverTimezone=GMT%2B8&useSSL=false";
		this.userName = "root";
		this.userPassword = "********";
	}
	
	//打开数据库连接
	public Connection openDBConnection() {
		//连接数据库
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
	
	//关闭数据库连接
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
	
	//执行sql语句并返回结果对象
	public abstract Object query(String sql);
	//执行插入数据的sql语句并返回执行结果
	public abstract boolean insert(String sql);
	//执行更新数据的sql语句并返回执行结果
	public abstract boolean update(String sql);
	//执行删除数据的sql语句并返回执行结果
	public abstract boolean delete(String sql);
	
}
