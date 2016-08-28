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
	private double custmeney;
	private Date custdate;
	
	
	public Customer() {
		super();
	}
	public Customer(String custnumber, String custname, String custpwd, String custcard, double custmeney,
			Date custdate) {
		super();
		this.custnumber = custnumber;
		this.custname = custname;
		this.custpwd = custpwd;
		this.custcard = custcard;
		this.custmeney = custmeney;
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
	public double getCustmeney() {
		return custmeney;
	}
	public void setCustmeney(double custmeney) {
		this.custmeney = custmeney;
	}
	public Date getCustdate() {
		return custdate;
	}
	public void setCustdate(Date custdate) {
		this.custdate = custdate;
	}
}
