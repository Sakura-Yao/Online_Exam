package com.huade;

import com.huade.service.QuestionTimesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class QuestionTimesTests {

    @Autowired
    private QuestionTimesServiceImpl questionTimesService;

    @Test
    public void t1(){
        System.out.println(questionTimesService.selectAll().size());
    }
}
