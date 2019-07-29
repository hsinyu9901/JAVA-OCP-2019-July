/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import tw.com.pcschool.db.GetDBConnection;
import tw.com.pcschool.domain.Student;
import tw.com.pcschool.factory.StudentDao;
import tw.com.pcschool.message.Message;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月26日<br>
 * TODO<br>
 *
 *
 */
/*
 * private int stuId;
private String stuName;
private int stuAge;
private String stuPhone;
private String stuAddress;
 */

public class StudentImpl implements StudentDao {

	@Override
	public void addStudent(Student stu) {
		Connection conn = GetDBConnection.getMyConnection().getConnection();
		
		String addSql="insert into student(stuName,stuAge,stuPhone,stuAddress) value(?,?,?,?);";
		
		PreparedStatement ps =null;
		try {
			ps=conn.prepareStatement(addSql);
			ps.setString(1, stu.getStuName());
			ps.setInt(2, stu.getStuAge());
			ps.setString(3, stu.getStuPhone());
			ps.setString(4, stu.getStuAddress());
			int i = ps.executeUpdate();
			Message.getMessage("新增"+i+"筆資料...");
		} catch (SQLException e) {
			//e.printStackTrace();
			Message.getMessage("新增資料錯誤");
		}finally {
			try {
				GetDBConnection.getMyConnection().close(ps);
				GetDBConnection.getMyConnection().close(conn);
			} catch (SQLException e) {
				//e.printStackTrace();
				Message.getMessage("資料庫關閉錯誤");
			}
		}
		
	}

	public ResultSet selectAllStudent() {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn = GetDBConnection.getMyConnection().getConnection();
			String selectAll="select stuName as Name, stuAge as Age, stuPhone as Phone, stuAddress as Address from student;";
			ps=conn.prepareStatement(selectAll);
			rs=ps.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			Message.getMessage("資料讀取錯誤");
		}/*finally {
			try {
				GetDBConnection.getMyConnection().close(rs);
				GetDBConnection.getMyConnection().close(ps);
				GetDBConnection.getMyConnection().close(conn);
			} catch (SQLException e) {
				//e.printStackTrace();
				Message.getMessage("資料庫關閉錯誤");
			}
		}*/
		return null;
	}

	@Override
	public ResultSet oneSelect(String name) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn = GetDBConnection.getMyConnection().getConnection();
			String select="select stuName as Name, stuAge as Age, stuPhone as Phone, stuAddress as Address from student where stuName=?;";
			ps=conn.prepareStatement(select);
			ps.setString(1, name);
			rs=ps.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			Message.getMessage("資料讀取錯誤");
		}
		return null;
	}

	
}
