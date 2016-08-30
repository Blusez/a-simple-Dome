package dao;

import java.util.List;

import bean.Administrator;
import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:17:03
 * @version 1.0
 */
public interface AdminDao {
	/**
	 * login
	 * 登陆
	 * @param administrator
	 *            administeator info
	 * @return
	 */
	public boolean login(Administrator administrator);

	/**
	 * 增加用户
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(Customer customer);

	/**
	 * 计算总金额
	 * @return
	 */
	public Double totalMoney();

	/**
	 * 返回富豪排行榜
	 * @return
	 */
	public List<Customer> chart();
}
