package com.huade.service;

import com.huade.pojo.Exam_Rule;
import com.huade.pojo.LayuiResult;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ExamRuleService {

    int addExamRule(Exam_Rule exam_rule);

    LayuiResult select();

    Exam_Rule selectExamRule(String Id);

}
