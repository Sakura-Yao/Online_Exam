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
@RequestMapping("/Specialty")
public class SpecialtyController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/Specialty";
    @RequestMapping("/addSpecialtyInfo")
    @ResponseBody
    public JSON addSpecialtyInfo(HttpSession session,
                                 @RequestParam("spe_Name") String spe_Name,
                                 @RequestParam("cou_Id") String cou_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("spe_Name",spe_Name);
        param.add("cou_Id",cou_Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/addSpecialtyInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加专业信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","添加专业信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/deleteSpecialtyInfo")
    @ResponseBody
    public JSON deleteSpecialtyInfo(HttpSession session,
                                    @RequestParam("Id") String Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/deleteSpecialtyInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","删除专业信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","删除专业信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateSpecialtyInfo")
    @ResponseBody
    public JSON updateSpecialtyInfo(HttpSession session,
                                    @RequestParam("Id") String Id,
                                    @RequestParam("spe_Name") String spe_Name,
                                    @RequestParam("col_Id") String col_Id) {
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("spe_Name",spe_Name);
        param.add("col_Id",col_Id);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/updateSpecialtyInfo",param,int.class)== 1){
                object.put("code",1);
                object.put("message","修改专业信息成功！");
            }
            else {
                object.put("code",0);
                object.put("message","修改专业信息失败！");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectAllSpecialty")
    @ResponseBody
    public JSON selectAllSpecialty(HttpSession session){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/selectAllSpecialty",param, List.class) != null){
                object.put("code",1);
                object.put("message","查询专业信息成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectAllSpecialty",param, List.class) );

            }else {
                object.put("code",0);
                object.put("message","查询不到任何专业信息！");
            }

        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/selectCollegeInfo_col_Id")
    @ResponseBody
    public JSON selectCollegeInfo_col_Id(HttpSession session,
                                         @RequestParam("col_Id") String col_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("col_Id",col_Id);
        if(session.getAttribute("login_session") != null){
            if(restTemplate.postForObject(REST_URL_PREFIX+"/selectCollegeInfo_col_Id",param,List.class) != null){
                object.put("code",1);
                object.put("message","查询专业信息成功！");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectCollegeInfo_col_Id",param,List.class));
            }else {
                object.put("code",0);
                object.put("message","查询不到任何专业信息");
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

}
