package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.huade.pojo.Exam_Rule;
import com.huade.pojo.GAPaper;
import com.huade.pojo.LayuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/ExamRule")
public class ExamRuleController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002/ExamRule";

    @RequestMapping("/addExamRule")
    @ResponseBody
    public String addExamRule(Exam_Rule exam_rule){
        JSONObject object = new JSONObject();
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("rule_Name",exam_rule.getRule_Name());
        param.add("cou_Id",exam_rule.getCou_Id());
        param.add("classes",exam_rule.getClasses());
        param.add("totalMark",exam_rule.getTotalMark());
        param.add("difficulty",exam_rule.getDifficulty());
        param.add("singleNum",exam_rule.getSingleNum());
        param.add("singleScore",exam_rule.getSingleScore());
        param.add("completeNum",exam_rule.getCompleteNum());
        param.add("completeScore",exam_rule.getCompleteScore());
        param.add("judgeNum",exam_rule.getJudgeNum());
        param.add("judgeScore",exam_rule.getJudgeScore());
        param.add("nounNum",exam_rule.getNounNum());
        param.add("nounScore",exam_rule.getNounScore());
        param.add("subjectNum",exam_rule.getSubjectNum());
        param.add("subjectScore",exam_rule.getSubjectScore());
        param.add("fillcodeNum",exam_rule.getFillcodeNum());
        param.add("fillcodeScore",exam_rule.getFillcodeScore());
        param.add("codingNum",exam_rule.getCodingNum());
        param.add("codingScore",exam_rule.getCodingScore());
        param.add("pointIds",exam_rule.getPointIds());
        if (restTemplate.postForObject(REST_URL_PREFIX+"/addExamRule",param,Integer.class) == 1){
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("/selectExamRule")
    @ResponseBody
    public LayuiResult selectExamRule(@RequestParam("page")int page,
                                      @RequestParam("limit")int limit,
                                      @RequestParam("code")String code){
        System.out.println(page);
        System.out.println(limit);
        System.out.println(code);
        return restTemplate.postForObject(REST_URL_PREFIX+"/selectExamRule",null,LayuiResult.class);
    }

    @RequestMapping("/GA")
    @ResponseBody
    public GAPaper GA(@RequestParam("Id")String id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/GA",param,GAPaper.class);
    }
//    public JSON addExamRule(@RequestParam("ruleName")String ruleName,
//                            @RequestParam("cou_Id")String cou_Id,
//                            @RequestParam("totalMark")String totalMark,
//                            @RequestParam("difficulty")String difficulty,
//                            @RequestParam("singleNum")String singleNum,
//                            @RequestParam("singleScore")String singleScore,
//                            @RequestParam("completeNum")String completeNum,
//                            @RequestParam("completeScore")String completeScore,
//                            @RequestParam("subjectNum")String subjectNum,
//                            @RequestParam("subjectScore")String subjectScore,
//                            @RequestParam("pointIds") String pointIds){
//        JSONObject object = new JSONObject();
//        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
//        param.add("ruleName",ruleName);
//        param.add("cou_Id",cou_Id);
//        param.add("totalMark",totalMark);
//        param.add("difficulty",difficulty);
//        param.add("singleNum",singleNum);
//        param.add("singleScore",singleScore);
//        param.add("completeNum",completeNum);
//        param.add("completeScore",completeScore);
//        param.add("subjectNum",subjectNum);
//        param.add("subjectScore",subjectScore);
//        param.add("pointIds",pointIds);
//        if (restTemplate.postForObject(REST_URL_PREFIX+"/addExamRule",param,int.class) == 1) {
//            object.put("code",1);
//            object.put("message","添加命题计划成功！");
//        } else {
//            object.put("code",0);
//            object.put("message","命题计划添加失败！");
//        }
//        return object;
//    }


}
