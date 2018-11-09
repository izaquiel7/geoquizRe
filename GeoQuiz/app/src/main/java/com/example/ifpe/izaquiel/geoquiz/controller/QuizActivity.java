package com.example.ifpe.izaquiel.geoquiz.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ifpe.izaquiel.geoquiz.R;
import com.example.ifpe.izaquiel.geoquiz.model.Pergunta;

import java.util.Arrays;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {


    private static final String tag = "QuizActivity";
    private static final String i_chave = "index";
    private static final int request_code_cheat = 0;

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button backButton;
    private TextView textViewId;
    private TextView pontosViewId;
    private int currentIndex;
    private Button cheatButton;


    Pergunta[] perguntas = new Pergunta[]{
            new Pergunta(R.string.question1, false),
            new Pergunta(R.string.question2, false),
            new Pergunta(R.string.question3, true),
            new Pergunta(R.string.question4, true),
            new Pergunta(R.string.question5, true),
            new Pergunta(R.string.question6, true),
            new Pergunta(R.string.question7, false),
            new Pergunta(R.string.question8, true),
            new Pergunta(R.string.question9, true),
            new Pergunta(R.string.question10, false),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "Metodo o create() chamado");

        setContentView(R.layout.activity_quiz);

        if(savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(i_chave, 0);
        }

        trueButton = (Button) findViewById(R.id.truebutton);
        falseButton = (Button) findViewById(R.id.falsebutton);
        nextButton = (Button) findViewById(R.id.nextbutton);
        backButton = (Button) findViewById(R.id.backbutton);
        textViewId = (TextView) findViewById(R.id.textview);
        pontosViewId = (TextView) findViewById(R.id.pontosview);
        cheatButton = (Button)  findViewById(R.id.cheat_button);

        Collections.shuffle(Arrays.asList(perguntas));

        int question = perguntas[currentIndex].getTextId();
        textViewId.setText(question);


        //**Listeners para os buttons**//

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex =  (currentIndex + 1)% perguntas.length;
                updateQuestion();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    currentIndex = perguntas.length;
                }
                currentIndex = currentIndex - 1;

                updateQuestion();
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerIsTrue = perguntas[currentIndex].isAnswerTrue();

                Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);

                startCheatActivity(intent);
            }
        });

        //**end listeners**//

        //**end onCreate()**//
    }

    private void startCheatActivity(Intent intent) {
    }

    private void updateQuestion() {
        int idQuestion = perguntas[currentIndex].getTextId();
        textViewId.setText(idQuestion);
    }

    int total =0;
    public void somaPonto (boolean soma){

        if(soma){
            total++;

        }else{
            total--;
        }
        Toast.makeText(QuizActivity.this, "pontos:"+total, Toast.LENGTH_SHORT).show();
    }

    private void checkAnswer(boolean userPressed) {
        boolean answerIsTrue = perguntas[currentIndex].isAnswerTrue();

        if (answerIsTrue == userPressed) {

            Toast.makeText(QuizActivity.this, R.string.t_correto, Toast.LENGTH_SHORT).show();
            currentIndex =  (currentIndex + 1)% perguntas.length;
            updateQuestion();
            somaPonto(true);
        }
        else {

            Toast.makeText(QuizActivity.this, R.string.t_incorreto, Toast.LENGTH_SHORT).show();
            currentIndex =  (currentIndex + 1)% perguntas.length;
            updateQuestion();
            somaPonto(false);
        }

    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.d(tag, "esse negocio chamou onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.d(tag, "esse negocio chamou onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();

        Log.d(tag, "esse negocio chamou onPause()");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(tag, "salvando a instancia do estado.");
        savedInstanceState.putInt(i_chave, currentIndex);
    }
    @Override
    protected void onStop(){


        super.onStop();

        Log.d(tag, "esse negocio chamou onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d(tag, "esse negocio chamou onDestroy()");
    }

    //**Getters n Setters**//
    public Button getTrueButton() {
        return trueButton;
    }

    public void setTrueButton(Button trueButton) {
        this.trueButton = trueButton;
    }

    public Button getFalseButton() {
        return falseButton;
    }

    public void setFalseButton(Button falseButton) {
        this.falseButton = falseButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public TextView getTextViewId() {
        return textViewId;
    }

    public void setTextViewId(TextView textViewId) {
        this.textViewId = textViewId;
    }


    //**end getters e setters**//

    public int getCurrentIndex() {
        return currentIndex;
    }

    public Pergunta[] getPerguntas() {
        return perguntas;
    }
}
