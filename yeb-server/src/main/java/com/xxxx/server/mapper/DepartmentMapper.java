package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Department;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-18
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> getAllDepartment(Integer parentId);

    void addDep(Department dep);

    void deleteDep(Department dep);
}
