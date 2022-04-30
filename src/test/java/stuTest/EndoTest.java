package stuTest;

import com.service.impl.EnDoScoreServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import com.pojo.TeScore;
import com.service.EnDoScoreService;
import com.mapper.FinalScoreService;
import com.utils.SqlSessionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;


public class EndoTest{

   /* @Autowired
    public EnDoScoreService enDoScoreService;*/

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Test
    public void test1(){

        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        FinalScoreService mapper = sqlSession.getMapper(FinalScoreService.class);
        List<TeScore> teScores = mapper.selectTeScoreByClassId(55,"2021-2022",1);

        for (TeScore teScore : teScores) {

            System.out.println(teScore);

        }
        teScores.sort(Comparator.comparing(TeScore::getTeScore).reversed());

        //获取原始分区间
        BigDecimal x1 = new BigDecimal("1");
        BigDecimal x2 = new BigDecimal("1");
        BigDecimal max = teScores.get(0).getTeScore().add(x1);
        BigDecimal min = teScores.get(teScores.size()-1).getTeScore().subtract(x2);
        System.out.println("max:"+max+"min:"+min);

        //设置赋分区间
        BigDecimal fmax = new BigDecimal("100");
        BigDecimal fmin = new BigDecimal("98");

        //给每个教师赋分
        for (int i = 0; i < teScores.size(); i++) {

            BigDecimal score = teScores.get(i).getTeScore();

            //BigDecimal a = fmax*(score-min)+fmin*(max-score);
            BigDecimal a = fmax.multiply(score.subtract(min)).add(fmin.multiply(max.subtract(score)));
            //BigDecimal b = a/(max-min);
            BigDecimal b = a.divide(max.subtract(min),2);

            BigDecimal finalScore = b.setScale(2, RoundingMode.HALF_DOWN);

            teScores.get(i).setTeScore(finalScore);
        }
        for (TeScore teScore : teScores) {

            System.out.println(teScore);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){

        EnDoScoreService enDoScoreService = new EnDoScoreServiceImpl();

        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        FinalScoreService mapper = sqlSession.getMapper(FinalScoreService.class);
        List<TeScore> teScores = enDoScoreService.enDoScore(55, "2021-2022", 1);
        for (TeScore teScore : teScores) {
            Integer insert = mapper.insert(teScore);
            System.out.println(insert);
        }
        sqlSession.close();
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        EnDoScoreService enDoScoreService = (EnDoScoreService) context.getBean("enDoScoreService");
        List<TeScore> teScores = enDoScoreService.enDoScore(55, "2021-2022", 1);
        for (TeScore teScore : teScores) {
            System.out.println(teScore);
        }

    }
}
