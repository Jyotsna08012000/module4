package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBconnection;
import model.StudentModel;

public class StudentDao {
	public static void insertstudent(StudentModel s) {
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

}
