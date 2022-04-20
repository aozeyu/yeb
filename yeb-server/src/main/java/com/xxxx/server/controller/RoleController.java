package com.xxxx.server.controller;


import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IMenuService;
import com.xxxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getRoleList() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }

        if (roleService.save(role)) {
            return RespBean.success("添加成功 !");
        } else {
            return RespBean.error("添加失败 !");
        }
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return RespBean.success("删除成功 !");
        } else {
            return RespBean.error("删除失败 !");
        }
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus () {
        return menuService.getAllMenus();
    }
}
