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
@RequestMapping("/UserType")
public class UserTypeController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/UserType";

    @RequestMapping("/SelectUserType_Id")
    @ResponseBody
    public JSON selectUserType_Id(@RequestParam("Id")String Id, HttpSession session){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/SelectUserType_Id",param, String.class) !=null){
                object.put("code", 1);
                object.put("message", "success");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/SelectUserType_Id",param, String.class));
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

    @RequestMapping("/SelectAllUserType")
    @ResponseBody
    public JSON selectAllUserType(HttpSession session){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/SelectAllUserType",param,List.class) !=null){
                object.put("code", 1);
                object.put("message", "success");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/SelectAllUserType",param,List.class));
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

//    @RequestMapping("/AddUserType")
//    @ResponseBody
//    public String addUserType(HttpSession session)throws JsonProcessingException{
//        JSONObject object = new JSONObject();
//        ObjectMapper mapper = new ObjectMapper();
//        if (session.getAttribute("login_session") != null) {
//                object.put("code", 1);
//                object.put("message", "success");
//                object.put("data",session.getAttribute("login_session"));
//                return mapper.writeValueAsString(object);
//        }else {
//            object.put("code",-1);
//            object.put("message","登录状态失效！请重新登录！");
//            return mapper.writeValueAsString(object);
//        }
//    }

    @RequestMapping("/AddUserType")
    @ResponseBody
    public JSON addUserType(HttpSession session,
                            @RequestParam("user_Type")String user_Type){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Type",user_Type);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/AddUserType",param,int.class)== 1){
                object.put("code", 1);
                object.put("message", "用户类型添加成功");
            }else {
                object.put("code", 0);
                object.put("message", "用户类型添加失败");
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/DeleteUserType")
    @ResponseBody
    public JSON deleteUserType(HttpSession session,@RequestParam("Id")String Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        if (session.getAttribute("login_session") != null) {
            if (restTemplate.postForObject(REST_URL_PREFIX+"/DeleteUserType",param,int.class) == 1){
                object.put("code", 1);
                object.put("message", "用户类型删除成功");
            }else {
                object.put("code", 0);
                object.put("message", "用户类型删除失败");
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

}
