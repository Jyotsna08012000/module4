package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBconnection;

import Model.Delete;
import Model.Student;



public class StudentDao {
	public static void insertstudent(Student s) {
		try {
			Connection connection = DBconnection.getConnection();
			String sqlString = "insert into studinfo (fname,lname,email,mobile,gender,password) values(?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setLong(4, s.getMobile());
			pst.setString(5, s.getGender());
			pst.setString(6, s.getPassword());
			pst.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = DBconnection.getConnection();
			String sql="select * from studinfo";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Student s1 = new Student();
				s1.setId(rs.getInt("id"));
				s1.setFname(rs.getString("fname"));
				s1.setLname(rs.getString("lname"));
				s1.setEmail(rs.getString("email"));
				s1.setMobile(rs.getLong("mobile"));
				s1.setGender(rs.getString("gender"));
			    s1.setPassword(rs.getString("password"));
				list.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		public static void updateProfile(Student s) {
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString="update studinfo set fname=?,lname=?,email=?,mobile=?,gender=?,password=? where id=?";
				System.out.println("id"+s.getId());
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setString(1, s.getFname());
				pst.setString(2, s.getLname());
				pst.setString(3, s.getEmail());
				pst.setLong(4, s.getMobile());
				pst.setString(5, s.getGender());
				pst.setString(6, s.getPassword());
				 pst.setInt(7, s.getId());
				pst.executeUpdate();
				System.out.println("data updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		public static void insertdeletstudent(Delete d) {
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString = "insert into deletedata (sid,fname,lname,email,mobile,gender,password) values(?,?,?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setInt(1, d.getSid());
				pst.setString(2, d.getFname());
				pst.setString(3, d.getLname());
				pst.setString(4, d.getEmail());
				pst.setLong(5, d.getMobile());
				pst.setString(6, d.getGender());
				pst.setString(7, d.getPassword());
				pst.executeUpdate();
				System.out.println("delete data stored ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void removeStudent(int id) {
			try {
				Connection conn = DBconnection.getConnection();
				String sql= "delete from studinfo where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static Student getStudentById(int id) {
			Student s = null;
			try {
				Connection connection = DBconnection.getConnection();
				String sqlString = "select * from studinfo where id=?";
				PreparedStatement pst= connection.prepareStatement(sqlString);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
				    s = new Student();
					s.setId(rs.getInt("id"));
					s.setFname(rs.getString("fname"));
					s.setLname(rs.getString("lname"));
					s.setEmail(rs.getString("email"));
					s.setMobile(rs.getLong("mobile"));
					s.setGender(rs.getString("gender"));
				    s.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return s;
		}

}
