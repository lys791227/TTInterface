package com.tt.tm.service;

import java.util.List;

import com.tt.tm.bean.UserInfo;

import javassist.NotFoundException;

public interface UserInfoService {
	
	void delete(Long id);

	UserInfo update(UserInfo updated) throws NotFoundException;

	UserInfo findById(Long id);

	UserInfo save(UserInfo demoInfo);
	
	List<UserInfo>  findAll();
	List<UserInfo>  getUserList();

}
