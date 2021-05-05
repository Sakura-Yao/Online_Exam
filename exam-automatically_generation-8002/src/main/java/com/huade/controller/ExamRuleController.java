package com.huade.controller;

import com.huade.pojo.*;
import com.huade.service.ExamRuleService;
import com.huade.utils.GA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ExamRule")
public class ExamRuleController {

    @Autowired
    private ExamRuleService examRuleService;

    @RequestMapping("/addExamRule")
    @ResponseBody
    public int addExamRule(Exam_Rule exam_rule){
        return examRuleService.addExamRule(exam_rule);
    }

    @RequestMapping("/selectExamRule")
    @ResponseBody
    public LayuiResult selectExamRule(){
        return examRuleService.select();
    }

    @RequestMapping("/GA")
    @ResponseBody
    public GAPaper GA(@RequestParam("Id")String id){
        Exam_Rule exam_rule = examRuleService.selectExamRule(id);
        Rule rule = new Rule();
        List<String> pointIds = Arrays.asList(exam_rule.getPointIds().split(","));
        rule.setId(exam_rule.getId());
        rule.setCou_Id(exam_rule.getCou_Id());
        rule.setExamId(exam_rule.getExam_Id());
        rule.setRule_Name(exam_rule.getRule_Name());
        rule.setTotalMark(Double.parseDouble(exam_rule.getTotalMark()));
        rule.setDifficulty(Double.parseDouble(exam_rule.getDifficulty()));
        rule.setSingleNum(Integer.parseInt(exam_rule.getSingleNum()));
        rule.setSingleScore(Double.parseDouble(exam_rule.getSingleScore()));
        rule.setCompleteNum(Integer.parseInt(exam_rule.getCompleteNum()));
        rule.setCompleteScore(Double.parseDouble(exam_rule.getCompleteScore()));
        rule.setJudgeNum(Integer.parseInt(exam_rule.getJudgeNum()));
        rule.setJudgeScore(Double.parseDouble(exam_rule.getJudgeScore()));
        rule.setSubjectNum(Integer.parseInt(exam_rule.getSubjectNum()));
        rule.setSubjectScore(Double.parseDouble(exam_rule.getSubjectScore()));
        rule.setNounNum(Integer.parseInt(exam_rule.getNounNum()));
        rule.setNounSore(Double.parseDouble(exam_rule.getNounScore()));
        rule.setFillcodeNum(Integer.parseInt(exam_rule.getFillcodeNum()));
        rule.setFillcodeScore(Double.parseDouble(exam_rule.getFillcodeScore()));
        rule.setCodingNum(Integer.parseInt(exam_rule.getCodingNum()));
        rule.setCodingScore(Double.parseDouble(exam_rule.getCodingScore()));
        rule.setPointIds(pointIds);
        rule.setRule_Time(exam_rule.getRule_Time());
        Paper res = GA.AutoMakePaper(rule);
        GAPaper gaPaper = new GAPaper();
        gaPaper.setId(res.getId());
        gaPaper.setAdaptationDegree(res.getAdaptationDegree());
        gaPaper.setDifficulty(res.getDifficulty());
        gaPaper.setKPCoverage(res.getKPCoverage());
        gaPaper.setTotalScore(res.getTotalScore());
        gaPaper.setQuestionList(res.getQuestionList());
        return gaPaper;
    }
//    public int addExamRule(@RequestParam("ruleName")String ruleName,
//                           @RequestParam("cou_Id")String cou_Id,
//                           @RequestParam("classes")String classes,
//                           @RequestParam("totalMark")String totalMark,
//                           @RequestParam("difficulty")String difficulty,
//                           @RequestParam("singleNum")String singleNum,
//                           @RequestParam("singleScore")String singleScore,
//                           @RequestParam("completeNum")String completeNum,
//                           @RequestParam("completeScore")String completeScore,
//                           @RequestParam("judgeNum")String judgeNum,
//                           @RequestParam("judgeScore")String judgeScore,
//                           @RequestParam("nounNum")String nounNum,
//                           @RequestParam("nounScore")String nounScore,
//                           @RequestParam("subjectNum")String subjectNum,
//                           @RequestParam("subjectScore")String subjectScore,
//                           @RequestParam("fillcodeNum")String fillcodeNum,
//                           @RequestParam("fillcodeScore")String fillcodeScore,
//                           @RequestParam("codingNum")String codingNum,
//                           @RequestParam("codingScore")String codingScore,
//                           @RequestParam("pointIds")String pointIds){
//        Exam_Rule exam_rule = new Exam_Rule(ruleName,cou_Id,classes,totalMark,difficulty,singleNum,singleScore,completeNum,completeScore,
//                judgeNum,judgeScore,nounNum,nounScore,subjectNum,subjectScore,fillcodeNum,fillcodeScore,codingNum,codingScore,pointIds);
//        return examRuleService.addExamRule(exam_rule);
//    }
}
