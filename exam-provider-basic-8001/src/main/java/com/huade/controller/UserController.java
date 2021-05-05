package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.pojo.User;
import com.huade.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/SelectAllUser")
    @ResponseBody
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser (@RequestParam("user_Id") String user_Id, @RequestParam("password") String password, @RequestParam("user_Name") String user_Name, @RequestParam("user_Type") String user_Type, @RequestParam("user_Sex")String user_Sex, @RequestParam("user_Mobile") String user_Mobile) {

        User user = new User(user_Id,password,user_Name,user_Type,user_Sex,user_Mobile);
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            return 0;
        }
    }

    @RequestMapping("/makeBatchAddUserInfo")
    @ResponseBody
    public String makeBatchAddUserInfo(@RequestParam("filePath")String filePath,
                                       @RequestParam("fileName")String fileName){
        return UtilTools.MakeBatchAddUserMode(filePath, fileName);
    }

    @RequestMapping("/batchStudentInfo")
    @ResponseBody
    public Map batchStudentInfo(@RequestParam("filePath")String filePath){
        return UtilTools.BatchAddStudentInfo(filePath);
    }

    @RequestMapping("/batchTeacherInfo")
    @ResponseBody
    public Map batchTeacherInfo(@RequestParam("filePath")String filePath){
        return UtilTools.BatchAddTeacherInfo(filePath);
    }

    @RequestMapping("/DeleteUser")
    @ResponseBody
    public int DeleteUser (@RequestParam("user_id")String user_id){
        return userService.deleteUser(user_id);
    }

    @RequestMapping("/UpdateUser")
    @ResponseBody
    public int UpdateUser (@RequestParam("user_id")String user_id,
                           @RequestParam("password")String password,
                           @RequestParam("user_Name")String user_Name,
                           @RequestParam("user_Type")String user_Type,
                           @RequestParam("user_Sex")String user_Sex,
                           @RequestParam("user_Mobile")String user_Mobile) {
        User user = new User(user_id, password, user_Name, user_Type, user_Sex, user_Mobile);
        return userService.updateUser(user);
    }


}
