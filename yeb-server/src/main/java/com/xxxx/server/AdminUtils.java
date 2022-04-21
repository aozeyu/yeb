package com.xxxx.server;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @program: yeb
 * @description: 操作员工具类
 * @packagename: com.xxxx.server
 * @author: 姚泽宇
 * @date: 2022-04-21 09:57
 **/
public class AdminUtils {
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
