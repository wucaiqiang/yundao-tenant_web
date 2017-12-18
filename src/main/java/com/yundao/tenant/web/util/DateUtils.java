package com.yundao.tenant.web.util;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author jan
 * @create 2017-08-08 PM8:22
 **/
public class DateUtils {

    private static Log log = LogFactory.getLog(DateUtils.class);

    /**
     * 将字符串格式的日期，转换为精确到分钟的格式：YYYY_MM_DD_HH_MM
     *
     * @param strDate 日期
     */
    public static String formatExactMinute(String strDate) {
        return fetchDate(strDate, ":");
    }

    /**
     * 将日期，转换为精确到分钟的格式：YYYY_MM_DD_HH_MM
     *
     * @param date 日期
     */
    public static String formatExactMinute(Date date) {
        if (date == null)
            return null;
        return com.yundao.core.utils.DateUtils.format(date, com.yundao.core.utils.DateUtils.YYYY_MM_DD_HH_MM);
    }

    /**
     * 将字符串格式的日期，转换为精确到日的格式：YYYY_MM_DD
     *
     * @param strDate 日期
     */
    public static String formatExactDay(String strDate) {
        return fetchDate(strDate, " ");
    }

    /**
     * 将日期，转换为精确到日的格式：YYYY_MM_DD
     *
     * @param date 日期
     */
    public static String formatExactDay(Date date) {
        if (date == null)
            return null;
        return com.yundao.core.utils.DateUtils.format(date, com.yundao.core.utils.DateUtils.YYYY_MM_DD);
    }

    /**
     * 将YYYY_MM_DD 格式日期 加上23:59:59
     *
     * @param strDate 日期
     */
    public static String toEndDate(String strDate) {
        if (BooleanUtils.isBlank(strDate))
            return strDate;
        boolean validDate = com.yundao.core.utils.DateUtils.isValidDate(strDate, com.yundao.core.utils.DateUtils.YYYY_MM_DD);
        if (!validDate)
            return strDate;
        if (strDate.contains(":"))
            return strDate;
        return strDate.trim() + " " + com.yundao.core.utils.DateUtils.DAY_END;
    }

    /**
     * 将YYYY_MM_DD 格式日期 加上23:59:59
     *
     * @param endDate 日期
     */
    public static Date toEndDate(Date endDate) {
        if (endDate == null)
            return endDate;
        try {
            return com.yundao.core.utils.DateUtils.parse(com.yundao.core.utils.DateUtils.getDateEnd(endDate), com.yundao.core.utils.DateUtils.YYYY_MM_DD_HH_MM_SS);
        } catch (Exception e) {
            log.error("DateUtils.toEndDate 异常：%s", e.toString());
        }
        return null;
    }

    private static String fetchDate(String strDate, String splitSymbol) {
        if (BooleanUtils.isEmpty(strDate))
            return strDate;
        strDate = strDate.trim();
        int index = strDate.lastIndexOf(splitSymbol);
        return strDate.substring(0, index);
    }

    public static boolean isExpire(Date date) throws BaseException {
        if (null == date) {
            log.info("租户合同过期时间为空");
            return false;
        }
        try {
            String formatDate = com.yundao.core.utils.DateUtils.getDateEnd(date);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date newDate = df.parse(formatDate);
            return newDate.before(new Date());
        } catch (Exception ex) {
            log.error("DateUtils.isExpire 异常：%s", ex.toString());
        }
        return false;
    }
}
