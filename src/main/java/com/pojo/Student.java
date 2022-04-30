package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 学生表
 */
@Data
@Component
public class Student {

    //id
    private int stuId;

    //学号
    private String stuNum;

    //学生姓名
    private String stuName;

    //密码
    private String passWd;

    //班级id
    private int classId;


}
