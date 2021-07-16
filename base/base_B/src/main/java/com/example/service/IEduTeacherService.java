package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dto.ResultDTO;
import com.example.entity.EduTeacher;
import com.example.entity.vo.TeacherQueryVO;

/**
 * 讲师 服务类
 */
public interface IEduTeacherService extends IService<EduTeacher> {

    /**
     * 新增一个教师
     *
     * @param eduTeacher
     * @return
     */
    ResultDTO addTeacher(EduTeacher eduTeacher);

    /**
     * 查询一个教师
     *
     * @param teacherQueryVO
     * @return
     */
    ResultDTO findTeacher(TeacherQueryVO teacherQueryVO);

    /**
     * 修改一个教师
     *
     * @return
     */
    ResultDTO updateTeacher(EduTeacher eduTeacher);

    /**
     * 删除一个教师
     *
     * @return
     */
    ResultDTO delTeacher(String id);
}
