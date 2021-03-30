package com.huade;

import com.huade.Utils.UtilTools;
import com.huade.service.ClassCourseInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = ExamProviderBasic.class)
public class ClassCourseTests {

    @Autowired
    private ClassCourseInfoServiceImpl service;

    @Test
    public void t1(){
        System.out.println(service.selectAllClassCourseInfo(0,0).size());
    }

    @Test
    void selectAllTeachCourse() {
    }

    @Test
    void makeAddCourseInfoMode(){
        String filePath = "/Users/develop/Desktop/online_exam/file/batch_mode/courseInfo.xlsx";
        String fileName = "批量添加课程信息.xlsx";
        System.out.println(UtilTools.MakeBatchAddCourseInfo(filePath, fileName));
    }

    @Test
    void batchAddCourseInfo(){
        String filePath = "/Users/develop/Desktop/online_exam/file/批量添加课程信息.xlsx";
        Map res = new HashMap();
        try {
            res = UtilTools.BatchAddCourseInfo(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
