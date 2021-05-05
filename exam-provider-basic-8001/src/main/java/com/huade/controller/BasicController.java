package com.huade.controller;

import com.huade.Utils.LayuiMessage;
import com.huade.pojo.*;
import com.huade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @RequestMapping("/xmCourses")
    @ResponseBody
    public ArrayList<XM_Courses> XMCourses(@RequestParam("user_Id")String user_Id,
                                           @RequestParam("cou_Name")String cou_Name,
                                           @RequestParam("current")String current,
                                           @RequestParam("length")String length){
        ArrayList<XM_Courses> res = new ArrayList<>();
        List<View_Teacher_Class_Info> view_teacher_class_infos = classCourseInfoService.selectAllTeachCourse(user_Id, cou_Name, Integer.parseInt(current), Integer.parseInt(length));
        for (View_Teacher_Class_Info item : view_teacher_class_infos) {
            XM_Courses res_item = new XM_Courses();
            res_item.setName(item.getCou_Name());
            res_item.setValue(item.getCou_Id());
            res_item.setSelected(false);
            res.add(res_item);
        }
        return res;
    }

    @RequestMapping("/selectAllTeachClasses")
    @ResponseBody
    public List<View_Teacher_Class_Info> SelectAllTeachClasses(@RequestParam("user_Id")String user_Id){
        return classCourseInfoService.selectAllTeachClasses(user_Id);
    }

    @RequestMapping("/xmClasses")
    @ResponseBody
    public ArrayList<XM_Classes> XMClasses(@RequestParam("user_Id")String user_Id){
        List<View_Teacher_Class_Info> view_teacher_class_infos = classCourseInfoService.selectAllTeachClasses(user_Id);
        ArrayList<XM_Classes> res = new ArrayList<>();
        for (View_Teacher_Class_Info view_teacher_class_info : view_teacher_class_infos) {
            XM_Classes res_item = new XM_Classes();
            res_item.setName(view_teacher_class_info.getClass_Id());
            res_item.setValue(view_teacher_class_info.getClass_Id());
            res_item.setSelected(false);
            res.add(res_item);
        }
        return res;
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

    @RequestMapping(value = "/testSelectInfo",method = RequestMethod.GET)
    @ResponseBody
    public LayuiMessage test(@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(required = false,defaultValue = "15") Integer limit){
        return classInfoService.getClassinfoList(page, limit);
    }



}
