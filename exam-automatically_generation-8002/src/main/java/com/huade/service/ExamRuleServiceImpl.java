package com.huade.service;

import com.huade.mapper.ExamRuleMapper;
import com.huade.pojo.Exam_Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamRuleServiceImpl implements ExamRuleService {

    @Autowired
    private ExamRuleMapper examRuleMapper;

    @Override
    public int addExamRule(Exam_Rule exam_rule) {
        return examRuleMapper.addExamRule(exam_rule);
    }
}
