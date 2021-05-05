package com.huade;

import com.huade.Utils.UtilTools;
import com.huade.pojo.View_Knowledge;
import com.huade.service.KnowledgeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ExamProviderBasic.class)
public class KnowledgeTests {

    @Autowired
    private KnowledgeServiceImpl knowledgeService;

    @Test
    public void t1(){
        System.out.println(knowledgeService.selectAllKnowledge(0, 0).size());
    }

    public static List<View_Knowledge> Sort_Level_1 (List<View_Knowledge> list_know){
        for (int i = 0; i < list_know.size()-1; i++) {
            for (int j = 0; j < list_know.size()-i-1; j++) {
                if (list_know.get(j).getChapter_Num() > list_know.get(j + 1).getChapter_Num()) {
                    View_Knowledge view_knowledge = list_know.get(j);
                    list_know.remove(j);
                    list_know.add(j+1,view_knowledge);
                }
            }
        }
        return list_know;
    }

    @Test
    public void test_bachData(){
        String filePath = "/Users/develop/Desktop/online_exam/file/批量添加课程知识点信息.xlsx";
        String sheetName = "Sheet1";
        Map map = UtilTools.batch_knowledge(filePath, sheetName);
        System.out.println(map);
    }

    @Test
    public void test_know(){
        List<View_Knowledge> l1 = knowledgeService.selectKnowledge("", "LT96785089", "2", "1", "", 0, 0);
        System.out.println(l1);

    }
}
