package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:18:56
 * @version 1.0
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	ResultSet rs;
	String sql;

	@Override
	public boolean login(Customer customer) {
		boolean flag = false;
		sql = "select * from CUSTOMER where CUSTNAME = ? and CUSPWD =?";
		rs = executeQuery(sql, customer.getCustname(), customer.getCustpwd());
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean depositMoney(Customer customer, double num) {
		boolean flag = false;
		sql = "update CUSTOMER set CUSTMONEY =CUSTMONEY+? where CUSTNAME = ?";
		flag = executeUpdate(sql, num, customer.getCustname());
		return flag;
	}

	@Override
	public boolean drawMoney(Customer customer, double num) {
		boolean flag = false;
		if (blance(customer) >= num) {
			sql = "update CUSTOMER set CUSTMONEY =CUSTMONEY-? where CUSTNAME = ?";
			flag = executeUpdate(sql, num, customer.getCustname());
		} else {
			System.out.println("余额不足！");
		}
		return flag;
	}

	@Override
	public double blance(Customer customer) {
		// TODO Auto-generated method stub
		double blance = 0;
		sql = "select CUSTMONEY from CUSTOMER where CUSTNAME = ?";
		rs = executeQuery(sql, customer.getCustname());
		try {
			while (rs.next()) {
				blance = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blance;
	}

	public boolean exitsuser(Customer customer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		sql = "select CUSTMONEY from CUSTOMER where CUSTNAME = ?";
		rs = executeQuery(sql, customer.getCustname());
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean transferAccount(Customer customer, Customer customer1, double num) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (exitsuser(customer1)) {
			if (blance(customer) >= num) {
				drawMoney(customer, num);
				depositMoney(customer1, num);
				flag = true;
			} else {
				System.out.println("余额不足！");
			}
		} else {
			System.out.println("用户不存在！");
		}
		return flag;
	}

	@Override
	public boolean changePwd(Customer customer, String newpwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (flag) {

		}
		sql = "update CUSTOMER set CUSPWD = ? where CUSTNAME = ?";
		flag = executeUpdate(sql, newpwd, customer.getCustname());
		return flag;
	}
	// public boolean confimpwd(){
	//
	// }

}
