package dao;

import java.util.List;

import bean.Administrator;
import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午5:17:03
 * @version 1.0
 */
public interface AdminDao  {
	/**
	 * login
	 * @param administrator
	 * 		  administeator info
	 * @return
	 */
	public boolean login(Administrator administrator);
	/**
	 * 
	 * @param administrator
	 * @return
	 */
	public boolean addCustomer(Customer customer);
	/**
	 * 
	 * @param administrator
	 * @return
	 */
	public Double totalMoney(Customer customer);
	/**
	 * 
	 * @return
	 */
	public List<Customer> chart();
}
