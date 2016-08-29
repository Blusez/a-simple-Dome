package bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午4:56:52
 * @version 1.0
 */
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4852717977574823877L;
	private String custnumber;
	private String custname;
	private String custpwd;
	private String custcard;
	private double custmoney;
	private Date custdate;
	
	
	public Customer() {
		super();
	}
	public Customer(String custnumber, String custname, String custpwd, String custcard, double custmoney,
			Date custdate) {
		super();
		this.custnumber = custnumber;
		this.custname = custname;
		this.custpwd = custpwd;
		this.custcard = custcard;
		this.custmoney = custmoney;
		this.custdate = custdate;
	}
	public String getCustnumber() {
		return custnumber;
	}
	public void setCustnumber(String custnumber) {
		this.custnumber = custnumber;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustpwd() {
		return custpwd;
	}
	public void setCustpwd(String custpwd) {
		this.custpwd = custpwd;
	}
	public String getCustcard() {
		return custcard;
	}
	public void setCustcard(String custcard) {
		this.custcard = custcard;
	}
	public double getCustmoney() {
		return custmoney;
	}
	public void setCustmoney(double custmoney) {
		this.custmoney = custmoney;
	}
	public Date getCustdate() {
		return custdate;
	}
	public void setCustdate(Date custdate) {
		this.custdate = custdate;
	}
	@Override
	public String toString() {
		String str = "银行账号："+custnumber+ " 开户姓名："+custname+" 身份证号码："
	+custcard+" 余额："+custmoney+" 开户日期："+custdate;
		return str;
	}
}
