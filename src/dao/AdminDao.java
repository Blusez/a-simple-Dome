package dao;

import java.util.List;

import bean.Administrator;

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
	public boolean addCustomer(Administrator administrator);
	/**
	 * 
	 * @param administrator
	 * @return
	 */
	public Double totalMoney(Administrator administrator);
	/**
	 * 
	 * @return
	 */
	public List chart();
}
