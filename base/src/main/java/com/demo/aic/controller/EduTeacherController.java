package com.demo.aic.controller;


import com.demo.aic.entity.EduTeacher;
import com.demo.aic.entity.vo.TeacherQueryVO;
import com.demo.aic.pojo.dto.ResultDTO;
import com.demo.aic.service.IEduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 讲师 前端控制器
 */
@RestController
@RequestMapping("/edu")
@Api(tags = "讲师管理")
public class EduTeacherController {


    @Autowired
    IEduTeacherService eduTeacherService;

    /**
     * 新增一个教师
     *
     * @param eduTeacher
     * @return
     */
    @PostMapping("/teacher")
    @ApiOperation(value = "增加讲师")
    ResultDTO addTeacher(@RequestBody @Validated EduTeacher eduTeacher) {
        return eduTeacherService.addTeacher(eduTeacher);
    }

    /**
     * 查询一个教师
     *
     * @param teacherQueryVO
     * @return
     */
    @GetMapping("/teacher")
    @ApiOperation(value = "查询一个教师")
    ResultDTO findTeacher(@Validated TeacherQueryVO teacherQueryVO) {

        return eduTeacherService.findTeacher(teacherQueryVO);
    }
}

