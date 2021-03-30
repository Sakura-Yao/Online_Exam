package com.huade;

import com.huade.service.SpecialtyInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExamProviderBasic.class)
public class SpecialtyInfoTests {

    @Autowired
    private SpecialtyInfoServiceImpl specialtyInfoService;

    @Test
    public void t1(){
        System.out.println(specialtyInfoService.selectAllSpecialty().size());
    }
}
