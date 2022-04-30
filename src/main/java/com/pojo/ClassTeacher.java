package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 班级教师表
 */
@Data
@Component
public class ClassTeacher {

    private int ctId;

    //教师所教班级id
    private int classId;

    //教师id
    private int teId;

    //教师名字
    private String teName;

    //学科
    private String subject;

    //学年
    private String acaYear;

    //学期
    private int seme;

}
