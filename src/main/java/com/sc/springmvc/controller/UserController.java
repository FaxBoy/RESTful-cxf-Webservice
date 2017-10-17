package com.sc.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sc.springmvc.service.UserService;
import com.sc.springmvc.util.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)  
	@ResponseBody
	public JSONObject toIndex(){
		JSONObject json = new JSONObject();
		Map params = new HashMap<>();
		
		params.put("s", "s");
		List<?> list=this.userService.selectPage(params, 2, 10);
		PageList pagelist=(PageList)list;
		json.put("pageNumber", pagelist.getPaginator().getTotalCount());
		json.put("pageCount", pagelist.getPaginator().getTotalPages());
		json.put("curPage", pagelist.getPaginator().getPage());
		json.put("result", new JSONArray(pagelist));
		return json;
	}
	
	@RequestMapping(value = "/sdetail",method=RequestMethod.GET)  
	public ModelAndView xxview(){
		JSONObject json = new JSONObject();
		Map params = new HashMap<>();
		params.put("s", "s");
		List<?> list=this.userService.selectPage(params, 2, 10);
		PageList pagelist=(PageList)list;
		json.put("pageNumber", pagelist.getPaginator().getTotalCount());
		json.put("pageCount", pagelist.getPaginator().getTotalPages());
		json.put("curPage", pagelist.getPaginator().getPage());
		json.put("result", new JSONArray(pagelist));
		ModelAndView mav = new ModelAndView();
		mav.addObject("ss", pagelist);
		mav.setViewName("home/test");
		return mav;
	}
	
	
}
