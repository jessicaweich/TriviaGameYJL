package com.mycompany.triviagame;
public class Question {
    protected static int questionsAnswered;
    protected static int answersCorrect;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctIndex;
    // add a category instance variable

    public Question(String question, String answer1, String answer2, String answer3, String answer4, int correctIndex) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        //this.answers = {answer1, answer2, answer3, answer4};
        this.correctIndex = correctIndex;
    }
    //Additional Constructor??

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer1() {
        return answer1;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
    public String getAnswer3() {
        return answer3;
    }
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
    public String getAnswer4() {
        return answer4;
    }
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
    public int getCorrectIndex() {
        return correctIndex;
    }
    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }

}
