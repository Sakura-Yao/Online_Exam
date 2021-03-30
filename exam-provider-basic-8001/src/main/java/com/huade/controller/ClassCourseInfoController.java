package com.huade.controller;

import com.huade.pojo.ClassCourseInfo;
import com.huade.pojo.View_Teacher_Class_Info;
import com.huade.service.ClassCourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classCourseInfo")
public class ClassCourseInfoController {
    @Autowired
    private ClassCourseInfoService classCourseInfoService;

    @RequestMapping("/addClassCourseInfo")
    @ResponseBody
    public int addClassCourseInfo(@RequestParam("classes_Id") String classes_Id, @RequestParam("user_Id") String user_Id, @RequestParam("cou_Id") String cou_Id){
        ClassCourseInfo classCourseInfo = new ClassCourseInfo(classes_Id, user_Id, cou_Id);
        return classCourseInfoService.addClassCourseInfo(classCourseInfo);
    }

    @RequestMapping("/deleteClassCourseInfo")
    @ResponseBody
    public int deleteClassCourseInfo(@RequestParam("classes_Id") String classes_Id,@RequestParam("user_Id") String user_Id,@RequestParam("cou_Id") String cou_Id){
        ClassCourseInfo classCourseInfo = new ClassCourseInfo(classes_Id, user_Id, cou_Id);
        return classCourseInfoService.deleteClassCourseInfo(classCourseInfo);
    }

    @RequestMapping("/updateClassCourseInfo")
    @ResponseBody
    public int updateClassCourseInfo(@RequestParam("new_classes_Id") String new_classes_Id,@RequestParam("new_user_Id") String new_user_Id,@RequestParam("new_cou_Id") String new_cou_Id,@RequestParam("old_classes_Id") String old_classes_Id,@RequestParam("old_user_Id") String old_user_Id,@RequestParam("old_cou_Id") String old_cou_Id){
        ClassCourseInfo new_classCourseInfo = new ClassCourseInfo(new_classes_Id, new_user_Id, new_cou_Id);
        ClassCourseInfo old_classCourseInfo = new ClassCourseInfo(old_classes_Id, old_user_Id, old_cou_Id);
        return classCourseInfoService.updateClassCourseInfo(new_classCourseInfo,old_classCourseInfo);
    }


    @RequestMapping("/selectAllClassCourseInfo")
    @ResponseBody
    public List<View_Teacher_Class_Info> selectAllClassCourseInfo(@RequestParam("current") int current, @RequestParam("length") int length){
        return classCourseInfoService.selectAllClassCourseInfo(current, length);
    }

    @RequestMapping("/selectClassCourseInfo")
    @ResponseBody
    public List<View_Teacher_Class_Info> selectClassCourseInfo(@RequestParam("class_Id") String class_Id,@RequestParam("user_Id") String user_Id,@RequestParam("cou_Id") String cou_Id,@RequestParam("current") int current,@RequestParam("length") int length){
        String[] class_Ids = new String[]{};
        if (!class_Id.equals("")){
            class_Ids = class_Id.split(",");
        }
        return classCourseInfoService.selectClassCourseInfo(class_Ids,user_Id,cou_Id,current,length);
    }



}
