package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author keller
 * @date 创建时间：2016年8月29日下午5:39:39
 * @version 1.0
 */
public class MyUtil {
	public static String AutoNumber(){
//		Calendar calendar =Calendar.getInstance();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yymmddhhmmss");
		Math.random();
		String num = getdate() + String.valueOf((int)(Math.random()*10));
		return num;
	}
	public static String getdate(){
		Calendar calendar =Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yymmddhhmmss");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	
	
	
}
