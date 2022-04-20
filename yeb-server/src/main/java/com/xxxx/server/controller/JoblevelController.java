package com.xxxx.server.controller;


import com.xxxx.server.pojo.Joblevel;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels() {
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel jobLevel) {
        jobLevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(jobLevel)) {
            return RespBean.success("添加成功 !");
        }
        return RespBean.error("添加失败 !");
    }

    @ApiOperation(value = "更新职位")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel jobLevel) {
        jobLevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.updateById(jobLevel)) {
            return RespBean.success("更新成功 !");
        }
        return RespBean.error("更新失败 !");
    }

    @ApiOperation(value = "删除职位")
    @PutMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {

        if (joblevelService.removeById(id)) {
            return RespBean.success("删除成功 !");
        }
        return RespBean.error("删除失败 !");
    }
}
