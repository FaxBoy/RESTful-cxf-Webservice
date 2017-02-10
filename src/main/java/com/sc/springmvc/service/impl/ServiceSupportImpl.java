package com.sc.springmvc.service.impl;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import com.sc.springmvc.service.ServiceSupport;
import com.sc.springmvc.util.SupportDao;
import com.sc.springmvc.util.mybatis.paginator.domain.Order;
import com.sc.springmvc.util.mybatis.paginator.domain.PageBounds;

public class ServiceSupportImpl<T, ID extends Serializable> implements ServiceSupport<T,ID>{

	private static final Logger logger = Logger.getLogger(ServiceSupportImpl.class);

	@Resource
	private SupportDao<T, ID> DaoSupport;
	
	public Integer insert(T entity) {
		return DaoSupport.insert(entity);
	}
    
	public Integer insert(Map params) {
		return DaoSupport.insert(params);

	}
	public T load(ID id) {
		return DaoSupport.load(id);
	}

	public List select(Map params) {
		return DaoSupport.select(params);
	}
 
	public List selectPage(Map params,int pageSize) {
		return DaoSupport.selectPage(params, new PageBounds(pageSize));
	}
	
	public List selectPage(Map params, int page, int pageSize) {
		return DaoSupport.selectPage(params, new PageBounds(page, pageSize));
	}
	
	public List selectPage(Map params, int pageSize, String sortString) {
		return DaoSupport.selectPage(params, new PageBounds(pageSize,Order.formString(sortString)));
	}
	
	public List selectPage(Map params, int page, int pageSize, String sortString) {
		return DaoSupport.selectPage(params, new PageBounds(page, pageSize,Order.formString(sortString)));
	}
	
	public Integer selectCountByMap(Map params) {
		return DaoSupport.selectCountByMap(params);
	}

	public Integer deleteByPrimaryKey(ID id) {
		return DaoSupport.deleteByPrimaryKey(id);
	}
	
	public Integer deleteByPrimaryKey(T entity) {
		return DaoSupport.deleteByPrimaryKey(entity);
	}

	public Integer insertSelective(T entity) {
		return DaoSupport.insertSelective(entity);
	}

	public T selectByPrimaryKey(ID id) {
		return DaoSupport.selectByPrimaryKey(id);
	}
	
	public T selectByPrimaryKey(T entity) {
		return DaoSupport.selectByPrimaryKey(entity);
	}

	public Integer updateByPrimaryKeySelective(T entity) {
		return DaoSupport.updateByPrimaryKeySelective(entity);
	}

	public Integer updateByPrimaryKey(T entity) {
		return DaoSupport.updateByPrimaryKey(entity);
	}
	
	public Integer updateList(Map params){
		return DaoSupport.updateList(params);
	}

	public Integer deleteByMap(Map params) {
		return DaoSupport.deleteByMap(params);
	}
	public Integer deleteList(List list){
		return DaoSupport.deleteList(list);
	}
}
