package com.huade;

import com.huade.service.CollegeInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class CollegeInfoTests {

    @Autowired
    private CollegeInfoServiceImpl collegeInfoService;

    @Test
    public void t1(){
        System.out.println(collegeInfoService.selectAllCollegeInfo().size());
    }
}
