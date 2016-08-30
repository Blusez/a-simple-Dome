package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:01:44
 * @version 1.0
 */
public class DataConnectUtil {

	private static Connection connection;
	// private static final String URL="oracle.jdbc.driver.OracleDriver";
	// private static final String URL1="jdbc:oracle:thin:@localhost:1521:ORCL";
	// private static final String USERNAME="keller";
	// private static final String PASSWORD="123456";
	private static String URL;
	private static String URL1;
	private static String USERNAME;
	private static String PASSWORD;

	public static void main(String[] args) {
		getProperties();
	}
	/**
	 * 读取就properties文件中的数据
	 */
	public static void getProperties() {
		Properties pro = new Properties();

		String path = "jdbc.properties";
		try {
			// pro.load(new
			// InputStreamReader(DataConnectUtil.class.getResourceAsStream(path)));
			pro.load(DataConnectUtil.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URL = pro.getProperty("jdbc.driver");
		URL1 = pro.getProperty("jdbc.url");
		USERNAME = pro.getProperty("jdbc.username");
		PASSWORD = pro.getProperty("jdbc.password");

	}
	/**
	 * 获得jdbc链接
	 * @return
	 */
	public static Connection getConnection() {
		getProperties();
		try {
			Class.forName(URL);
			connection = DriverManager.getConnection(URL1, USERNAME, PASSWORD);
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
	 * 关闭jdbc资源
	 * @param connection2
	 * @param statement
	 * @param resultSet
	 */
	public static void closeSource(Connection connection2, PreparedStatement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection2 != null) {
				connection2.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
