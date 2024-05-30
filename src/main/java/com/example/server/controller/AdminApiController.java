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
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * webApi 控制器
 * 返回json对象
 */

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = {"/newsAPI"})
public class AdminApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserDetailService userDetailService;

    @RequestMapping(value = {"/edit-user"},method = RequestMethod.POST)
    public Response editUser(User user){
        user.setloginPwd(DigestUtils.md5DigestAsHex(user.getloginPwd().getBytes()));
        user.setuserCreate(userService.getUserById(user.getuserId()).getuserCreate());
        User user1=userService.saveOrUpdateUser(user);
        return new Response(true,"success",user1);
    }

    @RequestMapping(value = {"/edit-news"},method = RequestMethod.POST)
    public Response editNews(News news){
        news.setnewsCreate(newsService.getNewsById(news.getnewsId()).getnewsCreate());
        if (news.getnewsStatus()==1){
            news.setauditTime(new Date());
        }

        news.setauditTime(new Date());
        news.setnewsModified(new Date());
//        System.out.println(news);
        News news1=newsService.saveOrUpdateNews(news);
        return new Response(true,"success",news1);
    }

    @RequestMapping(value = {"/add-news"},method = RequestMethod.POST)
    public Response addNews(News news){
        news.setnewsCreate(new Date());
        news.setauditTime(new Date());
        news.setnewsModified(new Date());
        if (news.getnewsStatus()==1){
            news.setauditTime(new Date());
        }

        News news1=newsService.saveOrUpdateNews(news);
        return new Response(true,"success",news1);
    }

    @RequestMapping(value = {"/remove-news"},method = RequestMethod.POST)
    public Response rmNews(Long newsId){
        newsService.removeNews(newsId);
        return new Response(true,"success");
    }

    @RequestMapping(value = {"/remove-user"},method = RequestMethod.POST)
    public Response rmUser(Long userId){
        User user=userService.getUserById(userId);
        if (user.getuserType()==1){
            return new Response(false,"failure");
        }
        userService.removeUser(userId);
        userDetailService.removeById(userDetailService.getUserDetailByUserId(userId).getdetailId());
        return new Response(true,"success");
    }

    @RequestMapping(value = {"/edit-user-detail"},method = RequestMethod.POST)
    public Response editUserDetail(UserDetail userDetail){
        UserDetail userDetail2=userDetailService.getUserDetailByUserId(userDetail.getuserId());
        if (userDetail2==null){
            userDetail.setdetailCreate(new Date());
            userDetail.setdetailModified(new Date());
        }else{
            userDetail.setdetailId(userDetail2.getdetailId());
            userDetail.setdetailCreate(userDetail2.getdetailCreate());
            userDetail.setdetailModified(new Date());
        }

//        System.out.println(userDetail);
        UserDetail userDetail1=userDetailService.saveOrUpdateUserDetail(userDetail);

        return new Response(true,"success",userDetail1);
    }

    @RequestMapping(value = {"/add-user"},method = RequestMethod.POST)
    public Response addUser(User user){
        String name=user.getloginName();
        if (userService.getUserByLoginName(name)!=null){
            return new Response(false,"failure");
        }

        user.setloginPwd(DigestUtils.md5DigestAsHex(user.getloginPwd().getBytes()));

        user.setuserCreate(new Date());
        user.setuserModified(new Date());
        User user1=userService.saveOrUpdateUser(user);

        return new Response(true,"success",user1);
    }

    @RequestMapping(value = {"/update-user"},method = RequestMethod.POST)
    public Response updateUser(User user){
        String name=user.getloginName();
        User user2=userService.getUserByLoginName(name);

        if (user.getloginPwd() != null) {
            user.setloginPwd(DigestUtils.md5DigestAsHex(user.getloginPwd().getBytes()));
        }

        user.setuserId(user2.getuserId());
        user.setuserCreate(user2.getuserCreate());
        user.setuserModified(new Date());

        User user1=userService.saveOrUpdateUser(user);

        return new Response(true,"success",user1);
    }

}
