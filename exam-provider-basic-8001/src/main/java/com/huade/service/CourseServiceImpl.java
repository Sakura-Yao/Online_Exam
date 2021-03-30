package com.huade.service;

import com.huade.mapper.CourseMapper;
import com.huade.pojo.Course;
import com.huade.pojo.View_CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public int addCourseInfo(Course course) {
        return courseMapper.addCourseInfo(course);
    }

    @Override
    public int batchAddCourseInfo(List<Map<String, Object>> courseInfoList) throws Exception {
        return courseMapper.batchAddCourseInfo(courseInfoList);
    }

    @Override
    public int deleteCourseInfo(String Id) {
        return courseMapper.deleteCourseInfo(Id);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateCourseInfo(course);
    }

    @Override
    public List<Course> selectAllCourseInfo(int current, int length) {
        return courseMapper.selectAllCourseInfo(current,length);
    }

    @Override
    public List<View_CourseInfo> selectCourseInfo(String cou_Id,
                                                  String cou_Name,
                                                  String col_Id,
                                                  String spe_Id,
                                                  int current, int length) {
        return courseMapper.selectCourseInfo(cou_Id, cou_Name, col_Id, spe_Id, current, length);
    }
}
