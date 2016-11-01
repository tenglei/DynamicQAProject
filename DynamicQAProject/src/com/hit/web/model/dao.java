package com.hit.web.model;

import org.apache.ibatis.session.SqlSession;

public class dao {
    public static User user(){
	DBAcess dbAcess = new DBAcess();
	SqlSession sqlSession = null;
	sqlSession = dbAcess.getSqlSession();
	
    }
}
;