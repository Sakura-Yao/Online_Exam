package com.huade;

import com.huade.Utils.UtilTools;
import com.huade.service.ClassInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ExamProviderBasic.class)
public class ClassInfoTests {

    @Autowired
    private ClassInfoServiceImpl classInfoService;

    @Test
    public void t1(){
        System.out.println(classInfoService.selectAllClassInfo().size());
    }

    @Test
    public void t2(){
        System.out.println(classInfoService.select_classInfo_keywords("", "", "", "", -1, -1));
    }

    @Test
    public void t3(){
        List<String> count = classInfoService.selectClassStudentsCount();
        List<String> classId = classInfoService.selectClassStudentsCount_classId();
        List<Map<String,String>> res = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            System.out.println(classInfoService.updateClassStudentCount(classId.get(i), count.get(i)));
        }
    }

    @Test
    public void t4(){
        String mode_file_path = "/Users/develop/Desktop/online_exam/file/batch_mode/classInfo.xlsx";
        String fileName = "批量添加班级信息模版.xlsx";
        UtilTools.MakeBatchAddClassInfo(mode_file_path,fileName);
    }

    @Test
    public void t5(){
        String file_path = "/Users/develop/Desktop/online_exam/file/批量添加班级信息模版.xlsx";
        Map<String, String> res = UtilTools.BatchAddClassInfo(file_path);
        System.out.println(res);
    }

}
