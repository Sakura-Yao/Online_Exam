package com.huade.pojo;

import java.util.List;

/**
 * 组卷规则，考试大纲
 */
public class Rule {

    private String Id;
    private String examId;
    private String rule_Name;
    private String cou_Id;
    private double totalMark;
    private double difficulty;
    private int singleNum;
    private double singleScore;
    private int completeNum;
    private double completeScore;
    private int subjectNum;
    private double subjectScore;
    private List<String> pointIds;
    private String rule_Time;

    public Rule() {
    }

    public Rule(String id, String examId, String rule_Name, String cou_Id, double totalMark, double difficulty, int singleNum, double singleScore, int completeNum, double completeScore, int subjectNum, double subjectScore, List<String> pointIds, String rule_Time) {
        Id = id;
        this.examId = examId;
        this.rule_Name = rule_Name;
        this.cou_Id = cou_Id;
        this.totalMark = totalMark;
        this.difficulty = difficulty;
        this.singleNum = singleNum;
        this.singleScore = singleScore;
        this.completeNum = completeNum;
        this.completeScore = completeScore;
        this.subjectNum = subjectNum;
        this.subjectScore = subjectScore;
        this.pointIds = pointIds;
        this.rule_Time = rule_Time;
    }

    public String getRule_Time() {
        return rule_Time;
    }

    public void setRule_Time(String rule_Time) {
        this.rule_Time = rule_Time;
    }

    public String getRule_Name() {
        return rule_Name;
    }

    public void setRule_Name(String rule_Name) {
        this.rule_Name = rule_Name;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(int singleNum) {
        this.singleNum = singleNum;
    }

    public double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(double singleScore) {
        this.singleScore = singleScore;
    }

    public int getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(int completeNum) {
        this.completeNum = completeNum;
    }

    public double getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(double completeScore) {
        this.completeScore = completeScore;
    }

    public int getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(int subjectNum) {
        this.subjectNum = subjectNum;
    }

    public double getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(double subjectScore) {
        this.subjectScore = subjectScore;
    }

    public List<String> getPointIds() {
        return pointIds;
    }

    public void setPointIds(List<String> pointIds) {
        this.pointIds = pointIds;
    }

}
