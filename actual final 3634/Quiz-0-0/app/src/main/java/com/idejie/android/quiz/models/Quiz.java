package com.idejie.android.quiz.models;

public class Quiz {
    public int id;
    public String question;
    public String choice1;
    public String choice2;
    public String choice3;
    public int correctID;
    public String feedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getCorrectID() {
        return correctID;
    }

    public void setCorrectID(int correctID) {
        this.correctID = correctID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Quiz(int id, String question, String choice1, String choice2, String choice3, int correctID, String feedback) {

        this.id = id;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.correctID = correctID;
        this.feedback = feedback;
    }

    public Quiz() {

    }
}
