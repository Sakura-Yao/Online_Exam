package com.huade.service;

import com.huade.pojo.CollegeInfo;

import java.util.List;

public interface CollegeInfoService {

    int addCollegeInfo (CollegeInfo collegeInfo);

    int deleteCollegeInfo (String col_Id);

    int updateCollegeInfo (CollegeInfo collegeInfo);

    List<CollegeInfo> selectAllCollegeInfo();

    List<CollegeInfo> selectCollegeInfo(String col_Id);

    String selectCol_Id(String col_Name);

}
