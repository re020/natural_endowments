package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 教师表
 */
@Data
@Component
public class Teacher {

    //教师id
    private int teId;

    //工号
    private String teNum;

    //教师姓名
    private String teName;

    //密码
    private String passWd;

    //学院id
    private int collegeId;


}
