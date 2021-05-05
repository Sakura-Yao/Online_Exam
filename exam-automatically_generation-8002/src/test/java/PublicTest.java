import com.huade.ExamAutomaticallyGeneration;
import com.huade.pojo.Exam_Rule;
import com.huade.pojo.Paper;
import com.huade.pojo.Rule;
import com.huade.pojo.View_Question_Info;
import com.huade.service.ExamRuleServiceImpl;
import com.huade.utils.DateUtils;
import com.huade.utils.GA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest(classes = ExamAutomaticallyGeneration.class)
public class PublicTest {

    @Autowired
    private ExamRuleServiceImpl service;

    @Test
    void name() {
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String Date=temp.format(date);
        System.out.println(Date);
        System.out.println(DateUtils.getNow_String());
    }

//    测试GA用例
    @Test
    void GA(){
        String id = UUID.randomUUID().toString().replace("-","");
        String couId = "MF86683708";
        double totalMark = 100;
        double difficulty = 0.9;
        List<String> points = new ArrayList<>();
        points.add("7dfe952b59894e058827358b5a142e4c");
        Rule rule = new Rule(id,couId,totalMark,difficulty,10,2,10,2,0,0,2,10,0,0,2,10,2,10,points,"1");
        System.out.println(rule.getPointIds());
        Paper paper = GA.AutoMakePaper(rule);
        for (View_Question_Info view_question_info : paper.getQuestionList()) {
            System.out.println(view_question_info);
            System.out.println();
        }
    }

    @Test
    void t3(){
        System.out.println(service.select());
    }

    @Test
    void t2(){
        Exam_Rule exam_rule = service.selectExamRule("e441986fd8044444a0cb98dfba748c90");
        Rule rule = new Rule();
        List<String> pointIds = Arrays.asList(exam_rule.getPointIds().split(","));
        rule.setId(exam_rule.getId());
        rule.setCou_Id(exam_rule.getCou_Id());
        rule.setExamId(exam_rule.getExam_Id());
        rule.setRule_Name(exam_rule.getRule_Name());
        rule.setTotalMark(Double.parseDouble(exam_rule.getTotalMark()));
        rule.setDifficulty(Double.parseDouble(exam_rule.getDifficulty()));
        rule.setSingleNum(Integer.parseInt(exam_rule.getSingleNum()));
        rule.setSingleScore(Double.parseDouble(exam_rule.getSingleScore()));
        rule.setCompleteNum(Integer.parseInt(exam_rule.getCompleteNum()));
        rule.setCompleteScore(Double.parseDouble(exam_rule.getCompleteScore()));
        rule.setJudgeNum(Integer.parseInt(exam_rule.getJudgeNum()));
        rule.setJudgeScore(Double.parseDouble(exam_rule.getJudgeScore()));
        rule.setSubjectNum(Integer.parseInt(exam_rule.getSubjectNum()));
        rule.setSubjectScore(Double.parseDouble(exam_rule.getSubjectScore()));
        rule.setNounNum(Integer.parseInt(exam_rule.getNounNum()));
        rule.setNounSore(Double.parseDouble(exam_rule.getNounScore()));
        rule.setFillcodeNum(Integer.parseInt(exam_rule.getFillcodeNum()));
        rule.setFillcodeScore(Double.parseDouble(exam_rule.getFillcodeScore()));
        rule.setCodingNum(Integer.parseInt(exam_rule.getCodingNum()));
        rule.setCodingScore(Double.parseDouble(exam_rule.getCodingScore()));
        rule.setPointIds(pointIds);
        rule.setRule_Time(exam_rule.getRule_Time());
        Paper paper = GA.AutoMakePaper(rule);
        for (View_Question_Info view_question_info : paper.getQuestionList()) {
            System.out.println(view_question_info);
            System.out.println();
        }
    }
    @Test
    void t4(){
        System.out.println("123123");
    }
}
