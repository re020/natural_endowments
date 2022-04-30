package com.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 学院表
 */

@Data
@Component
public class College {

    //学院id
    private int collegeId;

    //学院名称
    private String collegeName;

}
