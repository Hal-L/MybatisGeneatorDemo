package com.example.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 教师查询页面类
 */
@Data
public class TeacherQueryVO implements Serializable {

    private static final long serialVersionUID = 1696789814190373499L;

    @ApiModelProperty(value = "id", example = "1")
    private String id;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师", example = "1")
    private Integer level;

    @ApiModelProperty(value = "讲师姓名", example = "zhangsan")
    private String name;

    @NotBlank(message = "开始时间必填")
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String beginTime;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @NotBlank(message = "结束时间必填")
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String endTime;
}
