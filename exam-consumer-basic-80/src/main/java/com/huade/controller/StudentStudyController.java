package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huade.pojo.User;
import com.huade.pojo.View_Teacher_Class_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/study")
public class StudentStudyController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/Study";

    @RequestMapping("/getStudentCourses")
    @ResponseBody
    public JSON getStudentCourses (HttpSession session){
        JSONObject object = new JSONObject();
        MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
        if (session.getAttribute("login_session")!=null){
            Map<String ,String> login_session = (Map<String, String>) session.getAttribute("login_session");
            param.add("Id",login_session.get("user_Id"));
            List<View_Teacher_Class_Info> res = restTemplate.postForObject(REST_URL_PREFIX + "/getStudentCourses", param, List.class);
            object.put("code",1);
            object.put("message","查询成功！");
            object.put("data",res);
        } else {
            object.put("code",-1);
            object.put("message","登录信息失效！请重新登录！");
        }
        return object;
    }

}
