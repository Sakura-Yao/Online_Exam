package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @RequestMapping("/batchKnowledge")
    @ResponseBody
    public Map BatchKnowledge (@RequestParam("filePath")String filePath){
        return UtilTools.batch_knowledge(filePath, "Sheet1");
    }

}
