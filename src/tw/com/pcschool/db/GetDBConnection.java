/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月22日<br>
 * TODO<br>
 *
 *
 */

public class GetDBConnection {
	
	private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	/*
	 * 	jdbc:mysql://localhost:3306/DBName
	 * 	jdbc:mysql://127.0.0.1:3306/DBName
	 * 	jdbc:mysql:///DBName
	 * 
	 */
	private static String JDBC_URL="jdbc:mysql://localhost:3306/myproject";
	private static String JDBC_USERNAME="root";
	private static String JDBC_PASSWORD="123456";
	
	private GetDBConnection() {	//私有化建構子
		
	}
	
	public static GetDBConnection getMyConnection(){	//靜態方法,回傳 new 建構子
		return new GetDBConnection();
	}
	
	public Connection getConnection() {
		Connection conn=null;
		
		try {
			
			Class.forName(JDBC_DRIVER);//反射
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public void close(Connection conn) throws SQLException {
		if(conn !=null) {
			conn.close();
		}
	}

	public void close(Statement st) throws SQLException {
		if(st!=null) {
			st.close();
		}
	}

	public void close(PreparedStatement ps) throws SQLException {
		if(ps!=null) {
			ps.close();
		}
	}

	public void close(ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
	}
}
