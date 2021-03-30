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
@RequestMapping("/Teacher_basic")
public class Teacher_basicController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/Teacher_basic";

    @RequestMapping("/addTeacherBasicInfo")
    @ResponseBody
    public JSON addTeacher (HttpSession session,
                            @RequestParam("user_Id") String user_Id,
                            @RequestParam("user_Name") String user_Name,
                            @RequestParam("user_Type") String user_Type,
                            @RequestParam("user_Sex")String user_Sex,
                            @RequestParam("user_Mobile") String user_Mobile,
                            @RequestParam("college_Id") String college_Id,
                            @RequestParam("specialty_Id")String specialty_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("password","123456");
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        param.add("college_Id",college_Id);
        param.add("specialty_Id",specialty_Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/addTeacherBasicInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加教师基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","添加教师基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登陆！");
        }
        return object;
    }

    @RequestMapping("/deleteTeacherBasicInfo")
    @ResponseBody
    public JSON deleteTeacherBasicInfo(HttpSession session,
                                       @RequestParam("user_Id")String user_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/deleteTeacherBasicInfo",param,int.class) == 1) {
                object.put("code",1);
                object.put("message","删除教师基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","删除教师基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateTeacherBasicInfo")
    @ResponseBody
    public JSON updateTeacherBasicInfo (HttpSession session,
                                        @RequestParam("user_Id") String user_Id,
                                        @RequestParam("user_Name") String user_Name,
                                        @RequestParam("user_Type") String user_Type,
                                        @RequestParam("user_Sex")String user_Sex,
                                        @RequestParam("user_Mobile") String user_Mobile,
                                        @RequestParam("college_Id") String college_Id,
                                        @RequestParam("specialty_Id")String specialty_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        param.add("college_Id",college_Id);
        param.add("specialty_Id",specialty_Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/updateTeacherBasicInfo",param,int.class)==1) {
                object.put("code",1);
                object.put("message","修改教师基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","修改教师基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectTeacher")
    @ResponseBody
    public JSON selectTeacher (HttpSession session,
                               @RequestParam("user_Id")String user_Id,
                               @RequestParam("user_Name")String user_Name,
                               @RequestParam("col_Id")String col_Id,
                               @RequestParam("spe_Id")String spe_Id,
                               @RequestParam("current")String current,
                               @RequestParam("length")String length) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("user_Name",user_Name);
        param.add("col_Id",col_Id);
        param.add("spe_Id",spe_Id);
        param.add("current",current);
        param.add("length",length);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectTeacher",param, List.class).size()!=0) {
                object.put("code",1);
                object.put("message","查询教师基础信息成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectTeacher",param, List.class));
            }
            else {
                object.put("code",0);
                object.put("message","查询教师基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }



}
