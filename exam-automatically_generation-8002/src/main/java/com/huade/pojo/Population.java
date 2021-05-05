package com.huade.pojo;

import com.huade.service.QuestionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * 种群，多套试卷
 */
@Component
public class Population {

    @Autowired
    private QuestionInfoService questionInfoServiceImpl;

    private static Population population;

    @PostConstruct
    public void init(){
        population = this;
    }

    private Paper[] papers;
    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param initFlag       初始化标志 true-初始化
     * @param rule           规则bean
     */
    public void Population(int populationSize, boolean initFlag, Rule rule){
        papers = new Paper[populationSize];
        if (initFlag) {
            Paper paper;
            Random random = new Random();
            for (int i = 0; i < populationSize; i++) {
                paper = new Paper();
                paper.setId(i);
                while (paper.getTotalScore() != rule.getTotalMark()) {
                    paper.getQuestionList().clear();
                    String[] idString = rule.getPointIds().toArray(new String[0]);
                    //单选题
                    if (rule.getSingleNum() > 0) {
                        generateQuestion(rule,"1f45bd0005c541b998731546b3b8909a", random, rule.getSingleNum(), rule.getSingleScore(), idString,
                                "单选题数量不够，组卷失败", paper);
                    }
                    //填空题
                    if (rule.getCompleteNum() > 0) {
                        generateQuestion(rule,"9d1ec85c8fdd40ba8b4cc733d4d72581", random, rule.getCompleteNum(), rule.getSingleScore(), idString,
                                "填空题数量不够，组卷失败", paper);
                    }
                    //主观题
                    if (rule.getSubjectNum() > 0) {
                        generateQuestion(rule,"a3514b0394a940cea19d5e1ef74b041f", random, rule.getSubjectNum(), rule.getSingleScore(), idString,
                                "主观题数量不够，组卷失败", paper);
                    }
                    //判断题
                    if (rule.getJudgeNum() > 0) {
                        generateQuestion(rule,"b5046eea8c484ec8ab011da3a650a1e5",random,rule.getJudgeNum(),rule.getJudgeScore(),idString,
                                "判断题数量不够，组卷失败",paper);
                    }
                    //名词解释
                    if (rule.getNounNum() > 0) {
                        generateQuestion(rule,"3eb9b37cff394f3fa9a1a052e1685105",random,rule.getNounNum(), rule.getNounSore(),idString,
                                "名词解释题数量不够，组卷失败",paper);
                    }
                    //程序填空
                    if (rule.getFillcodeNum() > 0) {
                        generateQuestion(rule,"fd09a3873f184169b4fd335934078123",random,rule.getFillcodeNum(),rule.getFillcodeScore(),idString,
                                "程序填空题数量不够，组卷失败",paper);
                    }
                    //编程题
                    if (rule.getCodingNum() > 0) {
                        generateQuestion(rule,"1996a697e26a4453a80900a82c1df699",random, rule.getCodingNum(),rule.getCodingScore(),idString,
                                "编程题数量不够，组卷失败",paper);
                    }
                    paper.getTotalScore(rule);
                }
                //计算试卷知识点覆盖率
                paper.setKPCoverage(rule);
                //计算试卷适合度
                paper.setAdaptationDegree(rule, Global.KP_WEIGHT, Global.DIFFICULTY_WEIGHT);
                papers[i] = paper;
            }
        }
    }

    private void generateQuestion(Rule rule,String Type, Random random, int questionNum, double score, String[] idString, String s, Paper paper) {
        View_Question_Info[] Array = null;
        //暂时设置为空，之后需要更改Service方法
        Array = population.questionInfoServiceImpl.GA_QuestionInfo(rule.getCou_Id(), Type, idString);
        View_Question_Info tmpQuestion;
        for (int i = 0; i < questionNum; i++) {
            int index = random.nextInt(Array.length - i);
            //初始化分数
            paper.addQuestion(Array[index]);
            //确保不会出现重复添加试题
            tmpQuestion = Array[Array.length - i -1];
            Array[Array.length - i - 1] = Array[index];
            Array[index] = tmpQuestion;
        }
    }

    /**
     * 获取种群中最优秀的个体 - 精英主义
     */
    public Paper getFitness(){
        Paper paper = papers[0];
        for (int i = 1; i < papers.length; i++) {
            if (paper.getAdaptationDegree() < papers[i].getAdaptationDegree()){
                paper = papers[i];
            }
        }
        return paper;
    }

    public void Population(int populationSize){
        papers = new Paper[populationSize];
    }

    /**
     * 获取种群中某个个体
     */
    public Paper getPaper(int index){
        return papers[index];
    }

    /**
     * 设置种群中某个个体
     */
    public void setPaper(int index, Paper paper){
        papers[index] = paper;
    }

    /**
     * 返回种群规模
     */
    public int getLength(){
        return papers.length;
    }

}
