package com.huade.mapper;

import com.huade.pojo.View_Question_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionInfoMapper {

    View_Question_Info[] GA_QuestionInfo(@Param("cou_Id") String cou_Id,
                                         @Param("type") String type,
                                         @Param("kwl_list") String[] kwl_list);

}
