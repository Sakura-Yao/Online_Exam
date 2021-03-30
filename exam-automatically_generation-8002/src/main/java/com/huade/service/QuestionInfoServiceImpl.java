package com.huade.service;

import com.huade.mapper.QuestionInfoMapper;
import com.huade.pojo.View_Question_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionInfoServiceImpl implements QuestionInfoService {

    @Autowired
    private QuestionInfoMapper questionInfoMapper;

    public View_Question_Info[] GA_QuestionInfo(String cou_Id, String type, String[] kwl_list) {
        return questionInfoMapper.GA_QuestionInfo(cou_Id,type,kwl_list);
    }
}
