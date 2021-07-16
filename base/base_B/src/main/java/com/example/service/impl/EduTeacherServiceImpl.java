package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.EduTeacher;
import com.example.entity.vo.TeacherQueryVO;
import com.example.mapper.EduTeacherMapper;
import com.example.dto.ResultDTO;
import com.example.service.IEduTeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 讲师 服务实现类
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements IEduTeacherService {

    @Resource
    EduTeacherMapper eduTeacherMapper;

    /**
     * 新增一个教师
     *
     * @param eduTeacher
     * @return
     */
    @Override
    public ResultDTO addTeacher(EduTeacher eduTeacher) {

        int insert = eduTeacherMapper.insert(eduTeacher);

        return ResultDTO.OK();
    }

    /**
     * 查询一个教师
     *
     * @param teacherQueryVO
     * @return
     */
    @Override
    public ResultDTO findTeacher(TeacherQueryVO teacherQueryVO) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<EduTeacher>();
        wrapper.eq("id", teacherQueryVO.getId());

        EduTeacher eduTeacher = eduTeacherMapper.selectOne(wrapper);
        return ResultDTO.OK(eduTeacher);

    }

    /**
     * 修改一个教师
     *
     * @return
     */
    @Override
    public ResultDTO updateTeacher(EduTeacher eduTeacher) {
        UpdateWrapper wrapper = new UpdateWrapper();
        eduTeacherMapper.update(eduTeacher, wrapper);
        return ResultDTO.OK();
    }

    /**
     * 删除一个教师
     *
     * @return
     */
    @Override
    public ResultDTO delTeacher(String id) {
        eduTeacherMapper.deleteById(id);
        return ResultDTO.OK();
    }
}
