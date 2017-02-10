package com.sc.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
	
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@Resource
	private UserService userService = null;
	
	@Test
	public void test1(){
		User user = userService.getUserById(1);
		
		logger.info(JSON.toJSONString(user));
	}
	
	public static void main(String[] args) {
		int a=7,b=3;
		System.out.println(a+"-"+b);
		a=b-a;
		b=b-a;
		a=b+a;
		System.out.println(a+"-"+b);
		
		//0到9的自然数不重复
		int[] arr=new int[]{1,4,2,3,6,5,8,9,0};//大小为9
		//输出0到9的自然数中哪一个自然数不在里面
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
	}
}
