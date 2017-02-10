package com.sc.springmvc.util;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sc.springmvc.util.mybatis.paginator.domain.PageBounds;

//T表示实体类；TD表示主键类型
public interface SupportDao<T, ID extends Serializable> {

	/**
	 * @description 通过主键查询model，TD是主键的类型
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
	public List selectPage(Map params,PageBounds pageBounds);

	/**
	 * @description 多条件查询条数
	 * @author yinbingpeng
	 * @date 2014-1-3 下午4:43:49
	 */
	public Integer selectCountByMap(Map params);

	/**
	 * @description 通过主键删除 ，TD是主键的类型
	 * @author yinbingpeng
	 * @date 2014-1-3 下午4:43:30
	 */
	public Integer deleteByPrimaryKey(ID id);
	
	public Integer deleteByPrimaryKey(T entity);
	
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
	 * @description 多条件删除
	 * @author yinbingpeng
	 * @date 2014-1-3 下午4:43:16
	 */
	public Integer deleteByMap(Map params);

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
	 * @description 通过主键查询实体对象，TD是主键的类型
	 * @author yinbingpeng
	 * @date 2014-1-3 下午4:42:37
	 */
	public T selectByPrimaryKey(ID id);
	
	public T selectByPrimaryKey(T entity);

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
	 * @Description 批量修改i啊
	 * @author maxiaojuan
	 * @return  
	 * @throws Exception 
	 * @date 2014-3-25 下午1:28:46  
	 * @throws
	 */
    public Integer updateList(Map params);
    
}
