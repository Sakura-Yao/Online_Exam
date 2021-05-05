package com.huade.controller;

import com.huade.pojo.QuestionCollection;
import com.huade.pojo.View_QuestionCollection;
import com.huade.pojo.View_Question_Info;
import com.huade.service.QuestionCollectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questionCollection")
public class QuestionCollectionController {

    @Autowired
    private QuestionCollectionServiceImpl questionCollectionService;

    @RequestMapping("/add")
    @ResponseBody
    public int AddQuestionCollectionInfo(QuestionCollection questionCollection){
        return questionCollectionService.addQuestionCollectionInfo(questionCollection);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int DeleteQuestionCollectionInfo(@RequestParam("user_Id")String user_Id,
                                            @RequestParam("question_Id")String question_Id){
        return questionCollectionService.deleteQuestionCollectionInfo(user_Id,question_Id);
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<View_Question_Info> SelectQuestionCollectionInfos(@RequestParam("user_Id")String user_id,
                                                                            @RequestParam("cou_Id")String cou_id,
                                                                            @RequestParam("type_Id")String type_id,
                                                                            @RequestParam("current")int current,
                                                                            @RequestParam("length")int length){
        return questionCollectionService.selectQuestionCollectionInfos(user_id, cou_id, type_id, current, length);
    }

    @RequestMapping("/verification")
    @ResponseBody
    public int verification (@RequestParam("user_Id")String user_Id,
                             @RequestParam("question_Id")String question_Id){
        return questionCollectionService.verificationQuestionCollection(user_Id, question_Id);
    }

}
