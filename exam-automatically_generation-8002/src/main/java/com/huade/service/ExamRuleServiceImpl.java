package com.huade.service;

import com.huade.mapper.ExamRuleMapper;
import com.huade.pojo.Exam_Rule;
import com.huade.pojo.LayuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamRuleServiceImpl implements ExamRuleService {

    @Autowired
    private ExamRuleMapper examRuleMapper;

    @Override
    public int addExamRule(Exam_Rule exam_rule) {
        return examRuleMapper.addExamRule(exam_rule);
    }

    @Override
    public LayuiResult select() {
        LayuiResult result = new LayuiResult();
        if (examRuleMapper.select() != null) {
            result.setCode(0);
            result.setCount(examRuleMapper.count());
            result.setData(examRuleMapper.select());
        } else {
            result.setCode(1);
            result.setCount(0);
            result.setMsg("无数据/查询失败");
            result.setData(null);
        }
        return result;
    }

    @Override
    public Exam_Rule selectExamRule(String Id) {
        return examRuleMapper.selectExamRule(Id);
    }
}
