package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huade.pojo.View_Question_Info;
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
@RequestMapping("/question")
public class QuestionInfoController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/question";

    @RequestMapping("/selectQuestionInfo")
    @ResponseBody
    public JSON SelectQuestionInfo(HttpSession session,
                                   @RequestParam("question_Id")String question_Id,
                                   @RequestParam("cou_Id")String cou_Id,
                                   @RequestParam("type_Id")String type_Id,
                                   @RequestParam("subject")String subject,
                                   @RequestParam("degree")String degree,
                                   @RequestParam("kwl_Id")String kwl_Id,
                                   @RequestParam("current")String current,
                                   @RequestParam("length")String length){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        JSONObject object = new JSONObject();
        if (session.getAttribute("login_session") != null) {
            param.add("question_Id",question_Id);
            param.add("cou_Id",cou_Id);
            param.add("type_Id",type_Id);
            param.add("subject",subject);
            param.add("degree",degree);
            param.add("kwl_Id",kwl_Id);
            param.add("current",current);
            param.add("length",length);
            List<View_Question_Info> data = restTemplate.postForObject(REST_URL_PREFIX + "/selectQuestionInfo", param, List.class);
            object.put("code",1);
            object.put("message","查询成功！");
            object.put("data",data);
        } else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/addQuestionInfo")
    @ResponseBody
    public JSON AddQuestionInfo(HttpSession session,
                                @RequestParam("cou_Id")String cou_Id,
                                @RequestParam("type_Id")String type_Id,
                                @RequestParam("subject")String subject,
                                @RequestParam("choice_A")String choice_A,
                                @RequestParam("choice_B")String choice_B,
                                @RequestParam("choice_C")String choice_C,
                                @RequestParam("choice_D")String choice_D,
                                @RequestParam("answer")String answer,
                                @RequestParam("degree")String degree,
                                @RequestParam("kwl_Id")String kwl_Id,
                                @RequestParam("analysis")String analysis){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        JSONObject object = new JSONObject();
        if (session.getAttribute("login_session") != null) {
            param.add("cou_Id",cou_Id);
            param.add("type_Id",type_Id);
            param.add("subject",subject);
            param.add("choice_A",choice_A);
            param.add("choice_B",choice_B);
            param.add("choice_C",choice_C);
            param.add("choice_D",choice_D);
            answer = answer.equals("--")?"本试题暂无答案":answer;
            param.add("answer",answer);
            param.add("degree",degree);
            param.add("kwl_Id",kwl_Id);
            analysis = analysis.equals("--")?"本试题暂无解析":analysis;
            param.add("analysis",analysis);
            if (restTemplate.postForObject(REST_URL_PREFIX + "/addQuestionInfo", param, Integer.class) == 1) {
                object.put("code",1);
                object.put("message","添加试题成功！");
            } else {
                object.put("code",0);
                object.put("message","添加试题失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/updateQuestionInfo")
    @ResponseBody
    public JSON UpdateQuestionInfo(HttpSession session,
                                   @RequestParam("Id")String Id,
                                   @RequestParam("cou_Id")String cou_Id,
                                   @RequestParam("type_Id")String type_Id,
                                   @RequestParam("subject")String subject,
                                   @RequestParam("choice_A")String choice_A,
                                   @RequestParam("choice_B")String choice_B,
                                   @RequestParam("choice_C")String choice_C,
                                   @RequestParam("choice_D")String choice_D,
                                   @RequestParam("answer")String answer,
                                   @RequestParam("degree")String degree,
                                   @RequestParam("kwl_Id")String kwl_Id,
                                   @RequestParam("analysis")String analysis) {
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        JSONObject object = new JSONObject();
        if (session.getAttribute("login_session") != null) {
            param.add("Id",Id);
            param.add("cou_Id",cou_Id);
            param.add("type_Id",type_Id);
            param.add("subject",subject);
            param.add("choice_A",choice_A);
            param.add("choice_B",choice_B);
            param.add("choice_C",choice_C);
            param.add("choice_D",choice_D);
            param.add("answer",answer);
            param.add("degree",degree);
            param.add("kwl_Id",kwl_Id);
            param.add("analysis",analysis);
            if (restTemplate.postForObject(REST_URL_PREFIX + "/updateQuestionInfo", param, Integer.class) == 1) {
                object.put("code",1);
                object.put("message","修改试题成功！");
            } else {
                object.put("code",0);
                object.put("message","修改试题失败！");
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
        }
        return object;
    }

    @RequestMapping("/showCountNum")
    @ResponseBody
    public JSON ShowCountNum(HttpSession session,
                               @RequestParam("question_Id")String question_Id,
                               @RequestParam("cou_Id")String cou_Id,
                               @RequestParam("type_Id")String type_Id,
                               @RequestParam("subject")String subject,
                               @RequestParam("degree")String degree,
                               @RequestParam("kwl_Id")String kwl_Id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        JSONObject object = new JSONObject();
        if (session.getAttribute("login_session") != null) {
            param.add("question_Id", question_Id);
            param.add("cou_Id", cou_Id);
            param.add("type_Id", type_Id);
            param.add("subject", subject);
            param.add("degree", degree);
            param.add("kwl_Id", kwl_Id);
            String res = restTemplate.postForObject(REST_URL_PREFIX + "/showCountNum", param, String.class);
            object.put("code",1);
            object.put("count",res);
        } else {
            object.put("code",0);
            object.put("count","0");
        }
        return object;
    }
}
