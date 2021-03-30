package com.huade;

import com.huade.mapper.QuestionInfoMapper;
import com.huade.mapper.UserMapper;
import com.huade.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)

public class QuestionTests {

    @Autowired
    private QuestionInfoMapper questionInfoMapper;

    @Test
    public void t1() {
        System.out.println(questionInfoMapper.showCountNum("", "TT001", "", "", "", ""));
    }
}
