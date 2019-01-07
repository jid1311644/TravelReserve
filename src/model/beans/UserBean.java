package model.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.daos.UserDAO;

public class UserBean {
	
	private String username;
	private String password;
	private String teleNumber;
	private String idNumber;
	private String name;
	private Boolean sex;
	
	@SuppressWarnings("unchecked")
	public boolean login(String username, String password) {
		String sql = "select password from user where username='" + username + "'";
		UserDAO userDAO = new UserDAO();
		LinkedList<UserBean> userBeans = (LinkedList<UserBean>) userDAO.query(sql);
		int count = 0;
		String psw = "";
		while(!userBeans.isEmpty()) {
			psw = userBeans.pollFirst().getPassword();
			count++;
		}
		if(count == 1) {
			return psw.equals(password);
		}
		else {
			return false;
		}
	}
	
	public boolean register(String username, String password, String teleNumber, 
			String idNumber, String name, Boolean sex) {
		String sql = "insert into user "
				+ "(username,password,tele_number,id_number,name,sex)values("
				+ "'" + username + "',"
				+ "'" + password + "',"
				+ "'" + teleNumber + "',"
				+ "'" + idNumber + "',"
				+ "'" + name + "',"
				+ "'" + (sex?"1": "0") + "'"
				+ ")";
		return new UserDAO().insert(sql);
	}
	
	@SuppressWarnings("unchecked")
	public UserBean selectPassenger(String id) {
		// TODO Auto-generated method stub
		String sql = "select id_number,name,tele_number from user"
				+ " where id_number='" + id + "'";
		LinkedList<UserBean> ubs = (LinkedList<UserBean>) new UserDAO().query(sql);
		if(ubs.size() == 1) {
			return ubs.poll();
		}
		return null;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getTeleNumber() {
		return teleNumber;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public String getName() {
		return name;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
}
