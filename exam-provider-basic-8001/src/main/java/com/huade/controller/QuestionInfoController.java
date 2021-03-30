package com.huade.controller;

import com.huade.pojo.QuestionInfo;
import com.huade.pojo.View_Question_Info;
import com.huade.service.QuestionInfoService;
import com.huade.service.QuestionInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/question")
public class QuestionInfoController {
    
    @Autowired
    private QuestionInfoService questionInfoService;

    @RequestMapping("/selectQuestionInfo")
    @ResponseBody
    public List<View_Question_Info> SelectQuestionInfo(@RequestParam("question_Id")String question_Id,
                                                       @RequestParam("cou_Id")String cou_Id,
                                                       @RequestParam("type_Id")String type_Id,
                                                       @RequestParam("subject")String subject,
                                                       @RequestParam("degree")String degree,
                                                       @RequestParam("kwl_Id")String kwl_Id,
                                                       @RequestParam("current")String current,
                                                       @RequestParam("length")String length){
        return questionInfoService.selectQuestionInfo_keyWords(question_Id, cou_Id, type_Id, subject, degree, kwl_Id, Integer.parseInt(current), Integer.parseInt(length));
    }

    @RequestMapping("/addQuestionInfo")
    @ResponseBody
    public int AddQuestionInfo(@RequestParam("cou_Id")String cou_Id,
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
        String id = UUID.randomUUID().toString().replace("-","");
        QuestionInfo questionInfo = new QuestionInfo(id,cou_Id,type_Id,subject,choice_A,choice_B,choice_C,choice_D,answer,degree,kwl_Id,analysis);
        return questionInfoService.addQuestionInfo(questionInfo);
    }

    @RequestMapping("/updateQuestionInfo")
    @ResponseBody
    public int UpdateQuestionInfo(@RequestParam("Id")String Id,
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
        QuestionInfo questionInfo = new QuestionInfo(Id,cou_Id,type_Id,subject,choice_A,choice_B,choice_C,choice_D,answer,degree,kwl_Id,analysis);
        return questionInfoService.updateQuestionInfo(questionInfo);
    }

    @RequestMapping("/showCountNum")
    @ResponseBody
    public String ShowCountNum(@RequestParam("question_Id")String question_Id,
                               @RequestParam("cou_Id")String cou_Id,
                               @RequestParam("type_Id")String type_Id,
                               @RequestParam("subject")String subject,
                               @RequestParam("degree")String degree,
                               @RequestParam("kwl_Id")String kwl_Id){
        return questionInfoService.showCountNum(question_Id, cou_Id, type_Id, subject, degree, kwl_Id);
    }

}
