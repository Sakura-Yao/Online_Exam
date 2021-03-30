package com.huade.mapper;

import com.huade.pojo.Teacher_Basic;
import com.huade.pojo.View_TeacherBasicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TeacherBasicMapper {
    
    int addTeacherBasicInfo(Teacher_Basic teacher_basic);

    int batchAddTeacherBasicInfo(List<Map<String ,Object>> teacherBasicList) throws Exception;


    int deleteTeacherBasicInfo(@Param("user_Id")String user_Id);
    
    int updateTeacherBasicInfo(Teacher_Basic teacher_basic);
    
    List<Teacher_Basic> selectAllTeacherBasic(@Param("current")int current,@Param("length") int length);
    
    List<View_TeacherBasicInfo> selectTeacherBasic(@Param("user_Id")String user_Id,
                                                   @Param("user_Name")String user_Name,
                                                   @Param("col_Id")String col_Id,
                                                   @Param("spe_Id")String spe_Id,
                                                   @Param("current")int current, @Param("length") int length);
    
}
