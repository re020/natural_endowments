package stuTest;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.pojo.AllScore;
import com.pojo.ClassTeacher;
import com.pojo.Teacher;
import com.mapper.StudentService;
import com.mapper.TeScoreService;
import com.utils.SqlSessionUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ClsTeTest {

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Test
    public void test1(){

        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentService studentService = sqlSession.getMapper(StudentService.class);
        List<ClassTeacher> classTeachers = studentService.selectTe(1);
        Map<String,String> teNames = new HashMap<>();
        for (ClassTeacher classTeacher : classTeachers) {
            System.out.println("clte:"+classTeacher);
            Teacher teacher = studentService.selectTeName(classTeacher.getTeId());
            teNames.put(teacher.getTeName(),classTeacher.getSubject());
        }
        Set<String> strings = teNames.keySet();
        for (String string : strings) {
            System.out.println(string+":"+teNames.get(string));
        }
        sqlSession.close();

    }

    @Test
    public void test2(){

        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentService studentService = sqlSession.getMapper(StudentService.class);
        List<ClassTeacher> classTeachers = studentService.selectTe(1);
        for (ClassTeacher classTeacher : classTeachers) {

            Teacher teacher = studentService.selectTeName(classTeacher.getTeId());
            classTeacher.setTeName(teacher.getTeName());

            System.out.println("clte:"+classTeacher);
        }
        sqlSession.close();
    }


    @Test
    public void test3(){
        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeScoreService mapper = sqlSession.getMapper(TeScoreService.class);
        AllScore as = new AllScore();
        as.setAsId(1);
        as.setAcaYear("2021-2022");
        as.setClassId(1);
        as.setSeme(1);
        as.setStuId(1);
        as.setTeId(1);
        BigDecimal a = new BigDecimal("98");
        as.setTeScore(a);
        int b = mapper.insertTeScore(as);
        System.out.println(b);

    }
}
