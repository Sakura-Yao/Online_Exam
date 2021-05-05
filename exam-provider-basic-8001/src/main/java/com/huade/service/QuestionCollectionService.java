package com.huade.service;

import com.huade.pojo.QuestionCollection;
import com.huade.pojo.View_QuestionCollection;
import com.huade.pojo.View_Question_Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionCollectionService {

    int addQuestionCollectionInfo(QuestionCollection questionCollection);

    int deleteQuestionCollectionInfo(String user_Id,String question_Id) throws Exception;

    List<View_Question_Info> selectQuestionCollectionInfos(String user_Id,
                                                           String cou_Id,
                                                           String type_Id,
                                                           int current,
                                                           int length);

    String ShowCount(String user_Id,
                     String cou_Id,
                     String type_Id);

    int verificationQuestionCollection(String user_Id,String question_Id);

}
