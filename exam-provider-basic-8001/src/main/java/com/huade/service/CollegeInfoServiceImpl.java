package com.huade.service;

import com.huade.mapper.CollegeInfoMapper;
import com.huade.pojo.CollegeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeInfoServiceImpl implements CollegeInfoService {

    @Autowired
    private CollegeInfoMapper collegeInfoMapper;

    public void setCollegeInfoMapper(CollegeInfoMapper collegeInfoMapper) {
        this.collegeInfoMapper = collegeInfoMapper;
    }

    @Override
    public int addCollegeInfo(CollegeInfo collegeInfo) {
        return collegeInfoMapper.addCollegeInfo(collegeInfo);
    }

    @Override
    public int deleteCollegeInfo(String col_Id) {
        return collegeInfoMapper.deleteCollegeInfo(col_Id);
    }

    @Override
    public int updateCollegeInfo(CollegeInfo collegeInfo) {
        return collegeInfoMapper.updateCollegeInfo(collegeInfo);
    }

    @Override
    public List<CollegeInfo> selectAllCollegeInfo() {
        return collegeInfoMapper.selectAllCollegeInfo();
    }

    @Override
    public List<CollegeInfo> selectCollegeInfo(String col_Id) {
        return collegeInfoMapper.selectCollegeInfo(col_Id);
    }

    @Override
    public String selectCol_Id(String col_Name) {
        return collegeInfoMapper.selectCol_Id(col_Name);
    }
}
