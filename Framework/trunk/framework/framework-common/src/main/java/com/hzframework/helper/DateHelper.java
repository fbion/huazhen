package com.hzframework.helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by paul on 15-1-26.
 */
public class DateHelper {
    private static String defaultDatePattern = "yyyy-MM-dd";

    /**
     * Get the default date pattern
     */
    public static String getDatePattern()
    {
        return defaultDatePattern;
    }

    /**
     * Returns the default Format of the current date string
     */
    public static String getToday()
    {
        return format(getTodayDate());
    }

    public static Date getTodayDate()
    {
        java.util.Date today = new java.util.Date();
        return new Date(today.getTime());
    }

    /**
     * Use default Format to Format the Date into a string
     */
    public static String format(Date date)
    {
        return date == null ? " " : format(date, getDatePattern());
    }

    /**
     * Using parameter Format to Format the Date into a string
     */
    public static String format(Date date, String pattern)
    {
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);
    }

    /**
     * Use the default format string to a Date
     */
    public static Date parse(String strDate) throws ParseException
    {
        return StringHelper.isNullOrEmpty(strDate) ? null : parse(strDate,
                getDatePattern());
    }

    /**
     * Using parameter Format string to a Date
     */
    public static Date parse(String strDate, String pattern)
            throws ParseException
    {
        return StringHelper.isNullOrEmpty(strDate) ? null : new Date(new SimpleDateFormat(
                pattern).parse(strDate).getTime());
    }

    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp addMonth(Timestamp date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp addDay(Timestamp date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp addMinute(Timestamp date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp addSecond(Timestamp date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, n);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp addHour(Timestamp date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, n);
        return new Timestamp(cal.getTime().getTime());
    }

    /**
     * Add several month on the date
     */
    public static Date addMonth(Date date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return new Date(cal.getTime().getTime());
    }

    public static Date addDay(Date date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return new Date(cal.getTime().getTime());
    }

    public static java.util.Date addDay(java.util.Date date,int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return new java.util.Date(cal.getTime().getTime());
    }

    public static Date addMinute(Date date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return new Date(cal.getTime().getTime());
    }

    public static Date addSecond(Date date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, n);
        return new Date(cal.getTime().getTime());
    }

    public static Date addHour(Date date, int n)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, n);
        return new Date(cal.getTime().getTime());
    }

    public static String getLastDayOfMonth(String year, String month)
    {
        Calendar cal = Calendar.getInstance();
        // Year
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        // Month, because in a Calendar month from 0, so want to -1
        // cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        // Day，set to 1
        cal.set(Calendar.DATE, 1);
        // Month plus one, get the frist day of next month 
        cal.add(Calendar.MONTH, 1);
        // The next month minus one for the last day of this month
        cal.add(Calendar.DATE, -1);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// get the date of the end of this month
    }

    public static Date getDate(String year, String month, String day)
            throws ParseException
    {
        String result = year + "- "
                + (month.length() == 1 ? ("0 " + month) : month) + "- "
                + (day.length() == 1 ? ("0 " + day) : day);
        return parse(result);
    }

    public static Date getMinValue(){
        return new Date(0);
    }

    public static Date getMaxValue(){
        return new Date(9223372036854775807L);
    }

    /**
     * 计算两个日期之间相差的天数
     * @param startDate 较小的时间
     * @param endDate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(java.util.Date startDate,java.util.Date endDate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        startDate=sdf.parse(sdf.format(startDate));
        endDate=sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long startTime = cal.getTimeInMillis();
        cal.setTime(endDate);
        long endTime = cal.getTimeInMillis();
        long between_days=(endTime-startTime)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期字符串之间相差的天数
     * @param startStr 较小的时间字符串
     * @param endStr  较大的时间字符串
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(String startStr,String endStr) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(startStr));
        long startTime = cal.getTimeInMillis();
        cal.setTime(sdf.parse(endStr));
        long endTime = cal.getTimeInMillis();
        long between_days=(endTime-startTime)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *得到添加月份后的第一天
     * @param addMonth 添加的月份数
     * @return 该月第一天
     * @throws ParseException
     */
    public static java.util.Date getNextMonthFirst(int addMonth) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,addMonth);
        calendar.set(Calendar.DATE, 1);
        java.util.Date nextMonthFirstDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return DateHelper.parse(sdf.format(nextMonthFirstDate));
    }

    public static java.util.Date getNextMonthFirst(java.util.Date date,int addMonth) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,addMonth);
        calendar.set(Calendar.DATE, 1);
        java.util.Date nextMonthFirstDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return DateHelper.parse(sdf.format(nextMonthFirstDate));
    }

    /**
     * 得到两个日期之间的月数
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static int getMonthSpace(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(start));
        c2.setTime(sdf.parse(end));
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        if(year > 0){
            month = month + year*12;
        }
        return month == 0 ? 1 : Math.abs(month);
    }
    public static int getMonthSpace(java.util.Date start, java.util.Date end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(start);
        c2.setTime(end);
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        if(year > 0){
            month = month + year*12;
        }
        return month == 0 ? 1 : Math.abs(month);
    }

}
