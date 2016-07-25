package com.tt.tm.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tt.tm.bean.UserInfo;
import com.tt.tm.service.UserInfoService;

import javassist.NotFoundException;

@RestController
public class UserInfoController {
	@Resource
	private UserInfoService userInfoService;
	
	/***
	 * "增加一个user"
	 * @param body
	 * @return
	 */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody UserInfo  addCustomer(@RequestBody String body) {
    	
    	System.out.println("Start adduser.");
    	ObjectMapper mapper = new ObjectMapper();
     	UserInfo userinfo = new UserInfo();
     	 try {
     		userinfo = mapper.readValue(body,  UserInfo.class);
         } catch (JsonParseException e) {
             e.printStackTrace();
         } catch (JsonMappingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
        return userInfoService.save(userinfo);
    }
	
 
    /***
     * 获取所有的user
     * @return
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
    public @ResponseBody List<UserInfo> getAllUser() {
        return userInfoService.findAll();
    }
	
    /***
     * 删除用户
     * @param body
     * @return
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public @ResponseBody boolean deleteUserById(@RequestBody String body) {
    	System.out.println("Start delete user.");
    	ObjectMapper mapper = new ObjectMapper();
     	UserInfo userinfo = new UserInfo();
     	 try {
     		userinfo = mapper.readValue(body,  UserInfo.class);
         } catch (JsonParseException e) {
             e.printStackTrace();
         } catch (JsonMappingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     	userInfoService.delete(userinfo.getId());
        return true;
    }
	
	/***
	 * 更新用户信息
	 * @param body
	 * @return
	 * @throws NotFoundException
	 */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public @ResponseBody UserInfo updateUser(@RequestBody String body) throws NotFoundException {
    	System.out.println("Start update user.");
    	ObjectMapper mapper = new ObjectMapper();
     	UserInfo userinfo = new UserInfo();
     	 try {
     		userinfo = mapper.readValue(body,  UserInfo.class);
         } catch (JsonParseException e) {
             e.printStackTrace();
         } catch (JsonMappingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     	return userInfoService.update(userinfo);
        
    }
	
    
	
	@RequestMapping("/test")
	public String test(){
		//存入两条数据.
    	UserInfo userInfo = new UserInfo();
    	userInfo.setName("张三");
    	userInfo.setPwd("123456");
    	UserInfo userInfo2 = userInfoService.save(userInfo);
    	System.out.println(userInfoService.findById(userInfo2.getId()));
    
    	
    	userInfo = new UserInfo();
    	userInfo.setName("李四");
    	userInfo.setPwd("123456");
    	UserInfo userInfo3 = userInfoService.save(userInfo);
    	System.out.println(userInfoService.findById(userInfo3.getId()));
    	
    	System.out.println("============修改数据=====================");
    	//修改数据.
    	UserInfo updated = new UserInfo();
    	updated.setName("李四-updated");
    	updated.setPwd("123456");
    	updated.setId(userInfo3.getId());
    	try {
			System.out.println(userInfoService.update(updated));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
    	
		return "ok";
	}
	
	
}
