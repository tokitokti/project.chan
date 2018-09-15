package com.ktds.youtube.video.service;

import java.util.List;

import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

public interface VideoService  {
	
public boolean  createOneVideo(VideoVO videoVO);
	
	public boolean  updateOneVideo(VideoVO videoVO);
	
	public boolean  deleteOneVideo(String videiId);
	
	public VideoVO  readOneVideo(String videoId);
	
	public GroupVideoListVO readAllVideos();
	
}
