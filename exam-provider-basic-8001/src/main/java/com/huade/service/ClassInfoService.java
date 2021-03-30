package com.huade.service;

import com.huade.Utils.UpdatePeopleCount;
import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;

import java.util.List;
import java.util.Map;

public interface ClassInfoService {

    int addClassInfo (ClassInfo classInfo);

    int batchAddClassInfo(List<Map<String ,Object>> classInfoList) throws Exception;

    int updateClassInfo (ClassInfo classInfo);

    int deleteClassInfo (String Id);

    List<View_ClassInfo> select_classInfo_keywords(String Id,String class_Id,String col_Id,String spe_Id,int current,int length);

    List<ClassInfo> selectClassInfo(String Id,String col_Id,String spe_Id,int current,int length);

    List<View_ClassInfo> selectAllClassInfo();

    String selectId(String class_Id);

    String showCountNum(String Id,String class_Id,String col_Id,String spe_Id);

    List<String> selectClassStudentsCount();

    List<String> selectClassStudentsCount_classId();

    int updateClassStudentCount(String Id,String people_Num);

}
