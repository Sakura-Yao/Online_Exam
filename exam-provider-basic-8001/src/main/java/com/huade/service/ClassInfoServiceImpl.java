package com.huade.service;

import com.huade.Utils.LayuiMessage;
import com.huade.Utils.UpdatePeopleCount;
import com.huade.mapper.ClassInfoMapper;
import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoMapper classInfoMapper;

    private LayuiMessage ls = new LayuiMessage();

    public void setClassInfoMapper(ClassInfoMapper classInfoMapper) {
        this.classInfoMapper = classInfoMapper;
    }

    @Override
    public int addClassInfo(ClassInfo classInfo) {
        return classInfoMapper.addClassInfo(classInfo);
    }

    @Override
    public int batchAddClassInfo(List<Map<String, Object>> classInfoList) throws Exception {
        return classInfoMapper.batchAddClassInfo(classInfoList);
    }

    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        return classInfoMapper.updateClassInfo(classInfo);
    }

    @Override
    public int deleteClassInfo(String Id) {
        return classInfoMapper.deleteClassInfo(Id);
    }

    @Override
    public List<View_ClassInfo> select_classInfo_keywords(String Id,String class_Id,String col_Id,String spe_Id,int current,int length) {
        return classInfoMapper.select_classInfo_keywords(Id, class_Id, col_Id, spe_Id, current, length);
    }

    @Override
    public List<ClassInfo> selectClassInfo(String Id,String col_Id,String spe_Id,int current,int length) {
        return classInfoMapper.selectClassInfo(Id,col_Id,spe_Id,current,length);
    }

    @Override
    public List<View_ClassInfo> selectAllClassInfo() {
        return classInfoMapper.selectAllClassInfo();
    }

    @Override
    public String selectId(String class_Id) {
        return classInfoMapper.selectId(class_Id);
    }

    @Override
    public String showCountNum(String Id,String class_Id,String col_Id,String spe_Id) {
        return classInfoMapper.showCountNum(Id, class_Id, col_Id, spe_Id);
    }

    @Override
    public List<String> selectClassStudentsCount() {
        return classInfoMapper.selectClassStudentsCount();
    }

    @Override
    public List<String> selectClassStudentsCount_classId(){
        return classInfoMapper.selectClassStudentsCount_classId();
    }

    @Override
    public int updateClassStudentCount(String Id,String people_Num){
        return classInfoMapper.updateClassStudentCount(Id, people_Num);
    }

    @Override
    public LayuiMessage getClassinfoList(int page, int limit) {
        List classinfoList = classInfoMapper.getClassinfoList((page - 1) * limit, limit);
        List allClassinfoList = classInfoMapper.getAllClassinfoList();
        ls.setCode(0);
        ls.setCount(allClassinfoList.size());
        ls.setData(classinfoList);
        ls.setMsg("");
        if(allClassinfoList.size() == 0){
            ls.setMsg("无数据");
        }

        return ls;
    }
}
