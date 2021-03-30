package com.huade.service;

import com.huade.pojo.QuestionInfo;
import com.huade.pojo.View_Question_Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionInfoService {

    int addQuestionInfo(QuestionInfo questionInfo);

    int deleteQuestionInfo(String question_Id);

    int updateQuestionInfo(QuestionInfo questionInfo);

    QuestionInfo selectQuestionInfo_Id(String Id);

    List<View_Question_Info> selectQuestionInfo_keyWords(String question_Id,
                                                         String cou_Id,
                                                         String type_Id,
                                                         String subject,
                                                         String degree,
                                                         String kwl_Id,
                                                         int current, int length);


    List<QuestionInfo> selectQuestionInfo(String question_Id, String cou_Id, String type_Id, String subject, String degree, String kwl_Id,
                                          int current, int length);

    String showCountNum(String question_Id,
                        String cou_Id,
                        String type_Id,
                        String subject,
                        String degree,
                        String kwl_Id);
}
