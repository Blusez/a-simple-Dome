package service;
/**
 * @author keller
 * @date 创建时间：2016年9月13日下午5:08:34
 * @version 1.0
 */
public interface CustomerService {
	/**
	 * 菜单 对顾客登陆、存款、取款、查询余额、转账、修改密码界面的输入和显示
	 */
	public void menu() ;
	/**
	 * 用户登录
	 */
	public void login();
	/**
	 * 存款
	 */
	public void depositMoney();
	/**
	 * 取款
	 */
	public void drawMoney();
	/**
	 * 查询余额
	 */
	public void checkblance();
	
	/**
	 * 转账
	 */
	public void transferAccount();
	
	/**
	 * 修改密码
	 */
	public void changePwd();
}
