package dao;

import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:08:13
 * @version 1.0
 */
public interface CustomerDao {
	//顾客登陆、存款、取款、查询余额、转账、修改密码方法
	public boolean login(Customer customer);
	public boolean depositMoney(Customer customer, double num);
	public boolean drawMoney(Customer customer, double num);
	public double blance(Customer customer);
	public boolean transferAccount(Customer customer,Customer customer1,double num);
	public boolean changePwd(Customer customer,String newpwd);
	
	
}
