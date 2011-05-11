package com.gm.common.orm.mybatis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;

import com.gm.common.context.SpringValidatorHolder;
import com.gm.common.exception.ExceptionHandler;
import com.gm.common.utils.PropertyUtils;

public abstract class BaseEntityDao<T extends BaseEntity, PK extends Serializable> extends SqlSessionDaoSupport
		implements EntityDao<T, PK> {
	// protected final Log log = LogFactory.getLog(getClass()); //common-logger
	/**
	 * @uml.property  name="log"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	protected final Logger log = Logger.getLogger(getClass());

	/**
	 * @uml.property  name="sqlSessionFactory"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Resource
	private SqlSessionFactory sqlSessionFactory;

	protected void checkDaoConfig() throws IllegalArgumentException {
		Assert.notNull(sqlSessionFactory, "sqlSessionFactory must be not null");
	}

	/**
	 * @return
	 * @uml.property  name="sqlSessionFactory"
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/**
	 * @uml.property  name="sqlSessionTemplate"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * @return
	 * @uml.property  name="sqlSessionTemplate"
	 */
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	@SuppressWarnings("unchecked")
	public T getById(PK primaryKey) {
		T object = (T) getSqlSession().selectOne(getFindByPrimaryKeyStatement(), primaryKey);
		return object;
	}

	@SuppressWarnings("unchecked")
	public T findUnique(Object param) {
		return (T) getSqlSession().selectOne(getFindStatement(), param);
	}

	public Long getCount() {
		return (Long) getSqlSession().selectOne(getCountStatement());
	}

	public Long getCount(Object filters) {
		return (Long) getSqlSession().selectOne(getCountStatement(), filters);
	}

	public void deleteById(PK id) {
		getSqlSession().delete(getDeleteStatement(), id);
	}

	public void deleteByIds(PK[] ids) {
		if (ids != null && ids.length != 0)
			getSqlSession().delete(getDeleteIdsStatement(), ids);
	}

	@SuppressWarnings("unchecked")
	public void delete(T entity) {
		deleteById((PK) entity.getPkValue());
	}

	public void save(T entity) {
		prepareObjectForSaveOrUpdate(entity);
		getSqlSession().insert(getInsertStatement(), entity);
	}

	public void update(T entity) {
		prepareObjectForSaveOrUpdate(entity);
		getSqlSession().update(getUpdateStatement(), entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String... sortConditions) {
		if (sortConditions == null) {
			return (List<T>) getSqlSession().selectList(getFindAllStatement());
		} else {
			Map<String, Object> param = new HashMap<String, Object>();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sortConditions.length; i++) {
				sb.append(sortConditions[i]);
				if (sortConditions.length - 1 != i)
					sb.append(",");
			}
			param.put("sortColumns", sb.toString());
			return (List<T>) getSqlSession().selectList(getFindAllStatement(), param);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> find(Object filter, String... sortConditions) {
		if (sortConditions == null) {
			return (List<T>) getSqlSession().selectList(getFindAllStatement());
		} else {
			Map<String, Object> param = new HashMap<String, Object>();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < sortConditions.length; i++) {
				sb.append(sortConditions[i]);
				if (sortConditions.length - 1 != i)
					sb.append(",");
			}
			param.put("sortColumns", sb.toString());
			Map parameterObject = PropertyUtils.describe(filter);
			param.putAll(parameterObject);
			List<T> list = getSqlSession().selectList(getFindStatement(), param);
			return list;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> find(QueryRequest queryRequest) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sortColumns", queryRequest.getSortColumns());
		Map parameterObject = PropertyUtils.describe(queryRequest.getFilters());
		param.putAll(parameterObject);
		List<T> list = getSqlSession().selectList(getFindStatement(), param);
		return list;
	}

	@SuppressWarnings("unchecked")
	public Page<T> findPage(QueryRequest queryRequest) {
		return pageQuery(getSqlSession(), getFindPageStatement(), getCountStatement(), queryRequest);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Page pageQuery(SqlSession sqlSession, String statementName, String countStatementName,
			QueryRequest queryRequest) {
		Map paramc = new HashMap();
		paramc.put("conditions", queryRequest.getConditions());
		if (queryRequest.getFilters() != null) {
			if (queryRequest.getFilters() instanceof Map) {
				paramc.putAll((Map) queryRequest.getFilters());
			} else {
				paramc.putAll(PropertyUtils.describe(queryRequest.getFilters()));
			}
		}
		Number totalCount = (Number) sqlSession.selectOne(countStatementName, paramc);
		if (totalCount == null || totalCount.longValue() <= 0) {
			return new Page(queryRequest, 0);
		}
		Page page = new Page(queryRequest, totalCount.intValue());
		// 其它分页参数
		// 与getSqlSession().queryForList(statementName, parameterObject)配合使用
		Map param = new HashMap();
		param.put("offset", page.getFirstResult());
		param.put("pageSize", page.getPageSize());
		param.put("lastRows", page.getFirstResult() + page.getPageSize());
		param.put("sortColumns", queryRequest.getSortColumns());
		param.put("conditions", queryRequest.getConditions());
		if (queryRequest.getFilters() != null) {
			if (queryRequest.getFilters() instanceof Map) {
				param.putAll((Map) queryRequest.getFilters());
			} else {
				param.putAll(PropertyUtils.describe(queryRequest.getFilters()));
			}
		}
		List list = sqlSession.selectList(statementName, param,
				new RowBounds(page.getFirstResult(), page.getPageSize()));
		page.setResult(list);
		return page;
	}

	/**
	 * 用于子类覆盖,在insert,update之前调用
	 */
	protected void prepareObjectForSaveOrUpdate(T o) {
		try {
			SpringValidatorHolder.validate(o);
		} catch (BindException e) {
			String msg = SpringValidatorHolder.getErrorMessage(e);
			throw new RuntimeException(msg);
		}
	}

	public String getMybatisMapperNamesapce() {
		throw new ExceptionHandler("Not yet implement");
	}

	public String getFindByPrimaryKeyStatement() {
		return getMybatisMapperNamesapce() + ".getById";
	}

	public String getInsertStatement() {
		return getMybatisMapperNamesapce() + ".insert";
	}

	public String getUpdateStatement() {
		return getMybatisMapperNamesapce() + ".update";
	}

	public String getDeleteStatement() {
		return getMybatisMapperNamesapce() + ".delete";
	}

	public String getDeleteIdsStatement() {
		return getMybatisMapperNamesapce() + ".deleteIds";
	}

	private String getFindStatement() {
		return getMybatisMapperNamesapce() + ".find";
	}

	private String getFindPageStatement() {
		return getMybatisMapperNamesapce() + ".findPage";
	}

	private String getFindAllStatement() {
		return getMybatisMapperNamesapce() + ".findAll";
	}

	public String getCountStatement() {
		return getMybatisMapperNamesapce() + ".count";
	}

	public void flush() {
		// ignore
	}

}
