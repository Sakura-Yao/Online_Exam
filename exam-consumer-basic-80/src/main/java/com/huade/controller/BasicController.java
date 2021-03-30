package com.huade.controller;

import com.huade.pojo.View_Knowledge;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/basic";

    @RequestMapping("/selectAllTeachCourse")
    @ResponseBody
    public List<View_Teacher_Class_Info> SelectAllTeachCourse(@RequestParam("user_Id")String user_Id,
                                                              @RequestParam("cou_Name")String cou_Name,
                                                              @RequestParam("current")String current,
                                                              @RequestParam("length")String length){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("cou_Name",cou_Name);
        param.add("current",current);
        param.add("length",length);
        return restTemplate.postForObject(REST_URL_PREFIX + "/selectAllTeachCourse", param, List.class);
    }

    @RequestMapping("/selectAllTeachClasses")
    @ResponseBody
    public List<View_Teacher_Class_Info> SelectAllTeachClasses(@RequestParam("user_Id")String user_Id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/selectAllTeachClasses",param,List.class);
    }

    @RequestMapping("/selectKnowledge")
    @ResponseBody
    public List<View_Knowledge> SelectKnowledge(@RequestParam("cou_Id")String cou_Id,
                                                @RequestParam("kwl_Level")String kwl_Level,
                                                @RequestParam("chapter_Num")String chapter_Num){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_Id",cou_Id);
        param.add("kwl_Level",kwl_Level);
        param.add("chapter_Num",chapter_Num);
        return restTemplate.postForObject(REST_URL_PREFIX+"/selectAllKnowledge",param,List.class);
    }

    @RequestMapping("/selectTeachClasses_course")
    @ResponseBody
    public List SelectTeachClasses_course(HttpSession session, @RequestParam("cou_Id")String cou_Id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        Object user = session.getAttribute("login_session");
        Map<String,Object> map = (Map<String, Object>) user;
        param.add("user_Id",map.get("user_Id"));
        param.add("cou_Id",cou_Id);
        return restTemplate.postForObject(REST_URL_PREFIX + "/selectTeachClasses_course", param, List.class);
    }

    @RequestMapping("/selectQuestionType")
    @ResponseBody
    public List SelectQuestionType(HttpSession session){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        if (session.getAttribute("login_session")!=null) {
            return restTemplate.postForObject(REST_URL_PREFIX+"/selectQuestionType",param,List.class);
        }
        return null;
    }

    @RequestMapping("/selectCollegeInfo")
    @ResponseBody
    public List SelectCollegeInfo(HttpSession session,@RequestParam("col_Id")String col_Id){
        if (session.getAttribute("login_session")!=null) {
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("col_Id",col_Id);
            return restTemplate.postForObject(REST_URL_PREFIX+"/selectCollegeInfo",param,List.class);
        }
        return null;
    }

    @RequestMapping("/selectSpecialtyInfo")
    @ResponseBody
    public List SelectSpecialtyInfo(HttpSession session,@RequestParam("col_Id")String col_Id) {
        if (session.getAttribute("login_session") != null) {
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("col_Id", col_Id);
            return restTemplate.postForObject(REST_URL_PREFIX + "/selectSpecialtyInfo", param, List.class);
        }
        return null;
    }

    @RequestMapping("/selectClassesInfo")
    @ResponseBody
    public List SelectClassesInfo(HttpSession session,
                                             @RequestParam("Id")String Id,
                                             @RequestParam("cou_Id")String cou_Id,
                                             @RequestParam("spe_Id")String spe_Id,
                                             @RequestParam("current")String current,
                                             @RequestParam("length")String length){
        if (session.getAttribute("login_session") != null) {
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("Id",Id);
            param.add("cou_Id",cou_Id);
            param.add("spe_Id",spe_Id);
            param.add("current",current);
            param.add("length",length);
            return restTemplate.postForObject(REST_URL_PREFIX+"/selectClassesInfo",param,List.class);
        }
        return null;
    }
}
