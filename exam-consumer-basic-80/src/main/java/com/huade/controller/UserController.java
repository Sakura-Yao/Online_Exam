package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/User";

    @RequestMapping("/SelectAllUser")
    @ResponseBody
    public JSON selectAllUser(HttpSession session) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/SelectAllUser",param, List.class) !=null){
                object.put("code", 1);
                object.put("message", "success");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/SelectAllUser",param, List.class));
            }else {
                object.put("code", 0);
                object.put("message", "未查询到该信息");
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public JSON addUser (HttpSession session,
                         @RequestParam("user_Id") String user_Id,
                         @RequestParam("password") String password,
                         @RequestParam("user_Name") String user_Name,
                         @RequestParam("user_Type") String user_Type,
                         @RequestParam("user_Sex")String user_Sex,
                         @RequestParam("user_Mobile") String user_Mobile) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("password",password);
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/addUser",param,int.class) == 1) {
                object.put("code",1);
                object.put("message","success");
            }
            else {
                object.put("code",0);
                object.put("message","添加学生信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/DeleteUser")
    @ResponseBody
    public JSON DeleteUser (HttpSession session,
                            @RequestParam("user_id")String user_id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/DeleteUser",param,int.class) == 1) {
                object.put("code",1);
                object.put("message","success");
            }
            else {
                object.put("code",0);
                object.put("message","删除用户失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/UpdateUser")
    @ResponseBody
    public JSON UpdateUser (HttpSession session,
                            @RequestParam("user_id")String user_id,
                            @RequestParam("password")String password,
                            @RequestParam("user_Name")String user_Name,
                            @RequestParam("user_Type")String user_Type,
                            @RequestParam("user_Sex")String user_Sex,
                            @RequestParam("user_Mobile")String user_Mobile) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_id",user_id);
        param.add("password",password);
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/UpdateUser",param,int.class) == 1) {
                object.put("code",1);
                object.put("message","success");
            }
            else {
                object.put("code",0);
                object.put("message","修改用户失败！请重试！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }


}
