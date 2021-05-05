package com.huade.service;

import com.huade.mapper.QuestionCollectionMapper;
import com.huade.pojo.QuestionCollection;
import com.huade.pojo.View_QuestionCollection;
import com.huade.pojo.View_Question_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionCollectionServiceImpl implements QuestionCollectionService {

    @Autowired
    private QuestionCollectionMapper questionCollectionMapper;

    @Override
    public int addQuestionCollectionInfo(QuestionCollection questionCollection) {
        if (questionCollectionMapper.verificationQuestionCollection(questionCollection.getUser_Id(),questionCollection.getQuestion_Id()) > 0){
            return 0;
        }else {
            return questionCollectionMapper.addQuestionCollectionInfo(questionCollection);
        }
    }

    @Override
    public int deleteQuestionCollectionInfo(String user_Id,String question_Id) {
        try {
            return questionCollectionMapper.deleteQuestionCollectionInfo(user_Id,question_Id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<View_Question_Info> selectQuestionCollectionInfos(String user_Id, String cou_Id, String type_Id, int current, int length) {
        return questionCollectionMapper.selectQuestionCollectionInfos(user_Id, cou_Id, type_Id, current, length);
    }

    @Override
    public String ShowCount(String user_Id, String cou_Id, String type_Id) {
        return questionCollectionMapper.ShowCount(user_Id, cou_Id, type_Id);
    }

    @Override
    public int verificationQuestionCollection(String user_Id,String question_Id){
        return questionCollectionMapper.verificationQuestionCollection(user_Id, question_Id);
    }

}
