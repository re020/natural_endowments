package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 学院教师得分表
 */
@Data
@Component
public class CollegeScore {

    private int csId;

    //学院id
    private int collegeId;

    //教师id
    private int teId;

    //教师的评分
    private BigDecimal teScore;

    //学年
    private String acaYear;

    //学期
    private int seme;
}
