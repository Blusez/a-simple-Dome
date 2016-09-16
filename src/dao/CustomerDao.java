package dao;

import bean.Customer;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:08:13
 * @version 1.0
 */
public interface CustomerDao {
	// 顾客登陆
	public boolean login(Customer customer);
	//存款
	public boolean depositMoney(Customer customer, double num);
	//取款
	public boolean drawMoney(Customer customer, double num);
	//查询余额
	public double blance(Customer customer);
	//转账
	public boolean transferAccount(Customer customer, Customer customer1, double num);
	//修改密码方法
	public boolean changePwd(Customer customer, String newpwd);

}
