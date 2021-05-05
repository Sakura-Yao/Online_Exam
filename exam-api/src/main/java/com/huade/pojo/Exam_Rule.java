package com.huade.pojo;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 组卷规则，考试大纲
 */
public class Exam_Rule {

    private String Id;
    private String rule_Name;
    private String exam_Id;
    private String cou_Id;
    private String classes;
    private String totalMark;
    private String difficulty;
    private String singleNum;
    private String singleScore;
    private String completeNum;
    private String completeScore;
    private String judgeNum;
    private String judgeScore;
    private String nounNum;
    private String nounScore;
    private String subjectNum;
    private String subjectScore;
    private String fillcodeNum;
    private String fillcodeScore;
    private String codingNum;
    private String codingScore;
    private String pointIds;
    private String pointNames;
    private String rule_Time;

    @Override
    public String toString() {
        return "Exam_Rule{" +
                "Id='" + Id + '\'' +
                ", rule_Name='" + rule_Name + '\'' +
                ", exam_Id='" + exam_Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", classes='" + classes + '\'' +
                ", totalMark='" + totalMark + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", singleNum='" + singleNum + '\'' +
                ", singleScore='" + singleScore + '\'' +
                ", completeNum='" + completeNum + '\'' +
                ", completeScore='" + completeScore + '\'' +
                ", judgeNum='" + judgeNum + '\'' +
                ", judgeScore='" + judgeScore + '\'' +
                ", nounNum='" + nounNum + '\'' +
                ", nounScore='" + nounScore + '\'' +
                ", subjectNum='" + subjectNum + '\'' +
                ", subjectScore='" + subjectScore + '\'' +
                ", fillcodeNum='" + fillcodeNum + '\'' +
                ", fillcodeScore='" + fillcodeScore + '\'' +
                ", codingNum='" + codingNum + '\'' +
                ", codingScore='" + codingScore + '\'' +
                ", pointIds='" + pointIds + '\'' +
                ", pointNames='" + pointNames + '\'' +
                ", rule_Time='" + rule_Time + '\'' +
                '}';
    }

    public String getPointNames() {
        return pointNames;
    }

    public void setPointNames(String pointNames) {
        this.pointNames = pointNames;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRule_Name() {
        return rule_Name;
    }

    public void setRule_Name(String rule_Name) {
        this.rule_Name = rule_Name;
    }

    public String getExam_Id() {
        return exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        this.exam_Id = exam_Id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(String singleNum) {
        this.singleNum = singleNum;
    }

    public String getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(String singleScore) {
        this.singleScore = singleScore;
    }

    public String getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(String completeNum) {
        this.completeNum = completeNum;
    }

    public String getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(String completeScore) {
        this.completeScore = completeScore;
    }

    public String getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(String subjectNum) {
        this.subjectNum = subjectNum;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }

    public String getPointIds() {
        return pointIds;
    }

    public void setPointIds(String pointIds) {
        this.pointIds = pointIds;
    }

    public String getRule_Time() {
        return rule_Time;
    }

    public void setRule_Time(String rule_Time) {
        this.rule_Time = rule_Time;
    }

    public String getJudgeNum() {
        return judgeNum;
    }

    public void setJudgeNum(String judgeNum) {
        this.judgeNum = judgeNum;
    }

    public String getJudgeScore() {
        return judgeScore;
    }

    public void setJudgeScore(String judgeScore) {
        this.judgeScore = judgeScore;
    }

    public String getNounNum() {
        return nounNum;
    }

    public void setNounNum(String nounNum) {
        this.nounNum = nounNum;
    }

    public String getNounScore() {
        return nounScore;
    }

    public void setNounScore(String nounScore) {
        this.nounScore = nounScore;
    }

    public String getFillcodeNum() {
        return fillcodeNum;
    }

    public void setFillcodeNum(String fillcodeNum) {
        this.fillcodeNum = fillcodeNum;
    }

    public String getFillcodeScore() {
        return fillcodeScore;
    }

    public void setFillcodeScore(String fillcodeScore) {
        this.fillcodeScore = fillcodeScore;
    }

    public String getCodingNum() {
        return codingNum;
    }

    public void setCodingNum(String codingNum) {
        this.codingNum = codingNum;
    }

    public String getCodingScore() {
        return codingScore;
    }

    public void setCodingScore(String codingScore) {
        this.codingScore = codingScore;
    }

    public Exam_Rule(String rule_Name, String cou_Id, String classes, String totalMark, String difficulty, String singleNum, String singleScore, String completeNum, String completeScore, String judgeNum, String judgeScore, String nounNum, String nounScore, String subjectNum, String subjectScore, String fillcodeNum, String fillcodeScore, String codingNum, String codingScore, String pointIds,String pointNames) {
        Id = UUID.randomUUID().toString().replace("-","");
        this.rule_Name = rule_Name;
        this.exam_Id = UUID.randomUUID().toString().replace("-","");
        this.cou_Id = cou_Id;
        this.classes = classes;
        this.totalMark = totalMark;
        this.difficulty = difficulty;
        this.singleNum = singleNum;
        this.singleScore = singleScore;
        this.completeNum = completeNum;
        this.completeScore = completeScore;
        this.judgeNum = judgeNum;
        this.judgeScore = judgeScore;
        this.nounNum = nounNum;
        this.nounScore = nounScore;
        this.subjectNum = subjectNum;
        this.subjectScore = subjectScore;
        this.fillcodeNum = fillcodeNum;
        this.fillcodeScore = fillcodeScore;
        this.codingNum = codingNum;
        this.codingScore = codingScore;
        this.pointIds = pointIds;
        this.pointNames = pointNames;
        this.rule_Time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
