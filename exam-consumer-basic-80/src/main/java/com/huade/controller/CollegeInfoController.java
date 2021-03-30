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
@RequestMapping("/collegeInfo")
public class CollegeInfoController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/collegeInfo";

    @RequestMapping("/addCollegeInfo")
    @ResponseBody
    public JSON addCollegeInfo (HttpSession session,
                                @RequestParam("col_Name") String col_Name){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("col_Name",col_Name);
        if(session.getAttribute("login_session") != null ){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/addCollegeInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加学院信息成功！");
            }
            else {
                object.put("code",-1);
                object.put("message","添加学院信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/deleteCollegeInfo")
    @ResponseBody
    public JSON deleteCollegeInfo(HttpSession session,
                                  @RequestParam("col_Id")String col_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("col_Id",col_Id);
        if(session.getAttribute("login_session") != null ){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/deleteCollegeInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","删除学院信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","删除学院信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateCollegeInfo")
    @ResponseBody
    public JSON updateCollegeInfo(HttpSession session,
                                  @RequestParam("Id")String Id,
                                  @RequestParam("col_Name")String col_Name){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("col_Name",col_Name);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/updateCollegeInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","修改学院信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","修改学院信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectAllCollegeInfo")
    @ResponseBody
    public JSON SelectAllCollegeInfo(HttpSession session) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCollegeInfo",param, List.class) !=null ){
                object.put("code",1);
                object.put("message","查询成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCollegeInfo",param, List.class));
            }
            else {
                object.put("code",0);
                object.put("message","查询不到任何学院信息！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("selectByCol_Id")
    @ResponseBody
    public JSON SelectBycol_Id(HttpSession session,
                               @RequestParam("col_Id") String col_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("col_Id",col_Id);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCollegeInfo",param, List.class) != null){
                object.put("code",1);
                object.put("message","查询成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectAllCollegeInfo",param, List.class));

            }
            else {
                object.put("code",0);
                object.put("message","未查询到学院信息！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

}
