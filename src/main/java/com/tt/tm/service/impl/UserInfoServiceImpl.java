package com.tt.tm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.tt.tm.bean.UserInfo;
import com.tt.tm.dao.UserInfoDao;
import com.tt.tm.service.UserInfoService;

import javassist.NotFoundException;

@Service
public class UserInfoServiceImpl implements UserInfoService {


	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
    private JdbcTemplate jdbcTemplate;

	/***
	 * 新增数据
	 */
	@Override
	public UserInfo save(UserInfo useInfo) {
		return userInfoDao.save(useInfo);
	}

	/**
	 * 查询数据.
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public UserInfo findById(Long id) {
		return userInfoDao.findOne(id);
	}
	
	@Override
	public List<UserInfo> findAll() {
		return (List<UserInfo>) userInfoDao.findAll();
		//return getUserList();
	}
	
	/***
	 * 
	 * 更新数据
	 * @param updated
	 * @return
	 * @throws NotFoundException
	 */
	@Override
	public UserInfo update(UserInfo updated) throws NotFoundException {
		UserInfo userInfo = userInfoDao.findOne(updated.getId());
		if (userInfo == null) {
			throw new NotFoundException("No find");
		}
		userInfo.setName(updated.getName());
		userInfo.setPwd(updated.getPwd());
		return userInfoDao.save(userInfo);
		
	}
	
	
	/**
	 * 删除数据.
	 * 
	 * @param id
	 */
	@Override
	public void delete(Long id) {
		userInfoDao.delete(id);
		
	}
	
	/***
	 * 动态的SQL操作数据库
	 */
	@Override
	public List<UserInfo>  getUserList(){
		 String sql = "SELECT ID,NAME,PWD,STATE FROM USER_INFO";
	        return (List<UserInfo>) jdbcTemplate.query(sql, new RowMapper<UserInfo>(){

	            @Override
	            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	UserInfo stu = new UserInfo();
	                stu.setId(rs.getInt("ID"));
	                stu.setName(rs.getString("NAME"));
	                stu.setPwd(rs.getString("PWD"));
	                stu.setState(rs.getInt("STATE"));
	                return stu;
	            }

	        });
		
	}
}
