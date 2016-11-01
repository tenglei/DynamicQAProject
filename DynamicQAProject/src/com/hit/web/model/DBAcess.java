package com.hit.web.model;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAcess {
    public SqlSession getSqlSession(){
	    try {
		Reader reader;
		reader = Resources.getResourceAsReader("com/hit/web/config/Configuration.xml");
		SqlSessionFactory sqlSessioonFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessioonFactory.openSession();
		return sqlSession;
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    return null;
       }
}
