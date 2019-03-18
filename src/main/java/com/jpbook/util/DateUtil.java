package com.jpbook.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	static Calendar cal=Calendar.getInstance();
	static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/**
	 * 获取年份
	 * @param date
	 * @return
	 */
	public static Integer getYear(Date date){
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	/**
	 * 获取月份
	 * @param date
	 * @return
	 */
	public static Integer getMonth(Date date){
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1;
	}
	/**
	 * 获取日期
	 * @param date
	 * @return
	 */
	public static Integer getDay(Date date){
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 获取时间(12计时法)
	 * @param date
	 * @return
	 */
	public static Integer get12Hour(Date date){
		cal.setTime(date);
		return cal.get(Calendar.HOUR);
	}
	/**
	 * 获取时间(24计时法)
	 * @param date
	 * @return
	 */
	public static Integer get24Hour(Date date){
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 获取分
	 * @param date
	 * @return
	 */
	public static Integer getMinute (Date date){
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	/**
	 * 获取秒
	 * @param date
	 * @return
	 */
	public static Integer getSecond (Date date){
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
	/**
	 * 获取星期几
	 * @param date
	 * @return
	 */
	public static Integer getWeek(Date date){
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK)-1==0?7:cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	/**
	 * 获取当前是第几周
	 * @param date
	 * @return
	 */
	public static Integer getWeekInMonth(Date date){
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}
	/**
	 * 年份增加
	 * @param date
	 * @return
	 */
	public static Date addYear(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.YEAR, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 月份增加
	 * @param date
	 * @return
	 */
	public static Date addMonth(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.MONTH, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 天数增加
	 * @param date
	 * @return
	 */
	public static Date addDay(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 小时增加
	 * @param date
	 * @return
	 */
	public static Date addHour(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.HOUR, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 分钟增加
	 * @param date
	 * @return
	 */
	public static Date addMinute (Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.MINUTE, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 秒增加
	 * @param date
	 * @return
	 */
	public static Date addSecond(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.SECOND, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 星期增加
	 * @param date
	 * @return
	 */
	public static Date addWeek(Date date,Integer arg){
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_WEEK, arg);
		date=cal.getTime();
		return date;
	}
	/**
	 * 设置日期(类型,值)
	 * @param field	the given calendar field
	 * @param value	the value to be set for the given calendar field
	 * @return
	 */
	public static Date setDate(int field,int value){
		cal.set(field, value);;
		Date date=cal.getTime();
		return date;
	}
	/**
	 * 设置日期(年,月,日)
	 * @param year		yyyy
	 * @param month 	MM
	 * @param day		dd
	 * @return
	 */
	public static Date setDate(int year,int month,int day){
		cal.set(year, month, day);
		Date date=cal.getTime();
		return date;
	}
	/**
	 * 设置日期(年,月,日,时,分)
	 * @param year		yyyy
	 * @param month 	MM
	 * @param day		dd
	 * @param hour		hh
	 * @param minute	mm
	 * @return
	 */
	public static Date setDate(int year,int month,int day,int hour,int minute){
		cal.set(year, month, day, hour, minute);
		Date date=cal.getTime();
		return date;
	}
	/**
	 * 设置日期(年,月,日,时,分,秒)
	 * @param year		yyyy
	 * @param month 	MM
	 * @param day		dd
	 * @param hour		hh
	 * @param minute	mm
	 * @param second	ss
	 * @return
	 */
	public static Date setDate(int year,int month,int day,int hour,int minute,int second){
		cal.set(year, month, day, hour, minute, second);
		Date date=cal.getTime();
		return date;
	}
	/**
	 * 获取短日期
	 * @param str yyyy-MM-dd
	 * @return
	 */
	public static Date getDate(String str){
		Date d=new Date();
		try {
			d=sdf1.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * 获取长日期
	 * @param str yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static Date getLongDate(String str){
		Date d=new Date();
		try {
			d=sdf2.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * 获取短日期(年-月-日)
	 * @param date	日期类型
	 * @return
	 */
	public static String getStr(Date date){
		return sdf1.format(date);
	}
	/**
	 * 获取长日期(年-月-日 时:分:秒)
	 * @param date	日期类型
	 * @return
	 */
	public static String getLongStr(Date date){
		return sdf2.format(date);
	}
	/**
	 * 获取时间差
	 * @param maxDate
	 * @param minDate
	 * @return x年x月x日
	 */
	public static String getSubDate(Date maxDate,Date minDate){
		LocalDate maxD =LocalDate.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate));
		LocalDate minD =LocalDate.of(getYear(minDate), getMonth(minDate), getDay(minDate));
		Period p = Period.between(minD, maxD);
		
		return "目标日期距离今天的时间差："+p.getYears()+" 年 "+p.getMonths()+" 个月 "+p.getDays()+" 天\n";
	}
	/**
	 * 获取年份差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubYear(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.YEARS.between(minD,maxD);
	}
	/**
	 * 获取月份差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubMonth(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.MONTHS.between(minD,maxD);
	}
	/**
	 * 获取天数差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubDay(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.DAYS.between(minD,maxD);
	}
	/**
	 * 获取小时差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubHour(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.HOURS.between(minD,maxD);
	}
	/**
	 * 获取分钟差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubMinute(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.MINUTES.between(minD,maxD);
	}
	/**
	 * 获取秒差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static Long getSubSecond(Date maxDate,Date minDate){
		LocalDateTime maxD =LocalDateTime.of(getYear(maxDate), getMonth(maxDate), getDay(maxDate),get24Hour(maxDate), getMinute(maxDate), getSecond(maxDate));
		LocalDateTime minD =LocalDateTime.of(getYear(minDate), getMonth(minDate), getDay(minDate),get24Hour(minDate), getMinute(minDate), getSecond(minDate));
		return ChronoUnit.SECONDS.between(minD,maxD);
	}
	/**
	 * 获取时间差
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static String getSubDateTime(Date maxDate,Date minDate){
		Integer d=getDay(maxDate)-getDay(minDate);
		Integer h=get24Hour(maxDate)-get24Hour(minDate);
		Integer m=getMinute(maxDate)-getMinute(minDate);
		Integer s=getSecond(maxDate)-getMinute(minDate);
		m=s<0?m-1:m;
		s=s<0?s+60:s;
		h=m<0?h-1:h;
		m=m<0?m+60:m;
		d=h<0?d-1:d;
		h=h<0?h+24:h;
		return "相差"+d+"天"+h+"小时"+m+"分钟"+s+"秒";
	}
	/**
	 * 
	 * @param maxDate
	 * @param minDate
	 * @return
	 */
	public static String getSubTime(Date maxDate,Date minDate){
		Integer h=get24Hour(maxDate)-get24Hour(minDate);
		Integer m=getMinute(maxDate)-getMinute(minDate);
		Integer s=getSecond(maxDate)-getMinute(minDate);
		m=s<0?m-1:m;
		s=s<0?s+60:s;
		h=m<0?h-1:h;
		m=m<0?m+60:m;
		return "相差"+h+"小时"+m+"分钟"+s+"秒";
	}
}
