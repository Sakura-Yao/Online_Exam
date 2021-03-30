package com.huade.service;

import com.huade.mapper.QuestionTimesMapper;
import com.huade.pojo.QuestionTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTimesServiceImpl implements QuestionTimesService {

    @Autowired
    private QuestionTimesMapper questionTimesMapper;

    public void setQuestionTimesMapper(QuestionTimesMapper questionTimesMapper) {
        this.questionTimesMapper = questionTimesMapper;
    }

    @Override
    public int addQuestionTimesInfo(QuestionTimes questionTimes) {
        return questionTimesMapper.addQuestionTimesInfo(questionTimes);
    }

    @Override
    public int useQuestion(String question_Id) {
        return questionTimesMapper.useQuestion(question_Id);
    }

    @Override
    public List<QuestionTimes> selectAll() {
        return questionTimesMapper.selectAll();
    }
}
