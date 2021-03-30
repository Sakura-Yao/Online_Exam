package com.huade.mapper;

import com.huade.pojo.Course;
import com.huade.pojo.View_CourseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CourseMapper {

    int addCourseInfo(Course course);

    int batchAddCourseInfo(List<Map<String,Object>> courseInfoList) throws Exception;

    int deleteCourseInfo (@Param("Id")String Id);

    int updateCourseInfo (Course course);

    List<Course> selectAllCourseInfo(@Param("current")int current,@Param("length") int length);

    List<View_CourseInfo> selectCourseInfo(@Param("cou_Id")String cou_Id,
                                           @Param("cou_Name")String cou_Name,
                                           @Param("col_Id")String col_Id,
                                           @Param("spe_Id")String spe_Id,
                                           @Param("current")int current, @Param("length") int length);

}
