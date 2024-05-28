package com.example.server.controller;

import com.example.server.domain.News;
import com.example.server.domain.User;
import com.example.server.domain.UserDetail;
import com.example.server.services.NewsService;
import com.example.server.services.UserDetailService;
import com.example.server.services.UserService;
import com.example.server.domain.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@PreAuthorize("hasRole('ROLE_USER_S')")
@RequestMapping(value = {"/userApi"})
public class UserApiController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = {"/update-user-detail"},method = RequestMethod.POST)
    public Response editUserDetail(UserDetail userDetail){

        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userService.getUserByLoginName(name);

        if (!user.getuserId().equals(userDetail.getuserId())){
            return new Response(false,"failure");
        }

        UserDetail userDetail1=userDetailService.getUserDetailByUserId(userDetail.getuserId());
        if (userDetail1==null){
            userDetail.setdetailCreate(new Date());
            userDetail.setdetailModified(new Date());
        }else{
            userDetail.setdetailId(userDetail1.getdetailId());
            userDetail.setdetailCreate(userDetail1.getdetailCreate());
            userDetail.setdetailModified(new Date());
        }

        UserDetail userDetail2=userDetailService.saveOrUpdateUserDetail(userDetail);

        return new Response(true,"success",userDetail2);
    }

    @RequestMapping(value = {"/post-news"},method = RequestMethod.POST)
    public Response postNews(News news){

        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userService.getUserByLoginName(name);

        if (!news.getuserId().equals(user.getuserId())){
            return new Response(false,"failure");
        }

        news.setnewsCreate(new Date());
        news.setauditTime(new Date());
        news.setnewsModified(new Date());
        if (news.getnewsStatus()==1){
            news.setauditTime(new Date());
        }

        News news1=newsService.saveOrUpdateNews(news);
        return new Response(true,"success",news1);
    }

}
