package com.yundao.tenant.web.util;

import com.yundao.tenant.web.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类单元测试
 */
public class DateUtilsTest extends AbstractTest {


    @Test
    public void cool() throws Exception {
        post("/pro", null);
    }

    @Test
    public void formatExactMinute() throws Exception {
        String strDate = "2017-08-08 18:30:10";
        String result = DateUtils.formatExactMinute(strDate);
        Assert.assertEquals("2017-08-08 18:30", result);
    }

    @Test
    public void formatExactMinute1() throws Exception {
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDate = dateFormat2.parse("2017-08-08 18:30:12");
        String myDateStr = DateUtils.formatExactMinute(myDate);
        Assert.assertEquals("2017-08-08 18:30", myDateStr);
    }

    @Test
    public void formatExactDay() throws Exception {
        String strDate = "2017-08-08 18:30:10";
        String result = DateUtils.formatExactDay(strDate);
        Assert.assertEquals("2017-08-08", result);
    }

    @Test
    public void formatExactDay1() throws Exception {
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDate = dateFormat2.parse("2017-08-08 18:30:12");
        String myDateStr = DateUtils.formatExactDay(myDate);
        Assert.assertEquals("2017-08-08", myDateStr);
    }

    @Test
    public void toEndDate() throws Exception {
        String endDateStr = "2017-08-08";
        String dateStr = DateUtils.toEndDate(endDateStr);
        Assert.assertEquals("2017-08-08 23:59:59", dateStr);
    }

    @Test
    public void isExpire() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置过期时间
        Date myDate = dateFormat.parse("2017-11-26 00:00:00");
        boolean expire = DateUtils.isExpire(myDate);
        Assert.assertTrue(expire); //断言为已过期


        //设置过期时间
        Date myDate2 = dateFormat.parse("2017-11-27 00:00:00");
        boolean expire2 = DateUtils.isExpire(myDate2);
        Assert.assertFalse(expire2);//断言为未过期

        //设置过期时间
        Date myDate3 = dateFormat.parse("2017-11-28 00:00:00");
        boolean expire3 = DateUtils.isExpire(myDate3);
        Assert.assertFalse(expire3);//断言为未过期

    }

}