package com.example.ifpe.izaquiel.geoquiz.model;

public class Question {

    private int textId;
    private boolean answerIsTrue;

    public Question(int textId, boolean answerIsTrue){
        this.textId = textId;
        this.answerIsTrue = answerIsTrue;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public boolean isAnswerIsTrue() {
        return answerIsTrue;
    }

    public void setAnswerIsTrue(boolean answerIsTrue) {
        this.answerIsTrue = answerIsTrue;
    }
}
