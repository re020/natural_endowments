package com.service.impl;

import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.pojo.TeScore;
import com.service.EnDoScoreService;
import com.mapper.FinalScoreService;
import com.utils.SqlSessionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;



@Service
public class EnDoScoreServiceImpl extends SqlSessionDaoSupport implements EnDoScoreService {

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<TeScore> enDoScore(int classId, String acaYear, int seme) {

        //SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //SqlSession sqlSession = getSqlSession();
        FinalScoreService mapper = sqlSession.getMapper(FinalScoreService.class);
        List<TeScore> teScores = mapper.selectTeScoreByClassId(classId,acaYear,seme);

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

        return teScores;
    }

}
