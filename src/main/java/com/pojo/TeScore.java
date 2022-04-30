package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class TeScore {

    private int tsId;

    //班级id
    private int classId;

    //学院id
    private int collegeId;

    //教师id
    private int teId;

    //教师得分
    private BigDecimal teScore;

    //学年
    private String acaYear;

    //学期
    private int seme;

}
