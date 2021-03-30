package com.huade.controller;

import com.huade.pojo.Course;
import com.huade.pojo.View_CourseInfo;
import com.huade.pojo.View_StudentBasicInfo;
import com.huade.pojo.View_Teacher_Class_Info;
import com.huade.service.ClassCourseInfoService;
import com.huade.service.CourseService;
import com.huade.service.StudentBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Study")
public class StudentStudyController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassCourseInfoService classCourseInfoService;

    @Autowired
    private StudentBasicService studentBasicService;

    @RequestMapping("/getStudentCourses")
    @ResponseBody
    public List<View_Teacher_Class_Info> getStudentCourses (@RequestParam("Id")String Id){
        String [] classId = new String[1];
        classId[0] = studentBasicService.selectStudentBasicInfo_studentId(Id);
        return classCourseInfoService.selectClassCourseInfo(classId, "", "", -1, -1);
    }

}
