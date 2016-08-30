package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Administrator;
import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:22:41
 * @version 1.0
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
	private ResultSet resultSet;
	String sql;

	@Override
	public boolean login(Administrator administrator) {
		boolean flag = false;
		sql = "select *from administrator where adminname=? and adminPwd=?";
		resultSet = executeQuery(sql, administrator.getAdminName(), administrator.getAdminPwd());
		try {
			if (resultSet.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		sql = "insert into CUSTOMER(CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE) values(?,?,?,?,?,sysdate)";
		flag = executeUpdate(sql, customer.getCustnumber(), customer.getCustname(), customer.getCustpwd(),
				customer.getCustcard(), customer.getCustmoney());
		return flag;
	}

	@Override
	public Double totalMoney() {
		// TODO Auto-generated method stub
		double totalmoney = 0;
		sql = "select sum(CUSTMONEY) from CUSTOMER";
		resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				totalmoney = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalmoney;
	}

	@Override
	public List<Customer> chart() {
		ArrayList<Customer> chart = new ArrayList<Customer>();
		sql = "select * from CUSTOMER order by CUSTMONEY desc";
		resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				// CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE
				customer.setCustnumber(resultSet.getString(1));
				customer.setCustname(resultSet.getString(2));
				customer.setCustpwd(resultSet.getString(3));
				customer.setCustcard(resultSet.getString(4));
				customer.setCustmoney(resultSet.getDouble(5));
				customer.setCustdate((Date) resultSet.getTimestamp(6));
				chart.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chart;
	}

}
