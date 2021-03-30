package com.huade;

import com.huade.service.StudentBasicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class StudentBasicTests {

    @Autowired
    private StudentBasicServiceImpl studentBasicService;

    @Test
    public void t1(){
        System.out.println(studentBasicService.selectAllStudentBasic().size());
    }
}
