package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.pojo.TeScore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface FinalScoreService {

    List<TeScore> selectTeScoreByClassId(@Param("classId") int classId, @Param("acaYear") String acaYear, @Param("seme") int seme);

    Integer insert(TeScore ts);
}
