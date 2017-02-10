package com.sc.springmvc.ws.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.springmvc.dao.UserDao;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.impl.ServiceSupportImpl;
import com.sc.springmvc.util.mybatis.paginator.domain.PageList;
import com.sc.springmvc.ws.UserdelaService;

@Named
public class UserdelServiceImpl extends ServiceSupportImpl<User, String> implements UserdelaService{
	
	@Resource
	private UserDao userDao;
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public JSONObject getPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map map = new HashMap<>();
		map.put("s", "s");
		JSONObject json = new JSONObject();
		List<?> list=super.selectPage(map, page,pageSize);
		PageList pagelist=(PageList)list;
		json.put("pageNumber", pagelist.getPaginator().getTotalCount());
		json.put("pageCount", pagelist.getPaginator().getTotalPages());
		json.put("curPage", pagelist.getPaginator().getPage());
		json.put("result", new JSONArray(pagelist));
		return json;
	}

	@Override
	public JSONObject selectpage(int page, int pageSize,String query) {
		System.out.println(page);
		System.out.println(pageSize);
		JSONObject jsons = new JSONObject();
		jsons= jsons.parseObject(query);
		String s= jsons.getString("name");
		System.out.println(jsons.get("name"));
		Map map = new HashMap<>();
		map.put("s", "s");
		JSONObject json = new JSONObject();
		List<?> list=super.selectPage(map, page,pageSize);
		PageList pagelist=(PageList)list;
		json.put("pageNumber", pagelist.getPaginator().getTotalCount());
		json.put("pageCount", pagelist.getPaginator().getTotalPages());
		json.put("curPage", pagelist.getPaginator().getPage());
		json.put("result", new JSONArray(pagelist));
		return json;
	}

	@Override
	public JSONObject selectpage(HttpServletRequest request) {
		System.out.println(request.getParameter("RID"));
		Map map = new HashMap<>();
		map.put("s", "s");
		JSONObject json = new JSONObject();
		List<?> list=super.selectPage(map, 1,10);
		PageList pagelist=(PageList)list;
		json.put("pageNumber", pagelist.getPaginator().getTotalCount());
		json.put("pageCount", pagelist.getPaginator().getTotalPages());
		json.put("curPage", pagelist.getPaginator().getPage());
		json.put("result", new JSONArray(pagelist));
		return json;
	}

}
