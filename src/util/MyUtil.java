package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午5:39:39
 * @version 1.0
 */
public class MyUtil {
	
	/**
	 * 自动生成一组数字
	 * @return 以当前时间+一位随机数的字符串形式
	 */
	public static String AutoNumber() {
		// Calendar calendar =Calendar.getInstance();
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yymmddhhmmss");
		Math.random();
		String num = getdate() + String.valueOf((int) (Math.random() * 10));
		return num;
	}
	/**
	 * 获取当前时间
	 * @return 当前时间的字符串形式
	 */
	public static String getdate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}

	/**
	 * 判断输入是否为数字，是转为double并返回，否则返回0
	 * 
	 * @param num
	 * @return
	 */
	public static double isnum(String num) {
		boolean flag = true;
		for (int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(num.charAt(i))) {
				flag = false;
			}
		}
		double temp = 0;
		if (flag) {
			temp = Double.parseDouble(num);
		} else {
			System.out.println("输入有误");
		}
		return temp;
	}

}
