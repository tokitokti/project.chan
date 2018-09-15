package com.ktds.youtube.video.vo;

import java.util.Date;

@lombok.Data
public class BoardVO {

    private  int boardId;
    private  String subject ;
    private  String content;
    private  Date registDate;
    private  String delYn;
    private  int recommend;
    private  String memberId;

}
