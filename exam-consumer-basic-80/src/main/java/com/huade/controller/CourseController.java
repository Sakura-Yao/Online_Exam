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
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/Course";
    @RequestMapping("/addCourseInfo")
    @ResponseBody
    public JSON addCourseInfo(HttpSession session, @RequestParam("cou_Name") String cou_Name, @RequestParam("spe_Id") String spe_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_Name",cou_Name);
        param.add("spe_Id",spe_Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/addCourseInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加课程成功！");
            }else {
                object.put("code",0);
                object.put("message","添加课程失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/deleteCourseInfo")
    @ResponseBody
    public JSON deleteCourseInfo(HttpSession session, @RequestParam("cou_Id") String cou_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_Id",cou_Id);
        if (session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/deleteCourseInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","删除课程成功！");
            }else {
                object.put("code",0);
                object.put("message","删除课程失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateCourseInfo")
    @ResponseBody
    public JSON updateCourseInfo(HttpSession session,@RequestParam("Id") String Id,@RequestParam("cou_Name") String cou_Name,@RequestParam("spe_Id") String spe_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("cou_Name",cou_Name);
        param.add("spe_Id",spe_Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/updateCourseInfo",param,int.class) == 1) {
                object.put("code", 1);
                object.put("message", "修改课程成功！");
            } else {
                object.put("code", 0);
                object.put("message", "修改课程失败！");
            }
        } else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectAllCourseInfo")
    @ResponseBody
    public JSON selectAllCourseInfo(HttpSession session,@RequestParam("current") int current,@RequestParam("length") int length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("current",current);
        param.add("length",length);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCourseInfo",param, List.class) != null){
                object.put("code", 1);
                object.put("message", "查询课程成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCourseInfo",param, List.class));
            } else {
                object.put("code", 0);
                object.put("message", "未查询到任何课程！");
            }
        } else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectCourseInfo")
    @ResponseBody
    public JSON selectCourseInfo(HttpSession session,
                                 @RequestParam("cou_Id")String cou_Id,
                                 @RequestParam("cou_Name")String cou_Name,
                                 @RequestParam("col_Id")String col_Id,
                                 @RequestParam("spe_Id") String spe_Id,
                                 @RequestParam("current") String current, @RequestParam("length") String length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_Id",cou_Id);
        param.add("cou_Name",cou_Name);
        param.add("col_Id",col_Id);
        param.add("spe_Id",spe_Id);
        param.add("current",current);
        param.add("length",length);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectCourseInfo",param,List.class) != null) {
                object.put("code", 1);
                object.put("message", "查询课程成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectCourseInfo",param,List.class));
            } else {
                object.put("code", 0);
                object.put("message", "未查询到任何课程！");
            }
        } else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }




}
