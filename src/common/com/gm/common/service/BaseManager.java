package com.gm.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.orm.mybatis.BaseEntity;
import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;

@Transactional
public abstract class BaseManager<T extends BaseEntity, PK extends Serializable> implements Manager<T, PK> {

	public abstract EntityDao<T, PK> getEntityDao();

	@Transactional(readOnly = true)
	public T getById(PK id) throws DataAccessException {
		return (T) getEntityDao().getById(id);
	}

	@Transactional(readOnly = true)
	public List<T> findAll() throws DataAccessException {
		return (List<T>) getEntityDao().findAll();
	}

	/** 根据id检查是否插入或是更新数据 */
	public void saveOrUpdate(T entity) throws DataAccessException {
		getEntityDao().saveOrUpdate(entity);
	}

	/** 插入数据 */
	public void save(T entity) throws DataAccessException {
		getEntityDao().save(entity);
	}

	public void removeById(PK id) throws DataAccessException {
		getEntityDao().deleteById(id);
	}

	public void removeByIds(PK[] ids) throws DataAccessException {
		getEntityDao().deleteByIds(ids);
	}

	public void update(T entity) throws DataAccessException {
		getEntityDao().update(entity);
	}

	@Transactional(readOnly = true)
	public Page<T> findPage(QueryRequest pr) {
		return getEntityDao().findPage(pr);
	}

}
