package service;

import java.util.Scanner;

import dao.BaseDao;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:48:08
 * @version 1.0
 */
public class MybankImpl implements MyBank{
	Scanner scanner = new Scanner(System.in);

	/**
	 * 银行系统主菜单方法
	 */
	public void menu() {
		System.out.println("------------银行系统------------");
		System.out.println("    *********1.管理员********     ");
		System.out.println("    *********2.客    户********     ");
		System.out.println("    *********3.退    出********     ");
		System.out.println("-------------------------------");
		System.out.print("请选择:");
		String userType = scanner.next();
		switch (userType) {
		case "1":
			AdminServiceImpl adminService = new AdminServiceImpl();
			adminService.login();
			adminService.menu();
			break;
		case "2":
			CustomerServiceImpl customerService = new CustomerServiceImpl();
			customerService.login();
			customerService.menu();
			break;
		case "3":
			scanner.close();
			new BaseDao().closeResource();
			return;
		default:
			System.out.println("输入错误，请重新输入！");
			menu();
			break;
		}
		menu();
	}

}
