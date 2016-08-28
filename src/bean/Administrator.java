package bean;

import java.io.Serializable;

/**
 * @author keller
 * @date 创建时间：2016年8月28日下午4:21:44
 * @version 1.0
 */
public class Administrator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9083378596342883904L;
	private String adminNumber;
	private String adminPwd;
	private String adminName;
	
	public Administrator() {
		super();
	}
	public Administrator(String adminNumber, String adminPwd, String adminName) {
		super();
		this.adminNumber = adminNumber;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
	}
	public String getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(String adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
	
}
