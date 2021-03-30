package com.huade.mapper;

import com.huade.pojo.CollegeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeInfoMapper {

    int addCollegeInfo (CollegeInfo collegeInfo);

    int deleteCollegeInfo (@Param("col_Id")String col_Id);

    int updateCollegeInfo (CollegeInfo collegeInfo);

    List<CollegeInfo> selectAllCollegeInfo();

    List<CollegeInfo> selectCollegeInfo(@Param("col_Id")String col_Id);

    String selectCol_Id(@Param("col_Name")String col_Name);
}

