package com.gm.common.orm.mybatis;

import org.apache.ibatis.session.SqlSession;

public interface SqlSessionCallback {
	public Object doInSqlSession(SqlSession session);
}
