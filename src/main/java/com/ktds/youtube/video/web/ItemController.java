package com.ktds.youtube.video.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @RequestMapping(value = "/list.do")
    public String list () {

        return "/item/list";
    }


    // 목록 불러오기 jsp
    // 등록 폼  jsp
    // 상세 jsp
    // 수정 jsp

    // 목록 api
    // 1건 api
    // 등록 api
    // 수정 api
    // 삭제 api


}
