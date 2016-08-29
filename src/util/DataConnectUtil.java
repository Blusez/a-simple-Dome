package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:01:44
 * @version 1.0
 */
public class DataConnectUtil {

	private static Connection connection;
	private static final String URL="oracle.jdbc.driver.OracleDriver";
	private static final String URL1="jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USERNAME="keller";
	private static final String PASSWORD="123456";
	public static Connection getConnection(){
		try {
			Class.forName(URL);
			connection= DriverManager.getConnection(URL1, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	/**
	 * 
	 * @param connection2
	 * @param statement
	 * @param resultSet
	 */
	public static void closeSource(Connection connection2,
			PreparedStatement statement, ResultSet resultSet) {
		try {
			if (resultSet!=null) {
				resultSet.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection2!=null) {
				connection2.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 

}
