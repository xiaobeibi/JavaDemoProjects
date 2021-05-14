package com.bjpowernode.music.ss.mapper;

import java.util.List;

import com.bjpowernode.music.ss.domain.MyMusic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjpowernode.music.common.IOperations;

public interface IMyMusicMapper extends IOperations<MyMusic, MyMusic> {

	// 匹配用户名和密码
	@Select("select user_name from user where user_name=#{user_name} and user_password=#{user_password}")
	public String login(@Param("user_name") String user_name, @Param("user_password") String user_password);

	// 获取用户的id
	@Select("select user_id from user where user_name=#{user_name} and user_password=#{user_password}")
	public String getUserById(@Param("user_name") String user_name, @Param("user_password") String user_password);

	// #是将传入的值当做字符串的形式,$是将传入的数据直接显示生成sql语句
	// 从数据库中搜索歌曲在我的音乐列表中显示
	@Select("select * from mymusic where user_id=${user_id}")
	public List<MyMusic> getMyMusicList(@Param("user_id") int user_id);

	// 删除音乐
	@Delete("delete from mymusic where my_id=${song_id} and user_id=${user_id}")
	public int deleteMyMusic(@Param("song_id") int song_id, @Param("user_id") int user_id);

}
