package com.ktds.youtube.video.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.youtube.video.vo.GroupVideoVO;
import com.ktds.youtube.video.vo.VideoVO;



@Repository
public class VideoDaoImpl extends SqlSessionDaoSupport implements VideoDao {
		
		@Autowired
		@Override
		public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
			// TODO Auto-generated method stub
			super.setSqlSessionTemplate(sqlSessionTemplate);
		}

		@Override
		public int insertOneVideo(VideoVO videoVO) {
			// TODO Auto-generated method stub
			return getSqlSession().insert("VideoDao.insertOneVideo",videoVO);
		}

		@Override
		public int updateOneVideo(VideoVO videoVO) {
			// TODO Auto-generated method stub
			return getSqlSession().update("VideoDao.updateOneVideo",videoVO);
		}

		@Override
		public int deleteOneVideo(String videiId) {
			// TODO Auto-generated method stub
			return getSqlSession().delete("VideoDao.deleteOneVideo",videiId);
		}

		@Override
		public VideoVO selectOneVideo(String videoId) {
			// TODO Auto-generated method stub
			return getSqlSession().selectOne("VideoDao.selectOneVideo",videoId);
		}

		@Override
		public List<GroupVideoVO> selectAllVideos() {
			// TODO Auto-generated method stub
			return getSqlSession().selectList("VideoDao.selectAllVideos");
		}
		
		
		
	
}
