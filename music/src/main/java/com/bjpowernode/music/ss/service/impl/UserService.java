/** 
* 
*
*
*/

package com.bjpowernode.music.ss.service.impl;

import javax.annotation.Resource;

import com.bjpowernode.music.common.AbstractService;
import com.bjpowernode.music.common.IOperations;
import com.bjpowernode.music.ss.domain.User;
import com.bjpowernode.music.ss.mapper.IUserMapper;
import com.bjpowernode.music.ss.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends AbstractService<User, User> implements IUserService {

	public UserService() {
		this.setTableName("user");
	}

	@Resource
	private IUserMapper userMapper;

	@Override
	protected IOperations<User, User> getMapper() {
		return userMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

//	public User getUserByName(String user_name) {
//		User user = userMapper.getUserByName(user_name);
//		return user;
//	}

	public String login(String user_name, String user_password) {
		return userMapper.login(user_name, user_password);
	}

	public String getUserById(String user_name, String user_password) {
		return userMapper.getUserById(user_name, user_password);
	}

	public String registJudge(String user_name) {
		return userMapper.registJudge(user_name);
	}

	// 更改密码
	public Integer resetPassword(String user_name, String newUser_password) {
		return userMapper.resetPassword(user_name, newUser_password);
	}

	// 判断用户名是否重复
	@Override
	public String rearchUserName(String user_name) {
		return userMapper.rearchUserName(user_name);
	}
}
