package com.ktds.youtube.video.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.youtube.video.dao.VideoDao;
import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

@Component
public class VideoBizImpl implements VideoBiz {
	
	@Autowired
	private VideoDao videoDao;
	
	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		// TODO Auto-generated method stub
		return videoDao.insertOneVideo(videoVO) >0;
	}

	@Override
	public boolean updateOneVideo(VideoVO videoVO) {
		// TODO Auto-generated method stub
		return videoDao.updateOneVideo(videoVO) >0;
	}

	@Override
	public boolean deleteOneVideo(String videiId) {
		// TODO Auto-generated method stub
		return videoDao.deleteOneVideo(videiId) >0;
	}

	@Override
	public VideoVO readOneVideo(String videoId) {
		// TODO Auto-generated method stub
		return videoDao.selectOneVideo(videoId);
	}

	@Override
	public GroupVideoListVO readAllVideos() {
		// TODO Auto-generated method stub
		GroupVideoListVO  videoList = new GroupVideoListVO();
		videoList.setGroupVideoList(videoDao.selectAllVideos());
		return videoList;
	}
}
