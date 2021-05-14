/** 
* 
*
*
*/

package com.bjpowernode.music.ss.service;

import com.bjpowernode.music.common.IServiceOperations;
import com.bjpowernode.music.ss.domain.User;

public interface IUserService extends IServiceOperations<User, User> {

	// 判断用户名是否重复
	public String rearchUserName(String user_name);
}
