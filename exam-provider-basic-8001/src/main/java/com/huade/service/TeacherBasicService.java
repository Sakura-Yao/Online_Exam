package com.huade.service;

import com.huade.pojo.Teacher_Basic;
import com.huade.pojo.View_TeacherBasicInfo;

import java.util.List;
import java.util.Map;

public interface TeacherBasicService {

    int addTeacherBasicInfo(Teacher_Basic teacher_basic);

    int deleteTeacherBasicInfo(String user_Id);

    int updateTeacherBasicInfo(Teacher_Basic teacher_basic);

    List<Teacher_Basic> selectAllTeacherBasic(int current, int length);

    List<View_TeacherBasicInfo> selectTeacherBasic(String user_Id, String user_Name, String col_Id, String spe_Id,
                                                   int current, int length);

    int batchAddTeacherBasicInfo(List<Map<String ,Object>> teacherBasicList) throws Exception;


}
