package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-18
 */
public interface IAdminService extends IService<Admin> {
    RespBean login( String username, String password, String code,HttpServletRequest request);

    Admin getAdminByUserName(String username);

    List<Role> getRoles(Integer adminId);

}
