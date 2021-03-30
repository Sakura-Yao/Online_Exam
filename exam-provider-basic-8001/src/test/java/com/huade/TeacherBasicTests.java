package com.huade;

import com.huade.service.TeacherBasicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class TeacherBasicTests {

    @Autowired
    private TeacherBasicServiceImpl teacherBasicService;

    @Test
    public void t1(){
        System.out.println(teacherBasicService.selectAllTeacherBasic(0, 0).size());
    }
}
