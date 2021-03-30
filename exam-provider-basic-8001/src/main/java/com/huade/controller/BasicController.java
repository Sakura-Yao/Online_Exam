package com.huade.controller;

import com.huade.pojo.*;
import com.huade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private ClassCourseInfoService classCourseInfoService;

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @Autowired
    private CollegeInfoService collegeInfoService;

    @Autowired
    private SpecialtyInfoService specialtyInfoService;

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("/selectAllTeachCourse")
    @ResponseBody
    public List<View_Teacher_Class_Info> SelectAllTeachCourse(@RequestParam("user_Id")String user_Id,
                                                              @RequestParam("cou_Name")String cou_Name,
                                                              @RequestParam("current")String current,
                                                              @RequestParam("length")String length){
        return classCourseInfoService.selectAllTeachCourse(user_Id,cou_Name,Integer.parseInt(current),Integer.parseInt(length));
    }

    @RequestMapping("/selectAllTeachClasses")
    @ResponseBody
    public List<View_Teacher_Class_Info> SelectAllTeachClasses(@RequestParam("user_Id")String user_Id){
        return classCourseInfoService.selectAllTeachClasses(user_Id);
    }

    @RequestMapping("/selectAllKnowledge")
    @ResponseBody
    public List<View_Knowledge> SelectAllKnowledge(@RequestParam("cou_Id")String cou_Id,
                                                   @RequestParam("kwl_Level")String kwl_Level,
                                                   @RequestParam("chapter_Num")String chapter_Num){
        return knowledgeService.selectKnowledge("",cou_Id,kwl_Level,chapter_Num,"",0,0);
    }

    @RequestMapping("/selectTeachClasses_course")
    @ResponseBody
    public List<String> SelectTeachClasses_course (@RequestParam("user_Id")String user_Id,
                                                   @RequestParam("cou_Id")String cou_Id){
        return classCourseInfoService.selectTeachClasses_course(user_Id, cou_Id);
    }

    @RequestMapping("/selectQuestionType")
    @ResponseBody
    public List<Question_Type> SelectQuestionType(){
        return questionTypeService.selectAllQuestionType();
    }

    @RequestMapping("/selectCollegeInfo")
    @ResponseBody
    public List<CollegeInfo> SelectCollegeInfo(@RequestParam("col_Id")String col_Id){
        return collegeInfoService.selectCollegeInfo(col_Id);
    }

    @RequestMapping("/selectSpecialtyInfo")
    @ResponseBody
    public List<Specialty> SelectSpecialtyInfo(@RequestParam("col_Id")String col_Id){
        return specialtyInfoService.selectSpecialty_col_Id(col_Id);
    }

    @RequestMapping("/selectClassesInfo")
    @ResponseBody
    public List<ClassInfo> SelectClassesInfo(@RequestParam("Id")String Id,
                                             @RequestParam("cou_Id")String cou_Id,
                                             @RequestParam("spe_Id")String spe_Id,
                                             @RequestParam("current")String current,
                                             @RequestParam("length")String length){
        return classInfoService.selectClassInfo(Id,cou_Id,spe_Id,Integer.parseInt(current),Integer.parseInt(length));
    }
}
