package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.pojo.Course;
import com.huade.pojo.View_CourseInfo;
import com.huade.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/addCourseInfo")
    @ResponseBody
    public int addCourseInfo(@RequestParam("cou_Name") String cou_Name, @RequestParam("spe_Id") String spe_Id){
        Course course = new Course(UtilTools.RandomCourseId(),cou_Name,spe_Id);
        return courseService.addCourseInfo(course);
    }

    @RequestMapping("/makeBatchAddCourseInfo")
    @ResponseBody
    public String makeBatchAddCourseInfo(@RequestParam("filePath")String filePath,
                                         @RequestParam("fileName")String fileName){
        return UtilTools.MakeBatchAddCourseInfo(filePath,fileName);
    }

    @RequestMapping("/batchCourseInfo")
    @ResponseBody
    public Map batchCourseInfo (@RequestParam("filePath")String filePath){
        Map res = new HashMap();
        try {
            res = UtilTools.BatchAddCourseInfo(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @RequestMapping("/deleteCourseInfo")
    @ResponseBody
    public int deleteCourseInfo(@RequestParam("cou_Id") String cou_Id) {
        return courseService.deleteCourseInfo(cou_Id);
    }

    @RequestMapping("/updateCourseInfo")
    @ResponseBody
    public int updateCourseInfo(@RequestParam("Id") String Id,@RequestParam("cou_Name") String cou_Name,@RequestParam("spe_Id") String spe_Id){
        Course course = new Course(Id,cou_Name,spe_Id);
        return courseService.updateCourseInfo(course);
    }

    @RequestMapping("/selectAllCourseInfo")
    @ResponseBody
    public List<Course> selectAllCourseInfo(@RequestParam("current") int current, @RequestParam("length") int length){
        return courseService.selectAllCourseInfo(current, length);
    }

    @RequestMapping("/selectCourseInfo")
    @ResponseBody
    public List<View_CourseInfo> selectCourseInfo(@RequestParam("cou_Id")String cou_Id,
                                                  @RequestParam("cou_Name")String cou_Name,
                                                  @RequestParam("col_Id")String col_Id,
                                                  @RequestParam("spe_Id") String spe_Id,
                                                  @RequestParam("current") String current, @RequestParam("length") String length){
        return courseService.selectCourseInfo(cou_Id,cou_Name,col_Id,spe_Id, Integer.parseInt(current), Integer.parseInt(length));
    }




}
