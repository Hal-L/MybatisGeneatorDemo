package com.demo.aic;

import com.demo.aic.entity.EduTeacher;
import com.demo.aic.entity.vo.TeacherQueryVO;
import com.demo.aic.pojo.dto.ResultDTO;
import com.demo.aic.service.IEduTeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AicApplicationTests {

    @Autowired
    IEduTeacherService eduTeacherService;

    @Test
    void findTeacher() {
        TeacherQueryVO teacherQueryVO = new TeacherQueryVO();
        teacherQueryVO.setId("1");
        ResultDTO teacher = eduTeacherService.findTeacher(teacherQueryVO);
        System.out.println(teacher.getData());
    }

    @Test
    void addTeacher() {
        EduTeacher eduTeacher = new EduTeacher();
        eduTeacher.setName("张三");
        eduTeacher.setIntro("java高级开发");
        eduTeacher.setCareer("牛逼卡拉斯");
        eduTeacher.setLevel(1);
        eduTeacher.setAvatar("讲师头像");
        eduTeacher.setSort(1);
        eduTeacher.setIsDeleted(true);
        eduTeacher.setGmtCreate(new Date());
        eduTeacher.setGmtModified(new Date());

        eduTeacherService.save(eduTeacher);
    }


}
