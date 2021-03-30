package com.huade.pojo;

/**
 * 组卷规则，考试大纲
 */
public class Exam_Rule {

    private String Id;
    private String rule_Name;
    private String exam_Id;
    private String cou_Id;
    private String totalMark;
    private String difficulty;
    private String singleNum;
    private String singleScore;
    private String completeNum;
    private String completeScore;
    private String subjectNum;
    private String subjectScore;
    private String pointIds;
    private String rule_Time;

    public Exam_Rule() {

    }

    @Override
    public String toString() {
        return "Exam_Rule{" +
                "Id='" + Id + '\'' +
                ", rule_Name='" + rule_Name + '\'' +
                ", exam_Id='" + exam_Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", totalMark='" + totalMark + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", singleNum='" + singleNum + '\'' +
                ", singleScore='" + singleScore + '\'' +
                ", completeNum='" + completeNum + '\'' +
                ", completeScore='" + completeScore + '\'' +
                ", subjectNum='" + subjectNum + '\'' +
                ", subjectScore='" + subjectScore + '\'' +
                ", pointIds='" + pointIds + '\'' +
                ", rule_Time='" + rule_Time + '\'' +
                '}';
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

    public Exam_Rule(String id, String rule_Name, String exam_Id, String cou_Id, String totalMark, String difficulty, String singleNum, String singleScore, String completeNum, String completeScore, String subjectNum, String subjectScore, String pointIds, String rule_Time) {
        Id = id;
        this.rule_Name = rule_Name;
        this.exam_Id = exam_Id;
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
}
