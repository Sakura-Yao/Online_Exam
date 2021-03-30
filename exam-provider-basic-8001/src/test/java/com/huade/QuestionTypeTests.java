package com.huade;

import com.huade.service.QuestionTimesServiceImpl;
import com.huade.service.QuestionTypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class QuestionTypeTests {

    @Autowired
    private QuestionTypeServiceImpl questionTypeService;

    @Test
    public void t1(){
        System.out.println(questionTypeService.selectAllQuestionType().size());
    }
}
