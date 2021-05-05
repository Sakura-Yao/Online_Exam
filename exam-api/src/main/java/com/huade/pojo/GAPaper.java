package com.huade.pojo;

import java.util.ArrayList;
import java.util.List;

public class GAPaper {

    private int Id;
    private double adaptationDegree ;
    private double KPCoverage ;
    private double totalScore ;
    private double difficulty ;
    private List<View_Question_Info> questionList ;

    @Override
    public String toString() {
        return "GAPaper{" +
                "Id=" + Id +
                ", adaptationDegree=" + adaptationDegree +
                ", KPCoverage=" + KPCoverage +
                ", totalScore=" + totalScore +
                ", difficulty=" + difficulty +
                ", questionList=" + questionList +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getAdaptationDegree() {
        return adaptationDegree;
    }

    public void setAdaptationDegree(double adaptationDegree) {
        this.adaptationDegree = adaptationDegree;
    }

    public double getKPCoverage() {
        return KPCoverage;
    }

    public void setKPCoverage(double KPCoverage) {
        this.KPCoverage = KPCoverage;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public List<View_Question_Info> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<View_Question_Info> questionList) {
        this.questionList = questionList;
    }
}
