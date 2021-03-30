package com.huade.service;

import com.huade.mapper.TeacherBasicMapper;
import com.huade.pojo.Teacher_Basic;
import com.huade.pojo.View_TeacherBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherBasicServiceImpl implements TeacherBasicService {

    @Autowired
    private TeacherBasicMapper teacherBasicMapper;

    public void setTeacherBasicMapper(TeacherBasicMapper teacherBasicMapper) {
        this.teacherBasicMapper = teacherBasicMapper;
    }

    @Override
    public int addTeacherBasicInfo(Teacher_Basic teacher_basic) {
        return teacherBasicMapper.addTeacherBasicInfo(teacher_basic);
    }

    @Override
    public int deleteTeacherBasicInfo(String user_Id) {
        return teacherBasicMapper.deleteTeacherBasicInfo(user_Id);
    }

    @Override
    public int updateTeacherBasicInfo(Teacher_Basic teacher_basic) {
        return teacherBasicMapper.updateTeacherBasicInfo(teacher_basic);
    }

    @Override
    public List<Teacher_Basic> selectAllTeacherBasic(int current, int length) {
        return teacherBasicMapper.selectAllTeacherBasic(current, length);
    }

    @Override
    public List<View_TeacherBasicInfo> selectTeacherBasic(String user_Id, String user_Name, String col_Id, String spe_Id, int current, int length) {
        return teacherBasicMapper.selectTeacherBasic(user_Id, user_Name, col_Id, spe_Id, current, length);
    }

    @Override
    public int batchAddTeacherBasicInfo(List<Map<String, Object>> teacherBasicList) throws Exception {
        return teacherBasicMapper.batchAddTeacherBasicInfo(teacherBasicList);
    }
}
