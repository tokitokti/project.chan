package com.ktds.youtube.video.dao;


import com.ktds.youtube.video.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardDao {

    public int insertBaord(BoardVO boardVO);
    public int createBoard(BoardVO boardVO);
    public int updateBoard(BoardVO boardVO);
    public int deleteBoard(String boardId);
    public BoardVO selectOneBoard(String boardId);
    public List<BoardVO> selectAllBoards();
}
