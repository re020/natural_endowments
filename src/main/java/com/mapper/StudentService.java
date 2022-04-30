package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.pojo.ClassTeacher;
import com.pojo.Teacher;

import java.util.List;

@Mapper
public interface StudentService {

    List<ClassTeacher> selectTe(int classId);

    Teacher selectTeName(int teId);

}
