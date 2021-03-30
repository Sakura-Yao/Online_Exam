package com.huade.mapper;

import com.huade.pojo.QuestionTimes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionTimesMapper {

    int addQuestionTimesInfo(QuestionTimes questionTimes);

    int useQuestion(@Param("question_Id")String question_Id);

    List<QuestionTimes> selectAll();

}
