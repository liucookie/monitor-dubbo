package com.cast.serviceman.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    static Calendar cal = Calendar.getInstance();

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDate1() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
    /**
     * string转化成Date
     *
     * @param time
     * @return
     */
    public static Date getDateByString(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = format.parse(time);
        } catch (ParseException e) {
           e.printStackTrace();
        }
        return date;
    }



    /**
     * string转化成Date
     *
     * @param time
     * @return
     */
    public static Date getDateByString1(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = format.parse(time);
        } catch (ParseException e) {
           e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static int currentYear() {
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static int currentMonth() {
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取当前日
     *
     * @return
     */
    public static int currentDay() {
        int day = cal.get(Calendar.DATE);
        return day;
    }

    /**
     * * 计算连个日期之间相差的天数
     */
    public static  long betweenDays(String date, String now) {
        // 获取日期
        Date date1 = getDateByString1(date);
        Date date2 = getDateByString1(now);

        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(date2);
        long timeInMillis2 = calendar.getTimeInMillis();

        long betweenDays = (timeInMillis2 - timeInMillis1) / (1000L * 3600L * 24L);
        return  betweenDays;
    }


    /**
     * 获取上一个月的时间
     * @return
     */
    public static String getMonthBefore(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        Date m = cal.getTime();
        String mon = format.format(m);
        return mon;
    }

}
