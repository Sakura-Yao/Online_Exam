package com.huade.controller;

import com.huade.pojo.KnowCourseBean;
import com.huade.pojo.XM_Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001/knowledge";

    @RequestMapping("/addKnowledgeInfo")
    @ResponseBody
    public int AddKnowledgeInfo(@RequestParam("cou_Id")String cou_Id,
                                @RequestParam("kwl_Level")String kwl_Level,
                                @RequestParam("chapter_Num")String chapter_Num,
                                @RequestParam("section_Num")String section_Num,
                                @RequestParam("kwl_Name")String kwl_Name,
                                @RequestParam("parent_Id")String parent_Id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_Id",cou_Id);
        param.add("kwl_Level",kwl_Level);
        param.add("chapter_Num",chapter_Num);
        param.add("section_Num",section_Num);
        param.add("kwl_Name",kwl_Name);
        param.add("parent_Id",parent_Id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/addKnowledgeInfo",param,Integer.class);
    }

    @RequestMapping("/updateKnowledge")
    @ResponseBody
    public int UpdateKnowledge (@RequestParam("Id")String Id,
                                @RequestParam("kwl_Name")String kwl_Name){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        param.add("kwl_Name",kwl_Name);
        return restTemplate.postForObject(REST_URL_PREFIX+"/updateKnowledge",param,Integer.class);
    }

    @RequestMapping("deleteKnowledge")
    @ResponseBody
    public int DeleteKnowledge (@RequestParam("Id")String Id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("Id",Id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/deleteKnowledge",param,Integer.class);
    }

    @RequestMapping("/knowledgeTree")
    @ResponseBody
    public KnowCourseBean[] Test (@RequestParam("cou_id")String cou_id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_id",cou_id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/knowledgeTree",param,KnowCourseBean[].class);
    }

    @RequestMapping("/xmKnowledge")
    @ResponseBody
    public ArrayList<XM_Knowledge> XMKnowledge(@RequestParam("cou_id")String cou_id){
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("cou_id",cou_id);
        return restTemplate.postForObject(REST_URL_PREFIX+"/xmKnowledge",param, ArrayList.class);
    }

}
