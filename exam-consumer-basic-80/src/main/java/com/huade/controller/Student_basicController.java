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
@RequestMapping("/Student_basic")
public class Student_basicController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/Student_basic";

    @RequestMapping("/addStudentBasic")
    @ResponseBody
    public JSON addStudentBasic (HttpSession session, @RequestParam("user_Id") String user_Id,
                                 @RequestParam("user_Name") String user_Name,
                                 @RequestParam("user_Type") String user_Type,
                                 @RequestParam("user_Sex")String user_Sex,
                                 @RequestParam("user_Mobile") String user_Mobile,
                                 @RequestParam("stu_ClassId") String stu_ClassId,
                                 @RequestParam("stu_College")String stu_College,
                                 @RequestParam("stu_Specialty")String stu_Specialty){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("password","123456");
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        param.add("stu_ClassId",stu_ClassId);
        param.add("stu_College",stu_College);
        param.add("stu_Specialty",stu_Specialty);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/addStudentBasic",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加学生基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","添加学生基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登陆！");
        }
        return object;
    }

    @RequestMapping("/deleteStudentBasic")
    @ResponseBody
    public JSON deleteStudentBasic(HttpSession session,
                                   @RequestParam("user_Id")String user_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/deleteStudentBasic",param,int.class) == 1) {
                object.put("code",1);
                object.put("message","删除学生基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","删除学生基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateStudentBasic")
    @ResponseBody
    public JSON updateStudentBasic (HttpSession session,
                                    @RequestParam("user_Id") String user_Id,
                                    @RequestParam("user_Name") String user_Name,
                                    @RequestParam("user_Type") String user_Type,
                                    @RequestParam("user_Sex")String user_Sex,
                                    @RequestParam("user_Mobile") String user_Mobile,
                                    @RequestParam("stu_ClassId") String stu_ClassId,
                                    @RequestParam("stu_College")String stu_College,
                                    @RequestParam("stu_Specialty")String stu_Specialty) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("user_Name",user_Name);
        param.add("user_Type",user_Type);
        param.add("user_Sex",user_Sex);
        param.add("user_Mobile",user_Mobile);
        param.add("stu_ClassId",stu_ClassId);
        param.add("stu_College",stu_College);
        param.add("stu_Specialty",stu_Specialty);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/updateStudentBasic",param,int.class)==1) {
                object.put("code",1);
                object.put("message","修改学生基础信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","修改学生基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectStudentBasic")
    @ResponseBody
    public JSON selectTeacher (HttpSession session,
                               @RequestParam("user_Id")String user_Id,
                               @RequestParam("user_Name")String user_Name,
                               @RequestParam("class_Id")String class_Id,
                               @RequestParam("col_Id")String col_Id,
                               @RequestParam("spe_Id")String spe_Id,
                               @RequestParam("current")String current,
                               @RequestParam("length") String length) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("user_Name",user_Name);
        param.add("class_Id",class_Id);
        param.add("col_Id",col_Id);
        param.add("spe_Id",spe_Id);
        param.add("current",current);
        param.add("length",length);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectStudentBasic",param, List.class).size()!=0) {
                object.put("code",1);
                object.put("message","查询学生基础信息成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectStudentBasic",param, List.class));
            }
            else {
                object.put("code",0);
                object.put("message","查询学生基础信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }



}
