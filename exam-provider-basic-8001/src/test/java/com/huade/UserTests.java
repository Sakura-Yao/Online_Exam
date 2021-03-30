package com.huade;

import com.huade.Utils.UtilTools;
import com.huade.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = ExamProviderBasic.class)
public class UserTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void t1(){
        System.out.println(userService.selectAllUser().size());
    }

    @Test
    void makeBathAddUser(){
        String filePath = "/Users/develop/Desktop/online_exam/file/batch_mode/userInfo.xlsx";
        String fileName = "批量添加用户信息.xlsx";
        UtilTools.MakeBatchAddUserMode(filePath,fileName);
    }

    @Test
    void BathAddUser(){
        String filePath = "/Users/develop/Desktop/online_exam/file/批量添加用户信息.xlsx";
        Map res = new HashMap();
        try {
            res = UtilTools.BatchAddStudentInfo(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
