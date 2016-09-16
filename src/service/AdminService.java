package service;
/**
 * @author keller
 * @date 创建时间：2016年9月13日下午5:06:33
 * @version 1.0
 */
public interface AdminService {
	
	/**
	 * 菜单 对管理员登陆、添加顾客、计算储蓄总额、富豪排行榜界面的输入和显示
	 */
	public void menu();
	/**
	 * 管理员登陆
	 */
	public void login();
	/**
	 * 增加用户 CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE
	 */
	public void addCustomer() ;
	/**
	 * 计算总金额
	 */
	public void totalMoney();
	/**
	 * 富豪排行榜
	 */
	public void chart() ;

}
