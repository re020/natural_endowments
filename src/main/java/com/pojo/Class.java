package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *班级表
 */

@Data
@Component
public class Class {

    //班级id
    private int classId;

    //班级名称
    private String className;

    //学院id
    private int collegeId;
}
