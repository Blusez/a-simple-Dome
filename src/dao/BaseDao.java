package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import util.DataConnectUtil;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:07:07
 * @version 1.0
 */
public class BaseDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public ResultSet executeQuery(String sql, Object... obj) {
		connection = DataConnectUtil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] instanceof String) {
					ps.setString(i + 1, String.valueOf(obj[i]));
				}
				if (obj[i] instanceof Integer) {
					ps.setInt(i + 1, Integer.parseInt(obj[i] + ""));
				}
				if (obj[i] instanceof Double) {
					ps.setDouble(i + 1, Double.parseDouble(obj[i] + ""));
				}
			}
			rs = ps.executeQuery();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public boolean executeUpdate(String sql, Object... obj) {
		connection = DataConnectUtil.getConnection();
		boolean flag = false;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] instanceof String) {
					ps.setString(i + 1, String.valueOf(obj[i]));
				}
				if (obj[i] instanceof Integer) {
					ps.setInt(i + 1, Integer.parseInt(obj[i] + ""));
				}
				if (obj[i] instanceof Double) {
					ps.setDouble(i + 1, Double.parseDouble(obj[i] + ""));
				}
				if (obj[i] instanceof Date) {
					ps.setObject(i + 1,new java.sql.Timestamp(((Date)obj[i]).getTime()));
				}
			}
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
			;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public void closeResource() {
		DataConnectUtil.closeSource(connection, ps, rs);
	}
}
