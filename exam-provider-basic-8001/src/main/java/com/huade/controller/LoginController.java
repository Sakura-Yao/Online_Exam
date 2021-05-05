package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.pojo.User;
import com.huade.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/UserLogin")
    @ResponseBody
    public Object UserLogin(@RequestParam("user_Id")String user_Id, @RequestParam("password")String password){
        return userService.Login(user_Id, password);
    }

    @RequestMapping("/EditPassword")
    @ResponseBody
    public int EditPassword(@RequestParam("user_Id")String user_Id,
                            @RequestParam("oldPassword")String oldPassword,
                            @RequestParam("newPassword")String newPassword){
        if (userService.Login(user_Id,oldPassword) != null && newPassword != null){
            return userService.editPassword(user_Id, newPassword);
        } else
            return 0;
    }


}
