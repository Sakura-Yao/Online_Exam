package com.huade.controller;

import com.huade.pojo.*;
import com.huade.Utils.UtilTools;
import com.huade.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping("/addKnowledgeInfo")
    @ResponseBody
    public int AddKnowledgeInfo(@RequestParam("cou_Id")String cou_Id,
                                   @RequestParam("kwl_Level")String kwl_Level,
                                   @RequestParam("chapter_Num")String chapter_Num,
                                   @RequestParam("section_Num")String section_Num,
                                   @RequestParam("kwl_Name")String kwl_Name,
                                   @RequestParam("parent_Id")String parent_Id){
        String id = UUID.randomUUID().toString().replace("-","");
        Knowledge knowledge = new Knowledge(id,cou_Id,kwl_Level,chapter_Num,section_Num,kwl_Name,parent_Id);
        return knowledgeService.addKnowledge(knowledge);
    }

    @RequestMapping("/batchKnowledge")
    @ResponseBody
    public Map BatchKnowledge (@RequestParam("filePath")String filePath){
        return UtilTools.batch_knowledge(filePath, "Sheet1");
    }

    @RequestMapping("/updateKnowledge")
    @ResponseBody
    public int UpdateKnowledge(@RequestParam("Id")String Id,
                               @RequestParam("kwl_Name")String kwl_Name){
        return knowledgeService.updateKnowledge(Id, kwl_Name);
    }

    @RequestMapping("/deleteKnowledge")
    @ResponseBody
    public int DeleteKnowledge(@RequestParam("Id")String Id){
        return knowledgeService.deleteKnowledge(Id);
    }

    @RequestMapping("/knowledgeTree")
    @ResponseBody
    public KnowCourseBean[] Test(@RequestParam("cou_id")String cou_id){
        return GetKnowledgeTree(cou_id);
    }

    @RequestMapping("/xmKnowledge")
    @ResponseBody
    public ArrayList<XM_Knowledge> XMKnowledge(@RequestParam("cou_id")String cou_id){
        return GetKnowledgeTreeForXM(cou_id);
    }

    private KnowCourseBean[] GetKnowledgeTree(String cou_id){
        KnowCourseBean[] root = new KnowCourseBean[1];
        KnowCourseBean knowCourseBean = new KnowCourseBean();
        ArrayList<Children> chapterChildrenList = new ArrayList<>();
        List<View_Knowledge> l1 = knowledgeService.selectKnowledge("", cou_id, "1", "", "", 0, 0);
        knowCourseBean.setId(cou_id);
        knowCourseBean.setTitle(l1.get(0).getCou_Name());
        knowCourseBean.setChecked(false);
        knowCourseBean.setSpread(true);
        for (View_Knowledge chapterKnowledge : l1) {
            ArrayList<Children> sectionChildrenList = new ArrayList<>();
            Children chapter = new Children();
            chapter.setId(chapterKnowledge.getId());
            chapter.setTitle(chapterKnowledge.getKwl_Name());
            chapter.setChapter(chapterKnowledge.getChapter_Num());
            chapter.setSection(chapterKnowledge.getSection_Num());
            chapter.setKwl_level(chapterKnowledge.getKwl_Level());
            chapter.setChecked(false);
            List<View_Knowledge> l2 = knowledgeService.selectKnowledge("", cou_id, "2", String.valueOf(chapterKnowledge.getChapter_Num()), "", 0, 0);
            for (View_Knowledge sectionKnowledge : l2) {
                Children section = new Children();
                section.setId(sectionKnowledge.getId());
                section.setTitle(sectionKnowledge.getKwl_Name());
                section.setChecked(false);
                section.setChapter(sectionKnowledge.getChapter_Num());
                section.setSection(sectionKnowledge.getSection_Num());
                section.setKwl_level(sectionKnowledge.getKwl_Level());
                section.setChildren(null);
                sectionChildrenList.add(section);
            }
            chapter.setChildren(sectionChildrenList);
            chapterChildrenList.add(chapter);
        }
        knowCourseBean.setChildren(chapterChildrenList);
        root[0] = knowCourseBean;
        return root;
    }

    private ArrayList<XM_Knowledge> GetKnowledgeTreeForXM(String cou_id){
        ArrayList<XM_Knowledge> xm_knowledge_level1 = new ArrayList<>();
        List<View_Knowledge> l1 = knowledgeService.selectKnowledge("", cou_id, "1", "", "", 0, 0);
        for (View_Knowledge chapterKnowledge : l1) {
            XM_Knowledge chapter = new XM_Knowledge();
            chapter.setName(chapterKnowledge.getKwl_Name());
            chapter.setValue(chapterKnowledge.getId());
            chapter.setDisable(false);
            chapter.setSelected(false);
            ArrayList<XM_Knowledge> xm_knowledge_level2 = new ArrayList<>();
            List<View_Knowledge> l2 = knowledgeService.selectKnowledge("", cou_id, "2", String.valueOf(chapterKnowledge.getChapter_Num()), "", 0, 0);
            for (View_Knowledge sectionKnowledge : l2) {
                XM_Knowledge section = new XM_Knowledge();
                section.setName(sectionKnowledge.getKwl_Name());
                section.setValue(sectionKnowledge.getId());
                section.setDisable(false);
                section.setSelected(false);
                section.setChildren(null);
                xm_knowledge_level2.add(section);
            }
            chapter.setChildren(xm_knowledge_level2);
            xm_knowledge_level1.add(chapter);
        }
        return xm_knowledge_level1;
    }

}
