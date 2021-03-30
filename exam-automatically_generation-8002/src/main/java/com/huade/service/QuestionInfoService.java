package com.huade.service;

import com.huade.pojo.View_Question_Info;

public interface QuestionInfoService {

    View_Question_Info[] GA_QuestionInfo(String cou_Id, String type,
                                         String[] kwl_list);
}
