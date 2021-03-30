package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;
import com.huade.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/classInfo")
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    //ip:part/classInfo/addClassInfo
    @RequestMapping("/addClassInfo")
    @ResponseBody
    public int addClassInfo( @RequestParam("class_Id") String class_Id,
                             @RequestParam("people_Num") String people_Num,
                             @RequestParam("class_Col_Id") String class_Col_Id,
                             @RequestParam("class_Spe_Id") String class_Spe_Id){
        String Id = UUID.randomUUID().toString().replace("-","");
        ClassInfo classInfo = new ClassInfo(Id,class_Id,people_Num,class_Col_Id,class_Spe_Id);
        return classInfoService.addClassInfo(classInfo);
    }

    @RequestMapping("/makeBatchClassInfoMode")
    @ResponseBody
    public String makeBatchClassInfoMode(@RequestParam("filePath")String filePath,
                                         @RequestParam("fileName")String fileName){
        return UtilTools.MakeBatchAddClassInfo(filePath,fileName);
    }

    @RequestMapping("/batchClassInfo")
    @ResponseBody
    public Map batchClassInfo(@RequestParam("filePath")String filePath){
        return UtilTools.BatchAddClassInfo(filePath);
    }

    @RequestMapping("/updateClassInfo")
    @ResponseBody
    public int updateClassInfo(@RequestParam("Id") String Id,@RequestParam("class_Id") String class_Id,@RequestParam("people_Num") String people_Num,@RequestParam("class_Col_Id") String class_Col_Id,@RequestParam("class_Spe_Id") String class_Spe_Id){
        ClassInfo classInfo = new ClassInfo(Id,class_Id,people_Num,class_Col_Id,class_Spe_Id);
        return classInfoService.updateClassInfo(classInfo);
    }

    @RequestMapping("/deleteClassInfo")
    @ResponseBody
    public int deleteClassInfo(@RequestParam("Id") String Id){
        return classInfoService.deleteClassInfo(Id);
    }

    @RequestMapping("/select_classInfo_keywords")
    @ResponseBody
    public List<View_ClassInfo> select_classInfo_keywords(@RequestParam("Id")String Id,
                                                          @RequestParam("class_Id")String class_Id,
                                                          @RequestParam("col_Id")String col_Id,
                                                          @RequestParam("spe_Id")String spe_Id,
                                                          @RequestParam("current")String current,
                                                          @RequestParam("length")String length){
        List<String> count = classInfoService.selectClassStudentsCount();
        List<String> classId = classInfoService.selectClassStudentsCount_classId();
        for (int i = 0; i < count.size(); i++) {
            classInfoService.updateClassStudentCount(classId.get(i), count.get(i));
        }
        return classInfoService.select_classInfo_keywords(Id,class_Id,col_Id,spe_Id,Integer.parseInt(current),Integer.parseInt(length));
    }

    @RequestMapping("/selectClassInfo")
    @ResponseBody
    public List<ClassInfo> selectClassInfo(@RequestParam("Id")String Id,
                                @RequestParam("col_Id")String col_Id,
                                @RequestParam("spe_Id")String spe_Id,
                                @RequestParam("current")String current,
                                @RequestParam("length")String length){
        return classInfoService.selectClassInfo(Id,col_Id,spe_Id,Integer.parseInt(current),Integer.parseInt(length));
    }

    @RequestMapping("/showCountNum")
    @ResponseBody
    public String showCountNum(@RequestParam("Id")String Id,
                               @RequestParam("class_Id")String class_Id,
                               @RequestParam("col_Id")String col_Id,
                               @RequestParam("spe_Id")String spe_Id){
        return classInfoService.showCountNum(Id, class_Id, col_Id, spe_Id);
    }

}
