package com.huade.service;

import com.huade.mapper.CourseMapper;
import com.huade.mapper.KnowledgeMapper;
import com.huade.pojo.Course;
import com.huade.pojo.Knowledge;
import com.huade.pojo.View_CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public int addCourseInfo(Course course) {
        Knowledge parents = new Knowledge(UUID.randomUUID().toString().replace("-",""),course.getId(),"1","0","0","示例-本处填写章节名称","");
        Knowledge children = new Knowledge(UUID.randomUUID().toString().replace("-",""),course.getId(),"2","0","1","本处填写小节名称",parents.getId());
        Knowledge children1 = new Knowledge(UUID.randomUUID().toString().replace("-",""),course.getId(),"2","0","2","该示例将在你添加第一条章节知识点时自动删除，请勿重复操作",parents.getId());
        if (courseMapper.addCourseInfo(course) == knowledgeMapper.addKnowledge(parents)){
            knowledgeMapper.addKnowledge(children);
            knowledgeMapper.addKnowledge(children1);
            return 1;
        }
        return 0;
    }

    @Override
    public int batchAddCourseInfo(List<Map<String, Object>> courseInfoList) throws Exception {
        return courseMapper.batchAddCourseInfo(courseInfoList);
    }

    @Override
    public int deleteCourseInfo(String Id) {
        return courseMapper.deleteCourseInfo(Id);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateCourseInfo(course);
    }

    @Override
    public List<Course> selectAllCourseInfo(int current, int length) {
        return courseMapper.selectAllCourseInfo(current,length);
    }

    @Override
    public List<View_CourseInfo> selectCourseInfo(String cou_Id,
                                                  String cou_Name,
                                                  String col_Id,
                                                  String spe_Id,
                                                  int current, int length) {
        return courseMapper.selectCourseInfo(cou_Id, cou_Name, col_Id, spe_Id, current, length);
    }
}
