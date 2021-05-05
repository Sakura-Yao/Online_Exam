package com.huade.mapper;

import com.huade.pojo.Exam_Rule;
import com.huade.pojo.View_ExamRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ExamRuleMapper {

    int addExamRule(Exam_Rule exam_rule);

    int count();

    ArrayList<View_ExamRule> select();

    Exam_Rule selectExamRule(@Param("Id")String Id);

}
