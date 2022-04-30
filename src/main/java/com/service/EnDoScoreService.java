package com.service;

import com.pojo.TeScore;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对教师初始评分进行赋分
 */
@Repository
public interface EnDoScoreService {

    List<TeScore> enDoScore(int classId, String acaYear, int seme);

}
