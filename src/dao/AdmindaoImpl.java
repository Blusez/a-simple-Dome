package dao;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Administrator;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:22:41
 * @version 1.0
 */
public class AdmindaoImpl extends BaseDao implements AdminDao {
	private ResultSet resultSet;
	@Override
	public boolean login(Administrator administrator) {
		boolean flag = false;
		String sql = "select *from administrator where adminname=? and adminPwd=?";
		resultSet = executeQuery(sql, administrator.getAdminName(),administrator.getAdminPwd());
		try {
			if (resultSet.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addCustomer(Administrator administrator) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update administrator set adminPwd=? where adminname = ?";
		return flag;
	}

	@Override
	public Double totalMoney(Administrator administrator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List chart() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
