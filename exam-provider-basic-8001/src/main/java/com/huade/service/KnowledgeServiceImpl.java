package com.huade.service;

import com.huade.mapper.KnowledgeMapper;
import com.huade.pojo.Knowledge;
import com.huade.pojo.View_Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    public void setKnowledgeMapper(KnowledgeMapper knowledgeMapper) {
        this.knowledgeMapper = knowledgeMapper;
    }

    @Override
    public int addKnowledge(Knowledge knowledge) {
        return knowledgeMapper.addKnowledge(knowledge);
    }

    @Override
    public int deleteKnowledge(String Id) {
        return knowledgeMapper.deleteKnowledge(Id);
    }

    @Override
    public int updateKnowledge(Knowledge knowledge) {
        return knowledgeMapper.updateKnowledge(knowledge);
    }

    @Override
    public List<View_Knowledge> selectAllKnowledge(int current, int length) {
        return knowledgeMapper.selectAllKnowledge(current, length);
    }

    @Override
    public List<View_Knowledge> selectKnowledge(String Id, String cou_Id, String kwl_Level, String chapter_Num, String section_Num, int current, int length) {
        return knowledgeMapper.selectKnowledge(Id, cou_Id, kwl_Level, chapter_Num, section_Num, current, length);
    }
}
