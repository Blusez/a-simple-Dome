package service;

import java.util.Scanner;

import bean.Administrator;
import bean.Customer;
import dao.AdminDaoImpl;
import dao.CustomerDaoImpl;
import util.MyUtil;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:49:16
 * @version 1.0
 */
public class CustomerService {
	Customer customer;
	Scanner scanner = new Scanner(System.in);
	CustomerDaoImpl cdi;

	/**
	 * 菜单 对顾客登陆、存款、取款、查询余额、转账、修改密码界面的输入和显示
	 */
	public void menu() {
		System.out.println("------------银行系统------------");
		System.out.println("    *********1.存       款********     ");
		System.out.println("    *********2.取       款********     ");
		System.out.println("    *********3.查询余额********     ");
		System.out.println("    *********4.转       账********     ");
		System.out.println("    *********5.修改密码********     ");
		System.out.println("    *********6.退       出********     ");
		System.out.println("-------------------------------");
		System.out.print("请选择:");
		String userType = scanner.next();
		cdi = new CustomerDaoImpl();
		switch (userType) {
		case "1":
			depositMoney();
			break;
		case "2":
			drawMoney();
			break;
		case "3":
			checkblance();
			break;
		case "4":
			transferAccount();
			break;
		case "5":
			changePwd();
			break;
		case "6":
			return;
		default:
			System.out.println("输入错误，请重新输入！");
			menu();
			break;
		}
		menu();

	}
	/**
	 * 用户登录
	 */
	public void login() {
		customer = new Customer();
		System.out.print("用户名:");
		customer.setCustname(scanner.next());
		System.out.print("密    码:");
		customer.setCustpwd(scanner.next());
		cdi = new CustomerDaoImpl();
		if (cdi.login(customer)) {
			System.out.println("登录成功！");
		} else {
			System.out.println("用户名或者密码错误！");
			new Mybank().menu();
		}
	}
	/**
	 * 存款
	 */
	public void depositMoney() {
		System.out.print("请输入存入金额:");
		String num = scanner.next();
		if (cdi.depositMoney(customer, MyUtil.isnum(num))) {
			System.out.println("存款成功！");
		} else {
			// System.out.println();
		}
		;
	}
	/**
	 * 取款
	 */
	public void drawMoney() {
		System.out.print("请输入取款金额:");
		String num = scanner.next();
		if (cdi.drawMoney(customer, MyUtil.isnum(num))) {
			System.out.println("取款成功！");
		}
	}
	/**
	 * chaxunyue
	 */
	public void checkblance() {
		System.out.println("您的余额为：" + cdi.blance(customer));
	}
	/**
	 * 转账
	 */
	public void transferAccount() {
		Customer customer1 = new Customer();
		System.out.print("请输入转账用户名:");
		customer1.setCustname(scanner.next());
		System.out.print("请输入取款金额:");
		String num = scanner.next();
		if (cdi.transferAccount(customer, customer1, MyUtil.isnum(num))) {
			System.out.println("转账成功");
		} else {
			System.out.println("转账失败！");
		}
	}
	/**
	 * 修改密码
	 */
	public void changePwd() {
		System.out.print("请输入原始的密码:");
		customer.setCustpwd(scanner.next());
		if (cdi.login(customer)) {
			boolean flag = true;
			while (flag) {
				System.out.print("请输入新的密码:");
				String newpwd1 = scanner.next();
				System.out.print("请输入新的密码:");
				String newpwd = scanner.next();
				if (newpwd.equals(newpwd1)) {
					if (cdi.changePwd(customer, newpwd)) {
						System.out.println("修改密码成功！");
						flag = false;
					} else {
						System.out.println("两次密码不一致！请重新输入！");
					}
				}
			}
		} else {
			System.out.println("密码不正确！");
		}
	}

}
