package com.kind.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
@Repository("baseDao")
public interface BaseDao<M> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(M model);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	
	public void saveOrUpdate(M model); 
	/**
	 * 删除实体
	 * 
	 * @param entity
	 */
	public void deleteObject(M model);

	public void merge(M model);
	public void delete(long id);
	public boolean exists(long id);
	public M findById(long id);
}
	