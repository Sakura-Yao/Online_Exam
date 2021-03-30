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

@Controller
@ResponseBody
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/getSession")
    @ResponseBody
    public JSON getSession(HttpSession session, @RequestParam("key")String key){
        JSONObject object = new JSONObject();
        object.put("session_data",session.getAttribute(key));
        return object;
    }

    @RequestMapping("/UserLogin")
    @ResponseBody
    public JSON UserLogin(HttpSession session,
                          @RequestParam("user_Id")String user_Id,
                          @RequestParam("password")String password){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("password",password);
        if (restTemplate.postForObject(REST_URL_PREFIX+"/UserLogin",param,Object.class) != null){
            Object user = restTemplate.postForObject(REST_URL_PREFIX+"/UserLogin",param,Object.class);
            session.setAttribute("login_session",user);
            object.put("code",1);
            object.put("message","success");
            object.put("data",user);
        }else {
            object.put("code",0);
            object.put("message","登陆失败！");
        }
        return object;
    }


}
