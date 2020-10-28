package com.kwhua.redis.controller;

import com.kwhua.redis.entity.User;
import com.kwhua.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        List<User> lists = userService.queryAll();
        return lists;
    }

    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestParam int id){
        User user = userService.findUserById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("id", user.getId());
        result.put("userName", user.getUserName());
        result.put("pwd", user.getPassWord());
        result.put("sex", user.getSex());
        result.put("birthday",user.getBirthday());
        return result;
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        User user = new User();
        user.setId(1);
        user.setUserName("AAAAA");
        user.setPassWord("123456");
        user.setSex(1);
        user.setBirthday(new Date());

        int result = userService.updateUser(user);

        if(result != 0){
            return "update user success";
        }

        return "fail";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }
}
