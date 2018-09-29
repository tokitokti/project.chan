package com.ktds.youtube.video.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.youtube.video.service.VideoService;
import com.ktds.youtube.video.vo.GroupVideoListVO;
import com.ktds.youtube.video.vo.VideoVO;

@Controller
public class VideoController {
	@Autowired
	private VideoService videoService;



	@Autowired
	@Qualifier("uploadPath")
	private String uploadPath;

	@Bean("uploadPath")
	public String uploadPath() {
		return "C:/uploadVideos";
	}

	@GetMapping("/video/create")
	public String viewCreateOneVideoPage() {
		return "video/create";
	}
	

	@RequestMapping(value = "/video/create", method = RequestMethod.POST)
	public String doCreateOneVideoAction(@ModelAttribute VideoVO video) {

		MultipartFile uploadVideoFile = video.getVideo();
		MultipartFile uploadPosterFile = video.getPoster();

		if (!uploadVideoFile.isEmpty() && !uploadPosterFile.isEmpty()) {
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			String viewFileName = UUID.randomUUID().toString();
			String posterFileName = UUID.randomUUID().toString();

			File videoFile = new File(uploadPath, viewFileName);
			File posterFile = new File(uploadPath, posterFileName);

			try {
				uploadVideoFile.transferTo(videoFile);
				uploadPosterFile.transferTo(posterFile);

				video.setVideoPath(viewFileName);
				video.setPosterPath(posterFileName);
			} catch (IllegalStateException | IOException e) {
				// TODO: handle exception
				throw new RuntimeException(e.getMessage(), e);
			}
		}
			videoService.createOneVideo(video);
		return "redirect:/video/list";
	}
	
	@RequestMapping("/video/detail/{id}")
	public ModelAndView viewVideoListPage(@PathVariable String id) {
		ModelAndView view = new ModelAndView("video/detail");
		VideoVO video = videoService.readOneVideo(id);
		view.addObject("video",video);
		
		return view;
	}
	@GetMapping("/video/download/{fileName}")
	public void download(@PathVariable String fileName ,HttpServletRequest request, HttpServletResponse response) {

	}
	@RequestMapping("/video/list")
	public ModelAndView viewVideoListPage() {
		ModelAndView view=  new ModelAndView("video/list");
		GroupVideoListVO videoList = videoService.readAllVideos();
		view.addObject("videoList", videoList);
		return view;
	}


	
}
