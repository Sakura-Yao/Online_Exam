package com.huade.mapper;

import com.huade.pojo.QuestionInfo;
import com.huade.pojo.View_Question_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionInfoMapper {
    
    int addQuestionInfo(QuestionInfo questionInfo);
    
    int deleteQuestionInfo(@Param("question_Id") String question_Id);

    int updateQuestionInfo(QuestionInfo questionInfo);

    QuestionInfo selectQuestionInfo_Id(@Param("Id")String Id);

    List<View_Question_Info> selectQuestionInfo_keyWords(@Param("question_Id") String question_Id,
                                                         @Param("cou_Id") String cou_Id,
                                                         @Param("type_Id") String type_Id,
                                                         @Param("subject") String subject,
                                                         @Param("degree") String degree,
                                                         @Param("kwl_Id") String kwl_Id,
                                                         @Param("current") int current, @Param("length") int length);

    List<QuestionInfo> selectQuestionInfo(@Param("question_Id") String question_Id,
                                                @Param("cou_Id") String cou_Id,
                                                @Param("type_Id") String type_Id,
                                                @Param("subject") String subject,
                                                @Param("degree") String degree,
                                                @Param("kwl_Id") String kwl_Id,
                                                @Param("current") int current, @Param("length") int length);
    String showCountNum(@Param("question_Id") String question_Id,
                        @Param("cou_Id") String cou_Id,
                        @Param("type_Id") String type_Id,
                        @Param("subject") String subject,
                        @Param("degree") String degree,
                        @Param("kwl_Id") String kwl_Id);
}
