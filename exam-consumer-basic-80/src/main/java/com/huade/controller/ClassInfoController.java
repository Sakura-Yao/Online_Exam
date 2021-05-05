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
@RequestMapping("/classInfo")
public class ClassInfoController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/classInfo";

    //ip:part/classInfo/addClassInfo
    @RequestMapping("/addClassInfo")
    @ResponseBody
    public JSON addClassInfo(HttpSession session,
                             @RequestParam("class_Id") String class_Id,
                             @RequestParam("people_Num") String people_Num,
                             @RequestParam("class_Col_Id") String class_Col_Id,
                             @RequestParam("class_Spe_Id") String class_Spe_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("class_Id",class_Id);
        param.add("people_Num",people_Num);
        param.add("class_Col_Id",class_Col_Id);
        param.add("class_Spe_Id",class_Spe_Id);
        System.out.println(param);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/addClassInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加班级信息成功！");
            }else {
                object.put("code",0);
                object.put("message","添加班级信息失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateClassInfo")
    @ResponseBody
    public JSON updateClassInfo(HttpSession session,
                                @RequestParam("Id") String Id,
                                @RequestParam("class_Id") String class_Id,
                                @RequestParam("people_Num") String people_Num,
                                @RequestParam("class_Col_Id") String class_Col_Id,
                                @RequestParam("class_Spe_Id") String class_Spe_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("class_Id",class_Id);
        param.add("people_Num",people_Num);
        param.add("class_Col_Id",class_Col_Id);
        param.add("class_Spe_Id",class_Spe_Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/updateClassInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","修改班级信息成功！");
            }else{
                object.put("code",0);
                object.put("messgae","修改班级信息失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/deleteClassInfo")
    @ResponseBody
    public JSON deleteClassInfo(HttpSession session,
                                @RequestParam("Id") String Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/deleteClassInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","删除班级信息成功！");
            }else {
                object.put("code",0);
                object.put("message","删除班级信息失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/select_classInfo_keywords")
    @ResponseBody
    public JSON select_classInfo_keywords(HttpSession session,
                                          @RequestParam("Id")String Id,
                                          @RequestParam("class_Id")String class_Id,
                                          @RequestParam("col_Id")String col_Id,
                                          @RequestParam("spe_Id")String spe_Id,
                                          @RequestParam("current")String current,
                                          @RequestParam("length")String length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        if(session.getAttribute("login_session") != null){
            param.add("Id",Id);
            param.add("class_Id",class_Id);
            param.add("col_Id",col_Id);
            param.add("spe_Id",spe_Id);
            param.add("current",current);
            param.add("length",length);
            object.put("code",1);
            object.put("message","查询成功！");
            object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/select_classInfo_keywords",param, List.class));
        } else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectClassInfo")
    @ResponseBody
    public JSON selectClassInfo(HttpSession session,@RequestParam("Id")String Id,
                                @RequestParam("class_Id")String class_Id,
                                @RequestParam("col_Id")String col_Id,
                                @RequestParam("spe_Id")String spe_Id,
                                @RequestParam("current")String current,
                                @RequestParam("length")String length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("class_Id",class_Id);
        param.add("col_Id",col_Id);
        param.add("spe_Id",spe_Id);
        param.add("current",current);
        param.add("length",length);
        if(session.getAttribute("login_session") != null){
            object.put("code",1);
            object.put("message","查询成功！");
            object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectClassInfo",param,List.class));
        } else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/showCountNum")
    @ResponseBody
    public JSON showCountNum(HttpSession session,@RequestParam("Id")String Id,
                             @RequestParam("class_Id")String class_Id,
                             @RequestParam("col_Id")String col_Id,
                             @RequestParam("spe_Id")String spe_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        if (session.getAttribute("login_session") != null){
            param.add("Id",Id);
            param.add("class_Id",class_Id);
            param.add("col_Id",col_Id);
            param.add("spe_Id",spe_Id);
            object.put("code",1);
            object.put("count",restTemplate.postForObject(REST_URL_PREFIX+"/showCountNum",param,String.class));
        } else {
            object.put("code",-1);
            object.put("count",0);
        }
        return object;
    }

}
