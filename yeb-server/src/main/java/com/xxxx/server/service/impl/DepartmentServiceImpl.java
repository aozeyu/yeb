package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2022-04-18
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
//    service里面调用数据层
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment(-1);
    }

    @Override
    public RespBean addDep(Department dep) {
       dep.setEnabled(true);
       departmentMapper.addDep(dep);
       if (1 == dep.getResult()) {
           return RespBean.success("添加成功 !", dep);
       }
       return RespBean.error("添加失败 !");
    }

    @Override
    public RespBean deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if (-2 == dep.getResult()){
            return RespBean.error("该部分下还有子部门,删除失败!");
        }
        if (-1 == dep.getResult()){
            return RespBean.error("该部分下还有员工,删除失败!");
        }
        if (1 == dep.getResult()) {
            return RespBean.success("删除成功!");
        }
         return RespBean.error("删除失败!");
    }


}
