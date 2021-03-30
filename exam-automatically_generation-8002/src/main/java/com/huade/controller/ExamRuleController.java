package com.huade.controller;

import com.huade.pojo.Exam_Rule;
import com.huade.service.ExamRuleService;
import com.huade.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/ExamRule")
public class ExamRuleController {

    @Autowired
    private ExamRuleService examRuleService;

    @RequestMapping("/addExamRule")
    @ResponseBody
    public int addExamRule(@RequestParam("ruleName")String ruleName,
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
        Exam_Rule exam_rule = new Exam_Rule();
        String Id = UUID.randomUUID().toString().replace("-","");
        String exam_Id = UUID.randomUUID().toString().replace("-","");
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String rule_Time = temp.format(date);
        exam_rule.setId(Id);
        exam_rule.setExam_Id(exam_Id);
        exam_rule.setRule_Time(rule_Time);
        exam_rule.setCou_Id(cou_Id);
        exam_rule.setDifficulty(difficulty);
        exam_rule.setTotalMark(totalMark);
        exam_rule.setRule_Name(ruleName.equals("") ? exam_rule.getId() : ruleName);
        if (singleNum == null ||singleNum.equals("")) {
            exam_rule.setSingleNum("0");
            exam_rule.setSingleScore("0");
        }else {
            exam_rule.setSingleNum(singleNum);
            exam_rule.setSingleScore(singleScore);
        }
        if (completeNum == null || completeNum.equals("")) {
            exam_rule.setCompleteNum("0");
            exam_rule.setCompleteScore("0");
        }else {
            exam_rule.setCompleteNum(completeNum);
            exam_rule.setCompleteScore(completeScore);
        }
        if (subjectNum == null || singleNum.equals("")) {
            exam_rule.setSubjectNum("0");
            exam_rule.setSubjectScore("0");
        } else {
            exam_rule.setSubjectNum(subjectNum);
            exam_rule.setSubjectScore(subjectScore);
        }
        exam_rule.setPointIds(pointIds);
        return examRuleService.addExamRule(exam_rule);
    }

}
