package com.huade.controller;

import com.huade.utils.GA;
import com.huade.pojo.Paper;
import com.huade.pojo.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public Paper test(@RequestParam("ruleName")String ruleName,
                      @RequestParam("cou_Id")String cou_Id,
                      @RequestParam("totalMark")String totalMark,
                      @RequestParam("difficulty")String difficulty,
                      @RequestParam("singleNum")String singleNum,
                      @RequestParam("singleScore")String singleScore,
                      @RequestParam("completeNum")String completeNum,
                      @RequestParam("completeScore")String completeScore,
                      @RequestParam("subjectNum")String subjectNum,
                      @RequestParam("subjectScore")String subjectScore,
                      @RequestParam("pointIds") List<String> pointIds){
        Rule rule = new Rule();
        rule.setId(UUID.randomUUID().toString().replace("-",""));
        rule.setExamId(UUID.randomUUID().toString().replace("-",""));
        rule.setRule_Name(Objects.equals(ruleName, "") ?rule.getId():ruleName);
        System.out.println(rule.getRule_Name());
        rule.setCou_Id(cou_Id);
        rule.setTotalMark(Double.parseDouble(totalMark));
        rule.setDifficulty(Double.parseDouble(difficulty));
        if (singleNum == null ||singleNum.equals("")) {
            rule.setSingleNum(0);
            rule.setSingleScore(0);
        }else {
            rule.setSingleNum(Integer.parseInt(singleNum));
            rule.setSingleScore(Double.parseDouble(singleScore));
        }
        if (completeNum == null || completeNum.equals("")) {
            rule.setCompleteNum(0);
            rule.setCompleteScore(0);
        }else {
            rule.setCompleteNum(Integer.parseInt(completeNum));
            rule.setCompleteScore(Double.parseDouble(completeScore));
        }
        if (subjectNum == null || singleNum.equals("")) {
            rule.setSubjectNum(0);
            rule.setSubjectScore(0);
        } else {
            rule.setSubjectNum(Integer.parseInt(subjectNum));
            rule.setSubjectScore(Double.parseDouble(subjectScore));
        }
        rule.setPointIds(pointIds);
        return GA.AutoMakePaper(rule);
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(@RequestParam("test1")String test1){
        System.out.println(test1.equals(""));
        return test1;
    }

}
