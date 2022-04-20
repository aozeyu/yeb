package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-18
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartment();

    RespBean addDep(Department dep);

    RespBean deleteDep(Integer id);
}
