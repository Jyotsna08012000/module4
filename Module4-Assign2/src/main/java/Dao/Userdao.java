package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import connection.DBconnection;
import model.User;


public class Userdao {
	public static void insertUser(User u) {
		try {
			Connection connection = DBconnection.getConnection();
			String sqlString= "insert into user(fname,lname,email,mobile,password) value(?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
			} catch (Exception e) {
			e.printStackTrace();
		   }
		}
	
		public static User userLogin(User u) {
			User user = null;
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString= "select * from user where email=? and password=?";
				PreparedStatement pst= connection.prepareStatement(sqlString);
				pst.setString(1,u.getEmail());
				pst.setString(2,u.getPassword());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setFname(rs.getString("fname"));
					user.setLname(rs.getString("lname"));
					user.setEmail(rs.getString("Email"));
					user.setMobile(rs.getLong("mobile"));
					user.setPassword(rs.getString("password"));
				 }
		} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
		public static User getUserById(int id) {
			User user = null;
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString="select * from user where id=?";
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setFname(rs.getString("fname"));
					user.setLname(rs.getString("lname"));
					user.setEmail(rs.getString("Email"));
					user.setMobile(rs.getLong("mobile"));
					user.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
		public static void editUser(User u) {
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString="update user set fname=?,lname=?,email=?,mobile=?,password=? where id=?";
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setString(1, u.getFname());
				pst.setString(2, u.getLname());
				pst.setString(3, u.getEmail());
				pst.setLong(4, u.getMobile());
				pst.setString(5, u.getPassword());
			    pst.setInt(6, u.getId());
				pst.executeUpdate();
				System.out.println("data updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static boolean checkEmail(String email) {
			boolean flag=false;
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString="select * from user where email=?";
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setString(1, email);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					flag=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		}
