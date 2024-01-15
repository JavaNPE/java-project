package com.youliao.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/7/31 14:46
 * @Description:
 */
public final class DateUtil {

    public static final String DATE_FORMAT_2 = "yyyyMMdd";


    /**
     * 获取某一天的0时0分0秒时间
     *
     * @param dt 某个时间
     * @return 某一天的0时0分0秒时间
     */
    public static Date getStartTimeOfDay(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(dt);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }

    /**
     * 获取某一天的23时59分59秒999毫秒时间
     *
     * @param dt 某个时间
     * @return 某一天的23时59分59秒999毫秒时间
     */
    public static Date getEndTimeOfDay(Date dt) {
        if (dt == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(dt);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);
        return instance.getTime();
    }

    /**
     * 根据date计算years后的时间
     *
     * @param now  当期时间
     * @param year 要加的年数
     * @return
     */
    public static Date dateAddYear(Date now, int year) {
        return offsetYear(now, year);
    }

    /**
     * 根据date计算years后的时间
     *
     * @param date  日期
     * @param years 要计算的年数
     * @return Date 计算后的时间
     */
    public static Date offsetYear(Date date, int years) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date addDate(Date date, long day) {
        return dateAddDay(date, (int) day);
    }

    /**
     * 日期加上多少天后的日期
     * @param now 当前时间
     * @param day 要加的天数
     * @return
     */
    public static Date dateAddDay(Date now, int day) {
        return offsetDay(now, day);
    }

    /**
     * 根据date 计算 days后的时间
     * @param date 当前时间
     * @param days 要计算的天数
     * @return
     */
    public static Date offsetDay(Date date, int days) {
        return offsetHour(date, 24L * days);
    }

    /**
     * 根据date 计算 days后的时间
     * @param date 当前时间
     * @param hours 要计算的小时数
     * @return
     */
    public static Date offsetHour(Date date, long hours) {
        return offsetMinute(date, 60 * hours);
    }

    /**
     * 根据date 计算 days后的时间
     * @param date 当前时间
     * @param minutes 要计算的分钟数
     * @return
     */
    public static Date offsetMinute(Date date, long minutes) {
        return offsetSecond(date, 60 * minutes);
    }

    /**
     * 根据date 计算seconds后的时间
     * @param date 当前时间
     * @param seconds 秒数
     * @return
     */
    public static Date offsetSecond(Date date, long seconds) {
        if (date == null) {
            return null;
        }
        long time = date.getTime();
        long time2 = time + (seconds * 1000);
        long time3 = time + (seconds * 1000) - 60 * 60 * 1000;
        Date date2 = new Date(time2);
        Date date3 = new Date(time3);
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        Calendar calendarDate2 = Calendar.getInstance();
        calendarDate2.setTime(date2);
        Calendar calendarDate3 = Calendar.getInstance();
        calendarDate3.setTime(date3);

        long dstDate = calendarDate.get(Calendar.DST_OFFSET);
        long dstDate2 = calendarDate2.get(Calendar.DST_OFFSET);
        long dstDate3 = calendarDate3.get(Calendar.DST_OFFSET);

        long dstOffset = dstDate - dstDate2;
        // 前后两个日期便宜相同（含不偏移）或者夏令日开始的那个小时不用补偿，否则要补偿偏移量。
        boolean isNeedReset = dstOffset == 0 || (dstDate2 - dstDate3 != 0 && dstDate2 != 0);
        if (!isNeedReset) {
            return date2;
        } else {
            return new Date(time2 + dstOffset);
        }
    }

    /**
     * String 类型时间按照一定格式，格式化为Date类型
     * @param dateStr String 类型时间
     * @param pattern 格式
     * @return
     */
    public static Date getDate(String dateStr, String pattern) {
        if (DateUtil.isDateTime(dateStr, pattern)) {
            // 日期类型
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {
                return df.parse(dateStr);
            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    /**
     * 判断字符串是否日期时间格式
     * @param str 时间字符串
     * @param pattern 格式
     * @return true 是日期格式，false 不是日期格式
     */
    private static boolean isDateTime(String str, String pattern) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期， 注意yyyy/MM/dd 区分大小写
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置 lenient 为false, 否则 SimpleDateFormat 会 比较宽松地验证日期，比如2007/02/29 会被接受，并转换成为 2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

}
