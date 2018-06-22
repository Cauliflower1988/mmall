package com.mmall.common;

/**
 * @Author: Geekerstar(jikewenku.com)
 * @Date: 2018/6/22 10:33
 * @Description:
 */
public class Const {
    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员
    }
}
