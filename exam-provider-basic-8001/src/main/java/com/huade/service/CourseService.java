package com.huade.service;

import com.huade.pojo.Course;
import com.huade.pojo.View_CourseInfo;

import java.util.List;
import java.util.Map;

public interface CourseService {

    int addCourseInfo(Course course);

    int batchAddCourseInfo(List<Map<String,Object>> courseInfoList) throws Exception;

    int deleteCourseInfo (String Id);

    int updateCourseInfo (Course course);

    List<Course> selectAllCourseInfo(int current, int length);

    List<View_CourseInfo> selectCourseInfo(String cou_Id,
                                           String cou_Name,
                                           String col_Id,
                                           String spe_Id,
                                           int current, int length);

}
