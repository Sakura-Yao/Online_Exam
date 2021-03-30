package com.huade.mapper;

import com.huade.pojo.ClassCourseInfo;
import com.huade.pojo.View_Teacher_Class_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassCourseInfoMapper {

    int addClassCourseInfo(ClassCourseInfo classCourseInfo);

    int deleteClassCourseInfo(ClassCourseInfo classCourseInfo);

    int updateClassCourseInfo (@Param("new_ClassCourseInfo") ClassCourseInfo new_ClassCourseInfo,
                               @Param("old_ClassCourseInfo") ClassCourseInfo old_ClassCourseInfo);

    List<View_Teacher_Class_Info> selectAllClassCourseInfo(@Param("current")int current, @Param("length") int length);

    List<View_Teacher_Class_Info> selectClassCourseInfo(@Param("class_Id") String[] class_Id,
                                                      @Param("user_Id")String user_Id,
                                                      @Param("cou_Id")String cou_Id,
                                                      @Param("current")int current, @Param("length") int length);

    List<View_Teacher_Class_Info> selectAllTeachCourse(@Param("user_Id")String user_Id,
                                                       @Param("cou_Name")String cou_Name,
                                                       @Param("current")int current,
                                                       @Param("length")int length);

    List<View_Teacher_Class_Info> selectAllTeachClasses(@Param("user_Id")String user_Id);

    List<String> selectTeachClasses_course(@Param("user_Id")String user_Id,
                                   @Param("cou_Id")String cou_Id);
}
