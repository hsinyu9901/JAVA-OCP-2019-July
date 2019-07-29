/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.dao;

import java.sql.Connection;
import java.sql.SQLException;

import tw.com.pcschool.db.GetDBConnection;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月24日<br>
 * TODO<br>
 *
 *
 */

public class TestMain {

	public void getDB() {
		//不備重複new
		Connection conn = GetDBConnection.getMyConnection().getConnection();
		try {
			GetDBConnection.getMyConnection().close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
