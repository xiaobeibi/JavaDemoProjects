package com.bjpowernode.hospitalhr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具类
 * @author tony li
 *
 */
public class MTimeUtil {
	
	/**
	 * 获取当前的日期
	 * @return
	 */
	public static Date nowDate(){
		String str = MTimeUtil.dateFormat(new Date());
		return MTimeUtil.stringParse(str);
	}
	
	/**
	 * 获取当前的时间
	 * @return
	 */
	public static Date nowTime(){
		String str = MTimeUtil.timeFormat(new Date());
		return MTimeUtil.stringTimeParse(str);
	}
	
	public static String format(Date date){
		if (date != null && !date.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = sdf.format(date);
			return str;
		}else{
			return null;
		}
	}

	public static String dateFormat(Date date){
		if (date != null && !date.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(date);
			return str;
		}else{
			return null;
		}
	}
	
	public static String timeFormat(Date date){
		if (date != null && !date.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String str = sdf.format(date);
			return str;
		}else{
			return null;
		}
	}

	public static Date stringParse(String str) {
		if (str != null && !str.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}else{
			return null;
		}
		
		
	}
	public static Date stringTimeParse(String str) {
		if (str != null && !str.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date date = null;
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}else{
			return null;
		}
		
	}
	

	

}
