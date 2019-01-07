package model.beans;

import java.util.LinkedList;

import model.daos.ContactDAO;
import model.daos.UserDAO;

public class ContactBean {
	
	private String username;
	private String idNumber;
	private String name;
	private String teleNumber;
	
	@SuppressWarnings("unchecked")
	public LinkedList<ContactBean> search(String username) {
		// TODO Auto-generated method stub
		String sql = "select username,id_number,name,tele_number from user"
				+ " where username='" + username + "'";
		LinkedList<UserBean> ubs = (LinkedList<UserBean>) new UserDAO().query(sql);
		if(ubs.size() != 1) {
			return null;
		}
		else {
			UserBean ub = ubs.poll();
			ContactBean cb = new ContactBean();
			cb.setIdNumber(ub.getIdNumber());
			cb.setName(ub.getName());
			cb.setTeleNumber(ub.getTeleNumber());
			cb.setUsername(username);

			sql = "select * from contact where username='" + username + "'";
			LinkedList<ContactBean> cbs = (LinkedList<ContactBean>) new ContactDAO().query(sql);
			cbs.addFirst(cb);
			return cbs;
		}
	}
	

	@SuppressWarnings("unchecked")
	public ContactBean selectPassenger(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from contact where id_number='" + id + "'";
		LinkedList<ContactBean> cbs = (LinkedList<ContactBean>) new ContactDAO().query(sql);
		if(cbs.size() == 1) {
			return cbs.poll();
		}
		return null;
	}
	
	public boolean add(String username, String tele, String id, String name) {
		// TODO Auto-generated method stub
		String sql = "insert into contact (username,id_number,name,tele_number) values("
				+ "'" + username + "',"
				+ "'" + id + "',"
				+ "'" + name + "',"
				+ "'" + tele + "')";
		return new ContactDAO().insert(sql);
	}
	
	public boolean add(String username2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getUsername() {
		return username;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public String getName() {
		return name;
	}
	public String getTeleNumber() {
		return teleNumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

}
