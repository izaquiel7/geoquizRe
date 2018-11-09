package com.example.ifpe.izaquiel.geoquiz.model;

public class Pergunta {

    private int textId;
    private boolean answerTrue;

    public Pergunta(int textId, boolean answerTrue){
        this.textId = textId;
        this.answerTrue = answerTrue;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
