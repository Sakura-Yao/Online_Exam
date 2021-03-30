package com.huade.mapper;

import com.huade.pojo.Specialty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpecialtyInfoMapper {

    int addSpecialtyInfo (Specialty specialty);

    int deleteSpecialtyInfo (@Param("Id")String Id);

    int updateSpecialtyInfo (Specialty specialty);

    List<Specialty> selectAllSpecialty();

    List<Specialty> selectSpecialty_col_Id (@Param("col_Id")String col_Id);

    String selectSpe_Id(@Param("spe_Name")String spe_Name);
}
