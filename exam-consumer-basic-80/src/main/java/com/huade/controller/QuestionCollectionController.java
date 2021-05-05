package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huade.pojo.QuestionCollection;
import com.huade.pojo.View_Question_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/questionCollection")
public class QuestionCollectionController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/questionCollection";

    @RequestMapping("/add")
    @ResponseBody
    public JSON add(QuestionCollection questionCollection){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",questionCollection.getUser_Id());
        param.add("question_Id",questionCollection.getQuestion_Id());
        if (restTemplate.postForObject(REST_URL_PREFIX + "/add", param, int.class) == 1) {
            object.put("code",1);
            object.put("message","题目收藏成功！");
        } else {
            object.put("code",0);
            object.put("message","该题目已收藏，无需多次添加！");
        }
        return object;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JSON delete(QuestionCollection questionCollection){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",questionCollection.getUser_Id());
        param.add("question_Id",questionCollection.getQuestion_Id());
        if (restTemplate.postForObject(REST_URL_PREFIX + "/delete", param, int.class) == 1) {
            object.put("code",1);
            object.put("message","删除成功！");
        } else {
            object.put("code",0);
            object.put("message","删除失败，请重试！");
        }
        return object;
    }

    @RequestMapping("/verification")
    @ResponseBody
    public JSON verification (QuestionCollection questionCollection){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",questionCollection.getUser_Id());
        param.add("question_Id",questionCollection.getQuestion_Id());
        if (restTemplate.postForObject(REST_URL_PREFIX + "/delete", param, int.class) == 1) {
            object.put("code",1);
            object.put("message","该试题已收藏！");
        } else {
            object.put("code",0);
            object.put("message","该试题未收藏！");
        }
        return object;
    }

    @RequestMapping("/select")
    @ResponseBody
    public JSON select(@RequestParam("user_Id")String user_Id,
                       @RequestParam("cou_Id")String cou_Id,
                       @RequestParam("type_Id")String type_Id,
                       @RequestParam("current")int current,
                       @RequestParam("length")int length){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("user_Id",user_Id);
        param.add("cou_Id",cou_Id);
        param.add("type_Id",type_Id);
        param.add("current",current);
        param.add("length",length);
        if (restTemplate.postForObject(REST_URL_PREFIX + "/select", param, List.class) != null) {
            object.put("code",1);
            object.put("message","查询成功！");
            object.put("data",restTemplate.postForObject(REST_URL_PREFIX + "/select", param, List.class));
        } else {
            object.put("code",0);
            object.put("message","查询失败！");
            object.put("data",null);
        }
        return object;
    }

}
