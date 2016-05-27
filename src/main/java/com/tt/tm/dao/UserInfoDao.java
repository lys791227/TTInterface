package com.tt.tm.dao;

import org.springframework.data.repository.CrudRepository;

import com.tt.tm.bean.UserInfo;

public interface  UserInfoDao  extends CrudRepository<UserInfo,Long>{

}