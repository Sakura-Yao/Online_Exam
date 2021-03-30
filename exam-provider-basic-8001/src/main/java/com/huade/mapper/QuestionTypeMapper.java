package com.huade.mapper;

import com.huade.pojo.Question_Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionTypeMapper {

    int addQuestionType(Question_Type question_type);

    int deleteQuestionType(@Param("Id") String Id);

    int updateQuestionType(Question_Type question_type);

    List<Question_Type> selectAllQuestionType();

    String selectQuestionType_Id (@Param("Id")String Id);

}
