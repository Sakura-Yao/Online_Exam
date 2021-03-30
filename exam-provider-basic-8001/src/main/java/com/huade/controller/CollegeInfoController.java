package com.huade.controller;

import com.huade.pojo.CollegeInfo;
import com.huade.service.CollegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/collegeInfo")
public class CollegeInfoController {
    @Autowired
    private CollegeInfoService collegeInfoService;

    @RequestMapping("/addCollegeInfo")
    @ResponseBody
    public int addCollegeInfo (@RequestParam("col_Name") String col_Name){
        String Id = UUID.randomUUID().toString().replace("-","");
        CollegeInfo collegeInfo = new CollegeInfo(Id,col_Name);
        return collegeInfoService.addCollegeInfo(collegeInfo);
    }

    @RequestMapping("/deleteCollegeInfo")
    @ResponseBody
    public int deleteCollegeInfo(@RequestParam("col_Id")String col_Id) {
        return collegeInfoService.deleteCollegeInfo(col_Id);
    }

    @RequestMapping("/updateCollegeInfo")
    @ResponseBody
    public int updateCollegeInfo(@RequestParam("Id")String Id,@RequestParam("col_Name")String col_Name){
        CollegeInfo collegeInfo = new CollegeInfo(Id,col_Name);
        return collegeInfoService.updateCollegeInfo(collegeInfo);
    }

    @RequestMapping("/selectAllCollegeInfo")
    @ResponseBody
    public List<CollegeInfo> SelectAllCollegeInfo() {
        return collegeInfoService.selectAllCollegeInfo();
    }



}
