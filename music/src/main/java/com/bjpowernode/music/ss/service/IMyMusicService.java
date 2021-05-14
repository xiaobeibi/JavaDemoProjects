/** 
* 
*
*
*/

package com.bjpowernode.music.ss.service;

import java.util.List;

import com.bjpowernode.music.common.IServiceOperations;
import com.bjpowernode.music.ss.domain.MyMusic;

public interface IMyMusicService extends IServiceOperations<MyMusic, MyMusic> {

	public String getUserById(String user_name, String user_password);

	// 从数据库中获取音乐到我的音乐列表中
	public List<MyMusic> getMyMusicList(int userId);

	// 删除音乐
	public int deleteMyMusic(int song_id, int user_id);
}
