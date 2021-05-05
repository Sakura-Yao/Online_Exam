package com.huade;

import com.huade.pojo.QuestionCollection;
import com.huade.service.QuestionCollectionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = ExamProviderBasic.class)
public class QuestionCollectionTests {

    @Autowired
    private QuestionCollectionServiceImpl service;

    @Test
    public void t1(){
        String question_id = "29a0bea789af48ceb396f4e9cd66643b";
        String user_id = "1180130116";
        String uuid = UUID.randomUUID().toString().replace("-","");
        QuestionCollection questionCollection = new QuestionCollection(user_id,question_id);
        System.out.println(service.addQuestionCollectionInfo(questionCollection));
//        System.out.println(service.selectQuestionCollectionInfos("", "", "", 0, 0));
//        System.out.println(service.verificationQuestionCollection(user_id, question_id));
//        System.out.println(service.deleteQuestionCollectionInfo("udjxi123j399sirot5nci340suri03n3"));
    }

}
