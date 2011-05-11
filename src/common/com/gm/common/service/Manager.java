package com.gm.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.orm.mybatis.EntityDao;
import com.gm.common.orm.mybatis.Page;
import com.gm.common.orm.mybatis.QueryRequest;

@Transactional
public interface Manager<T, PK extends Serializable> {

	public abstract EntityDao<T, PK> getEntityDao();

	/**
	 * 通过id获得持久化对象
	 */
	public T getById(PK id) throws DataAccessException;

	/**
	 * 查找所有持久化对象
	 */
	public List<T> findAll() throws DataAccessException;

	/** 根据id检查是否插入或是更新数据 */
	public void saveOrUpdate(T entity) throws DataAccessException;

	/** 插入数据 */
	public void save(T entity) throws DataAccessException;

	/**
	 * 根据id删除
	 */
	public void removeById(PK id) throws DataAccessException;

	/**
	 * 根据id数组删除
	 */
	public void removeByIds(PK[] id) throws DataAccessException;

	/**
	 * 更新持久对象
	 */
	public void update(T entity) throws DataAccessException;

	/**
	 * 通过查询对象查询并分页排序
	 */
	public Page<T> findPage(QueryRequest pr);
}
