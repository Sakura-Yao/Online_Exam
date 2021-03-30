package com.huade.mapper;

import com.huade.Utils.UpdatePeopleCount;
import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ClassInfoMapper {

    int addClassInfo (ClassInfo classInfo);

    int batchAddClassInfo(List<Map<String ,Object>> classInfoList) throws Exception;

    int updateClassInfo (ClassInfo classInfo);

    int deleteClassInfo (String Id);

    List<View_ClassInfo> select_classInfo_keywords(@Param("Id")String Id,
                                                   @Param("class_Id")String class_Id,
                                                   @Param("col_Id")String col_Id,
                                                   @Param("spe_Id") String spe_Id,
                                                   @Param("current")int current,
                                                   @Param("length") int length);

    List<ClassInfo> selectClassInfo(@Param("Id")String Id,
                                    @Param("col_Id")String col_Id,@Param("spe_Id") String spe_Id,@Param("current")int current,@Param("length") int length);

    List<View_ClassInfo> selectAllClassInfo();

    String selectId(@Param("class_Id")String class_Id);

    String showCountNum(@Param("Id")String Id,
                        @Param("class_Id")String class_Id,
                        @Param("col_Id")String col_Id,
                        @Param("spe_Id")String spe_Id);

    List<String> selectClassStudentsCount();

    List<String> selectClassStudentsCount_classId();

    int updateClassStudentCount(@Param("Id")String Id,
                                @Param("people_Num")String people_Num);

    int updateClassStudentsCount();
}
