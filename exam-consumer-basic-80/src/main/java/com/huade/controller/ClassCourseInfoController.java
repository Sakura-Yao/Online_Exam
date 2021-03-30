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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classCourseInfo")
public class ClassCourseInfoController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/classCourseInfo";
    private static final String REST_BASIC_URL_PREFIX = "http://localhost:8001/basic";

    @RequestMapping("/addClassCourseInfo")
    @ResponseBody
    public JSON addClassCourseInfo(HttpSession session, @RequestParam("classes_Id") String classes_Id, @RequestParam("user_Id") String user_Id, @RequestParam("cou_Id") String cou_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("classes_Id",classes_Id);
        param.add("user_Id",user_Id);
        param.add("cou_Id",cou_Id);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/addClassCourseInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","添加成功");
            }else {
                object.put("code",0);
                object.put("message","添加失败");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/deleteClassCourseInfo")
    @ResponseBody
    public JSON deleteClassCourseInfo(HttpSession session,@RequestParam("classes_Id") String classes_Id,@RequestParam("user_Id") String user_Id,@RequestParam("cou_Id") String cou_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("classes_Id",classes_Id);
        param.add("user_Id",user_Id);
        param.add("cou_Id",cou_Id);
        if(session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/deleteClassCourseInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","删除成功");
            }else {
                object.put("code",0);
                object.put("message","删除失败");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }
    @RequestMapping("/updateClassCourseInfo")
    @ResponseBody
    public JSON updateClassCourseInfo(HttpSession session,@RequestParam("new_classes_Id") String new_classes_Id,@RequestParam("new_user_Id") String new_user_Id,@RequestParam("new_cou_Id") String new_cou_Id,@RequestParam("old_classes_Id") String old_classes_Id,@RequestParam("old_user_Id") String old_user_Id,@RequestParam("old_cou_Id") String old_cou_Id){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("new_classes_Id",new_classes_Id);
        param.add("new_user_Id",new_user_Id);
        param.add("new_cou_Id",new_cou_Id);
        param.add("old_classes_Id",old_classes_Id);
        param.add("old_user_Id",old_user_Id);
        param.add("old_cou_Id",old_cou_Id);
        if (session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/updateClassCourseInfo",param,int.class) == 1){
                object.put("code",1);
                object.put("message","修改成功");
            }else {
                object.put("code",0);
                object.put("message","修改失败");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }
    @RequestMapping("/selectAllClassCourseInfo")
    @ResponseBody
    public JSON selectAllClassCourseInfo(HttpSession session, @RequestParam("current") int current, @RequestParam("length") int length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("current",current);
        param.add("length",length);
        if (session.getAttribute("login_session") != null){
            if (restTemplate.postForObject(REST_URL_PREFIX+"/selectAllClassCourseInfo",param, List.class) != null){
                object.put("code",1);
                object.put("message","查询成功");
                object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectAllClassCourseInfo",param, List.class));
            }else {
                object.put("code",0);
                object.put("message","未查询到任何信息");
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
        }
        return object;
    }
    @RequestMapping("/selectClassCourseInfo")
    @ResponseBody
        public JSON selectClassCourseInfo(HttpSession session,@RequestParam("class_Id") String class_Id,@RequestParam("cou_Id") String cou_Id,@RequestParam("current") int current,@RequestParam("length") int length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if (session.getAttribute("login_session") != null){
            Object user = session.getAttribute("login_session");
            Map<String,Object> map = (Map<String, Object>) user;
            param.add("class_Id", class_Id);
            param.add("user_Id",map.get("user_Id"));
            param.add("cou_Id",cou_Id);
            param.add("current",current);
            param.add("length",length);
            object.put("code",1);
            object.put("message","查询成功");
            object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectClassCourseInfo",param,List.class));
        }else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/teachCourseClasses")
    @ResponseBody
    public JSON TeachCourseClasses (HttpSession session){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> course_param = new LinkedMultiValueMap<>();
        if (session.getAttribute("login_session") != null) {
            Object user = session.getAttribute("login_session");
            Map<String,Object> map = (Map<String, Object>) user;
            course_param.add("user_Id",map.get("user_Id"));
            List<View_Teacher_Class_Info> courses = restTemplate.postForObject(REST_BASIC_URL_PREFIX + "/selectAllTeachCourse", course_param, List.class);
            object.put("code",1);
            object.put("data",courses);
        }else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }
    @RequestMapping("/selectDistributionInfo")
    @ResponseBody
    public JSON selectDistributionInfo(HttpSession session,
                                       @RequestParam("user_Id")String user_Id,
                                       @RequestParam("class_Id") String class_Id,
                                       @RequestParam("cou_Id") String cou_Id,
                                       @RequestParam("current") String current,
                                       @RequestParam("length") String length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        if (session.getAttribute("login_session") != null){
            Object user = session.getAttribute("login_session");
            Map<String,Object> map = (Map<String, Object>) user;
            param.add("class_Id", class_Id);
            param.add("user_Id",user_Id);
            param.add("cou_Id",cou_Id);
            param.add("current",Integer.parseInt(current));
            param.add("length",Integer.parseInt(length));
            object.put("code",1);
            object.put("message","查询成功");
            object.put("data",restTemplate.postForObject(REST_URL_PREFIX+"/selectClassCourseInfo",param,List.class));
        }else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
        }
        return object;
    }


}
