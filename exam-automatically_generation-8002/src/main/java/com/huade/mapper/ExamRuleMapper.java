package com.huade.mapper;

import com.huade.pojo.Exam_Rule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExamRuleMapper {

    int addExamRule(Exam_Rule exam_rule);



}
