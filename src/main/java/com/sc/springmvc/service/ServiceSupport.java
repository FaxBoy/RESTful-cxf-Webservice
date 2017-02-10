package com.sc.springmvc.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 处理单表操作的所有操作
 * 目前只调用dao接口，操作数据库；暂时没有特别的作用，以后可以设置权限或者日志
 */
public interface ServiceSupport<T, ID extends Serializable>  {
	
	/**
	 * @description 通过主键查询model 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:44:23
	 */
	public T load(ID id);
	
	/**
	 * @description 通过多条件查询集合 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:44:14
	 */
	public List select(Map params);
	
	/**
	 * @description 分页查询 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:44:06
	 */
	public List selectPage(Map params,int page,int pageSize);
	
	/**
	 * @description 分页查询 带排序
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:58
	 */
	public List selectPage(Map params, int page,int pageSize, String sortString);
	
	/**
	 * @description 分页查询 带排序 是否count
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:58
	 */
	public List selectPage(Map params,int pageSize);
	
	/**
	 * @description 多条件查询条数
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:49
	 */
	public Integer selectCountByMap(Map params);
	
	/**
	 * @description 通过主键删除 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:30
	 */
	public Integer deleteByPrimaryKey(ID id);
	
	/**
	 * @description 多条件删除
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:16
	 */
	public Integer deleteByMap(Map params);
	
	/**
	 * @Description 批量删除
	 * @author maxiaojuan
	 * @return  
	 * @throws Exception 
	 * @date 2014-3-25 上午11:33:43  
	 * @throws
	 */
	public Integer deleteList(List list);
	
	/**
	 * @description 通过实体对象插入 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:43:04
	 */
	public Integer insert(T entity);
	
	/**
	 * @description 通过Map对象插入  
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:42:53
	 */
	public Integer insert(Map params);
	
	/**
	 * @description 多条件插入 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:42:45
	 */
	public Integer insertSelective(T entity);
	
	/**
	 * @description 通过主键查询实体对象
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:42:37
	 */
	public T selectByPrimaryKey(ID id);
	
	public T selectByPrimaryKey(T entiry);
	
	/**
	 * @description 多条件修改 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:42:25
	 */
	public Integer updateByPrimaryKeySelective(T entity);
	
	/**
	 * @description 通过主键修改 
	 * @author yinbingpeng 
	 * @date 2014-1-3 下午4:44:34
	 */
	public Integer updateByPrimaryKey(T entity);
	
	/**
	 * @Description 批量修改
	 * @author maxiaojuan
	 * @return  
	 * @throws Exception 
	 * @date 2014-3-25 下午1:26:46  
	 * @throws
	 */
	public Integer updateList(Map params);
	
}
