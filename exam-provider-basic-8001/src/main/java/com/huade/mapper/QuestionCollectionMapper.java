package com.huade.mapper;

import com.huade.pojo.QuestionCollection;
import com.huade.pojo.View_QuestionCollection;
import com.huade.pojo.View_Question_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLClientInfoException;
import java.util.List;

@Mapper
@Repository
public interface QuestionCollectionMapper {

    int addQuestionCollectionInfo(QuestionCollection questionCollection);

    int deleteQuestionCollectionInfo(@Param("user_Id")String user_Id,
                                     @Param("question_Id")String question_Id);

    List<View_Question_Info> selectQuestionCollectionInfos(@Param("user_Id")String user_Id,
                                                           @Param("cou_Id")String cou_Id,
                                                           @Param("type_Id")String type_Id,
                                                           @Param("current")int current,
                                                           @Param("length")int length);

    String ShowCount(@Param("user_Id")String user_Id,
                     @Param("cou_Id")String cou_Id,
                     @Param("type_Id")String type_Id);

    int verificationQuestionCollection(@Param("user_Id")String user_Id,
                                       @Param("question_Id")String question_Id);
}
