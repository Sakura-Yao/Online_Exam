package com.huade.pojo;

public class View_QuestionCollection {

    private String id;
    private String question_Id;
    private String user_Id;
    private String cou_Id;
    private String cou_Name;
    private String type_Id;
    private String subject;
    private String choice_A;
    private String choice_B;
    private String choice_C;
    private String choice_D;
    private String answer;
    private String kwl_Name;

    @Override
    public String toString() {
        return "View_QuestionCollection{" +
                "id='" + id + '\'' +
                ", question_Id='" + question_Id + '\'' +
                ", user_Id='" + user_Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", type_Id='" + type_Id + '\'' +
                ", subject='" + subject + '\'' +
                ", choice_A='" + choice_A + '\'' +
                ", choice_B='" + choice_B + '\'' +
                ", choice_C='" + choice_C + '\'' +
                ", choice_D='" + choice_D + '\'' +
                ", answer='" + answer + '\'' +
                ", kwl_Name='" + kwl_Name + '\'' +
                '}';
    }

    public String getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(String question_Id) {
        this.question_Id = question_Id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
    }

    public String getType_Id() {
        return type_Id;
    }

    public void setType_Id(String type_Id) {
        this.type_Id = type_Id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getKwl_Name() {
        return kwl_Name;
    }

    public void setKwl_Name(String kwl_Name) {
        this.kwl_Name = kwl_Name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public View_QuestionCollection(String id, String question_Id, String user_Id, String cou_Id, String cou_Name, String type_Id, String subject, String choice_A, String choice_B, String choice_C, String choice_D, String answer, String kwl_Name) {
        this.id = id;
        this.question_Id = question_Id;
        this.user_Id = user_Id;
        this.cou_Id = cou_Id;
        this.cou_Name = cou_Name;
        this.type_Id = type_Id;
        this.subject = subject;
        this.choice_A = choice_A;
        this.choice_B = choice_B;
        this.choice_C = choice_C;
        this.choice_D = choice_D;
        this.answer = answer;
        this.kwl_Name = kwl_Name;
    }
}
