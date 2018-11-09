package com.example.ifpe.izaquiel.geoquiz.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ifpe.izaquiel.geoquiz.R;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.ifpe.izaquiel.geoquiz.answerIsTrue";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.example.ifpe.izaquiel.geoquiz.answer_shown";
    private boolean respostaQuestao;
    private TextView txtQuestao;
    private Button btMostrarResposta;


    public static Intent newIntent(Context packageContext,
                                   boolean answerIsTrue) {
        Intent intent = new Intent(packageContext,
                CheatActivity.class);

        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        txtQuestao = (TextView) findViewById(R.id.answer_text_view);
        btMostrarResposta = (Button) findViewById(R.id.mostrarRespo);

        respostaQuestao =
                getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);



        btMostrarResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarResposta(respostaQuestao);
            }
        });



    }   private void mostrarResposta(boolean respostaQuestao) {
        txtQuestao.setText(respostaQuestao == true ?
                R.string.b_true :
                R.string.b_false);
        setAnswerShownResult(true);
    }

    private void setAnswerShownResult(boolean respostaApareceu) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,respostaApareceu);
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    public boolean isRespostaQuestao() {
        return respostaQuestao;
    }

    public void setRespostaQuestao(boolean respostaQuestao) {
        this.respostaQuestao = respostaQuestao;
    }

    public static String getExtraAnswerIsTrue() {
        return EXTRA_ANSWER_IS_TRUE;
    }

}


