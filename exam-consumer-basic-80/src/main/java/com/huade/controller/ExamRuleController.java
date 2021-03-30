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

@Controller
public class ExamRuleController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002/ExamRule";

    @RequestMapping("/addExamRule")
    @ResponseBody
    public JSON addExamRule(@RequestParam("ruleName")String ruleName,
                            @RequestParam("cou_Id")String cou_Id,
                            @RequestParam("totalMark")String totalMark,
                            @RequestParam("difficulty")String difficulty,
                            @RequestParam("singleNum")String singleNum,
                            @RequestParam("singleScore")String singleScore,
                            @RequestParam("completeNum")String completeNum,
                            @RequestParam("completeScore")String completeScore,
                            @RequestParam("subjectNum")String subjectNum,
                            @RequestParam("subjectScore")String subjectScore,
                            @RequestParam("pointIds") String pointIds){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("ruleName",ruleName);
        param.add("cou_Id",cou_Id);
        param.add("totalMark",totalMark);
        param.add("difficulty",difficulty);
        param.add("singleNum",singleNum);
        param.add("singleScore",singleScore);
        param.add("completeNum",completeNum);
        param.add("completeScore",completeScore);
        param.add("subjectNum",subjectNum);
        param.add("subjectScore",subjectScore);
        param.add("pointIds",pointIds);
        if (restTemplate.postForObject(REST_URL_PREFIX+"/addExamRule",param,int.class) == 1) {
            object.put("code",1);
            object.put("message","添加命题计划成功！");
        } else {
            object.put("code",0);
            object.put("message","命题计划添加失败！");
        }
        return object;
    }


}
