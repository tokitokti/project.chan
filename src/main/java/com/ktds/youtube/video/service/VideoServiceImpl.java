package com.ktds.youtube.video.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.youtube.video.biz.VideoBiz;
import com.ktds.youtube.video.dao.VideoDao;
import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.GroupVideoVO;
import com.ktds.youtube.video.vo.VideoVO;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoBiz videoBiz;

	@Override
	public boolean createOneVideo(VideoVO videoVO) {
		// TODO Auto-generated method stub
		return videoBiz.createOneVideo(videoVO);
	}

	@Override
	public boolean updateOneVideo(VideoVO videoVO) {
		// TODO Auto-generated method stub
		return videoBiz.updateOneVideo(videoVO);
	}

	@Override
	public boolean deleteOneVideo(String videiId) {
		// TODO Auto-generated method stub
		return videoBiz.deleteOneVideo(videiId);
	}

	@Override
	public VideoVO readOneVideo(String videoId) {
		// TODO Auto-generated method stub
		return videoBiz.readOneVideo(videoId);
	}

	@Override
	public GroupVideoListVO readAllVideos() {
		// TODO Auto-generated method stub
		return videoBiz.readAllVideos();
	}
}
