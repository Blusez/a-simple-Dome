package service;

import java.util.List;
import java.util.Scanner;
import bean.Administrator;
import bean.Customer;
import dao.AdminDaoImpl;
import util.MyUtil;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午6:49:01
 * @version 1.0
 */
public class AdminService {
	Scanner scanner = new Scanner(System.in);
	Administrator administrtor;
	AdminDaoImpl adi;

	/**
	 * 菜单 对管理员登陆、添加顾客、计算储蓄总额、富豪排行榜界面的输入和显示
	 */
	public void menu() {
		System.out.println("------------银行系统------------");
		System.out.println("    *********1.添 加 顾 客********     ");
		System.out.println("    *********2.储 蓄 总 额********     ");
		System.out.println("    *********3.富豪排行榜********     ");
		System.out.println("    *********4.退           出********     ");
		System.out.println("-------------------------------");
		System.out.print("请选择:");
		String userType = scanner.next();
		switch (userType) {
		case "1":
			addCustomer();
			break;
		case "2":
			totalMoney();
			break;
		case "3":
			chart();
			break;
		case "4":
			return;
		default:
			System.out.println("输入错误，请重新输入！");
			menu();
			break;
		}
		menu();
	}

	/**
	 * 管理员登陆
	 */
	public void login() {
		administrtor = new Administrator();
		System.out.print("用户名:");
		administrtor.setAdminName(scanner.next());
		System.out.print("密    码:");
		administrtor.setAdminPwd(scanner.next());
		adi = new AdminDaoImpl();
		if (adi.login(administrtor)) {
			System.out.println("登录成功！");
		} else {
			System.out.println("用户名或者密码错误！");
			new Mybank().menu();
		}
	}

	/**
	 * 增加用户 CUSTNUMBER,CUSTNAME,CUSPWD,CUSTIDCARD,CUSTMONEY,CUSDATE
	 */
	public void addCustomer() {
		Customer customer = new Customer();
		customer.setCustnumber(MyUtil.AutoNumber());
		System.out.print("请输入用户名:");
		customer.setCustname(scanner.next());
		System.out.print("请输入密码:");
		customer.setCustpwd(scanner.next());
		System.out.print("请输入身份证号码:");
		customer.setCustcard(scanner.next());
		System.out.print("请输入开户金额:");
		String money = scanner.next();
		customer.setCustmoney(MyUtil.isnum(money));
		adi = new AdminDaoImpl();
		if (adi.addCustomer(customer)) {
			System.out.println("开户成功！");
		} else {
			System.out.println("开户失败！");
		}
		;
	}

	/**
	 * 计算总金额
	 */
	public void totalMoney() {
		System.out.println("储蓄总额:" + adi.totalMoney());
		;
	}

	/**
	 * 富豪排行榜
	 */
	public void chart() {
		List<Customer> chart = adi.chart();
		int i = 0;
		for (Customer customer : chart) {
			i++;
			System.out.println("第" + i + "名 " + customer.toString());
		}

	}
}
