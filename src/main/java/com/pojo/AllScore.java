package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 所有学生打分表
 */
@Data
@Component
public class AllScore {

    private int asId;

    //班级id
    private int classId;

    //教师id
    private int teId;

    //学生id
    private int stuId;

    //教师的评分
    private BigDecimal teScore;

    //学年
    private String acaYear;

    //学期
    private int seme;
}
