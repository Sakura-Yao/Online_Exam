package com.huade.service;

import com.huade.mapper.ClassCourseInfoMapper;
import com.huade.pojo.ClassCourseInfo;
import com.huade.pojo.View_Teacher_Class_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.List;

@Service
public class ClassCourseInfoServiceImpl implements ClassCourseInfoService {

    @Autowired
    private ClassCourseInfoMapper classCourseInfoMapper;

    public void setClassCourseInfoMapper(ClassCourseInfoMapper classCourseInfoMapper) {
        this.classCourseInfoMapper = classCourseInfoMapper;
    }

    @Override
    public int addClassCourseInfo(ClassCourseInfo classCourseInfo) {
        return classCourseInfoMapper.addClassCourseInfo(classCourseInfo);
    }

    @Override
    public int deleteClassCourseInfo(ClassCourseInfo classCourseInfo) {
        return classCourseInfoMapper.deleteClassCourseInfo(classCourseInfo);
    }

    @Override
    public int updateClassCourseInfo(ClassCourseInfo new_ClassCourseInfo, ClassCourseInfo old_ClassCourseInfo) {
        return classCourseInfoMapper.updateClassCourseInfo(new_ClassCourseInfo,old_ClassCourseInfo);
    }

    @Override
    public List<View_Teacher_Class_Info> selectAllClassCourseInfo(int current, int length) {
        return classCourseInfoMapper.selectAllClassCourseInfo(current, length);
    }

    @Override
    public List<View_Teacher_Class_Info> selectClassCourseInfo(String[] class_Id, String user_Id, String cou_Id, int current, int length) {
        return classCourseInfoMapper.selectClassCourseInfo(class_Id, user_Id, cou_Id, current, length);
    }

    @Override
    public List<View_Teacher_Class_Info> selectAllTeachCourse(String user_Id,String cou_Name,int current,int length) {
        return classCourseInfoMapper.selectAllTeachCourse(user_Id,cou_Name,current,length);
    }

    @Override
    public List<View_Teacher_Class_Info> selectAllTeachClasses(String user_Id) {
        return classCourseInfoMapper.selectAllTeachClasses(user_Id);
    }

    @Override
    public List<String> selectTeachClasses_course(String user_Id, String cou_Id) {
        return classCourseInfoMapper.selectTeachClasses_course(user_Id, cou_Id);
    }
}
