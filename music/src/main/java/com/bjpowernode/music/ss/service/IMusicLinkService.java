/** 
* 
*
*
*/

package com.bjpowernode.music.ss.service;

import com.bjpowernode.music.common.IServiceOperations;
import com.bjpowernode.music.ss.domain.MusicLink;

public interface IMusicLinkService extends IServiceOperations<MusicLink, MusicLink> {

	// 将榜单音乐收藏插入到我的音乐表中
	public void insertSongRearch(int song_id, int userId);

	public String judgeSong(String songName, int userId);
}
