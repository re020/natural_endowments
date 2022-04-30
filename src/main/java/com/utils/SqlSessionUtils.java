package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    /*@Autowired
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        *//*String config = "mybatis_config.xml";*//*
        try {
            //InputStream in = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (sqlSession==null){
            sqlSession = sqlSessionFactory.openSession(true);
        }
        return sqlSession;
    }*/
}
