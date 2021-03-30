package com.huade;

import com.huade.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class UserTypeTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void t1(){
        System.out.println(userService.selectAllUser().size());
    }
}
