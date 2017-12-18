package com.yundao.tenant.web.enums.access;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据对象权限枚举
 *
 * @author jan
 * @create 2017-07-13 PM4:33
 **/
public enum DataObjectPermissionEnum {

    /**
     * 无权限
     */
    NONE(0, "无权限","您无操作公告的权限"),

    /**
     * 我的，个人的
     */
    PERSONAL(10, "我的","您的权限仅限于操作您创建的公告"),

    /**
     * 团队
     */
    TEAM(20, "团队","您的权限仅限于操作您团队员工创建的公告"),

    /**
     * 部门
     */
    DEPARTMENT(30, "部门","您的权限仅限于操作您部门员工创建的公告"),

    /**
     * 全部
     */
    PUBLIC(40, "全部","您可以操作所有公告权限");

    private Integer value;
    private String name;
    private String notCanPermission;
    private static Map<Integer, DataObjectPermissionEnum> enumMap = new HashMap<>();

    static {
        EnumSet<DataObjectPermissionEnum> set = EnumSet.allOf(DataObjectPermissionEnum.class);
        for (DataObjectPermissionEnum each : set) {
            enumMap.put(each.getValue(), each);
        }
    }

    DataObjectPermissionEnum(Integer value, String name,String notCanPermission) {
        this.value = value;
        this.name = name;
        this.notCanPermission = notCanPermission;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取枚举
     */
    public static DataObjectPermissionEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return enumMap.get(value);
    }

    /**
     * 根据value 获取name
     */
    public static String getEnumName(Integer value) {
        DataObjectPermissionEnum enumItem = getEnum(value);
        if (enumItem == null)
            return null;
        return enumItem.getName();
    }

    public String getNotCanPermission() {
        return notCanPermission;
    }

    public void setNotCanPermission(String notCanPermission) {
        this.notCanPermission = notCanPermission;
    }
}
