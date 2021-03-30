package com.huade;

import com.huade.Utils.UtilTools;
import com.huade.service.KnowledgeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.rmi.CORBA.Util;
import java.util.Map;

@SpringBootTest(classes = ExamProviderBasic.class)
public class KnowledgeTests {

    @Autowired
    private KnowledgeServiceImpl knowledgeService;

    @Test
    public void t1(){
        System.out.println(knowledgeService.selectAllKnowledge(0, 0).size());
    }

    @Test
    public void test_bachData(){
        String filePath = "/Users/develop/Desktop/online_exam/file/批量添加课程知识点信息.xlsx";
        String sheetName = "Sheet1";
        Map map = UtilTools.batch_knowledge(filePath, sheetName);
        System.out.println(map);
    }
}
