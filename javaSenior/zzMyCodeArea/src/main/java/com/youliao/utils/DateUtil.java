package com.youliao.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2023/7/31 14:46
 * @Description:
 */
public final class DateUtil {

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

}
