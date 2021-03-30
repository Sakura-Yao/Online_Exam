package com.huade.controller;

import com.huade.pojo.Specialty;
import com.huade.service.SpecialtyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyInfoService specialtyInfoService;

    @RequestMapping("/addSpecialtyInfo")
    @ResponseBody
    public int addSpecialtyInfo(@RequestParam("spe_Name") String spe_Name, @RequestParam("cou_Id") String cou_Id) {
        String Id = UUID.randomUUID().toString().replace("-","");
        Specialty specialty = new Specialty(Id,spe_Name,cou_Id);
        return specialtyInfoService.addSpecialtyInfo(specialty);
    }

    @RequestMapping("/deleteSpecialtyInfo")
    @ResponseBody
    public int deleteSpecialtyInfo(@RequestParam("Id") String Id){
        return specialtyInfoService.deleteSpecialtyInfo(Id);
    }

    @RequestMapping("/updateSpecialtyInfo")
    @ResponseBody
    public int updateSpecialtyInfo(@RequestParam("Id") String Id,@RequestParam("spe_Name") String spe_Name,@RequestParam("col_Id") String col_Id) {
        Specialty specialty = new Specialty(Id,spe_Name,col_Id);
        return specialtyInfoService.updateSpecialtyInfo(specialty);
    }

    @RequestMapping("/selectAllSpecialty")
    @ResponseBody
    public List<Specialty> selectAllSpecialty(){
        return specialtyInfoService.selectAllSpecialty();
    }

    @RequestMapping("/selectCollegeInfo_col_Id")
    @ResponseBody
    public List<Specialty> selectCollegeInfo_col_Id(@RequestParam("col_Id") String col_Id){
        return specialtyInfoService.selectSpecialty_col_Id(col_Id) ;
    }

}
