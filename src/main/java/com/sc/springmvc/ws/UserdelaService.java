package com.sc.springmvc.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.ServiceSupport;

@Path("/equipQuery")
public interface UserdelaService extends ServiceSupport<User, String>{
	
	@GET     
	@Produces ({MediaType.APPLICATION_JSON + ";charset=UTF-8"})  
	@Path("/getUserById/{userid}")
	public User getUserById(@PathParam("userid") int userid);
	
	@GET     
	@Produces ({MediaType.APPLICATION_JSON + ";charset=UTF-8"})  
	@Path("/getUserPage/{page}/{pageSize}")
	public JSONObject getPage(@PathParam("page") int page,@PathParam("pageSize") int pageSize);
	
	@POST
	@Produces ({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
	@Path("/postTest")
	JSONObject selectpage(@FormParam("page")int page,@FormParam("pageSize")int pageSize,@FormParam("query")String query);
	
	@POST
	@Produces ({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
	@Path("/postTests")
	JSONObject selectpage(HttpServletRequest request);
	
	/*@GET     
	@Produces ({MediaType.APPLICATION_JSON})  
	@Path("/getUserCount/{userName}")
	public JSONObject getUserCount(@PathParam("userName") String userName);*/
}
