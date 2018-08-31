package com.example.ifpe.izaquiel.geoquiz.model;

public class Pergunta {

    private int testoId;
    private boolean respostaCerta;

    public Pergunta(int testoId, boolean respostaCerta){
        this.testoId = testoId;
        this.respostaCerta = respostaCerta;
    }

    public int getTestoId() {
        return testoId;
    }

    public void setTestoId(int testoId) {
        this.testoId = testoId;
    }

    public boolean isRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(boolean respostaCerta) {
        this.respostaCerta = respostaCerta;
    }
}
