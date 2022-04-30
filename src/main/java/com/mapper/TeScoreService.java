package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.pojo.AllScore;

@Mapper
public interface TeScoreService {

    int insertTeScore(AllScore as);
}
