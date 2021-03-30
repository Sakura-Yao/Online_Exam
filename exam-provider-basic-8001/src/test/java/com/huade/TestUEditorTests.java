package com.huade;

import com.huade.service.TestUEditorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class TestUEditorTests {

    @Autowired
    private TestUEditorServiceImpl testUEditorService;

    @Test
    public void t1(){
        System.out.println(testUEditorService.selectTestInfo(""));
    }
}
