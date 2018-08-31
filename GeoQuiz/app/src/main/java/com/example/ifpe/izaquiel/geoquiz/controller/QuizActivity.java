package com.example.ifpe.izaquiel.geoquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ifpe.izaquiel.geoquiz.R;
import com.example.ifpe.izaquiel.geoquiz.model.Pergunta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button backButton;
    private TextView textViewId;
    private TextView pontosViewId;
    private int currentIndex;


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

    private void updateQuestion() {
        int idQuestion = perguntas[currentIndex].getTestoId();
        textViewId.setText(idQuestion);
    }

    private void checkAnswer(boolean userPressed) {
        boolean answerIsTrue = perguntas[currentIndex].isRespostaCerta();

//        if (answerIsTrue == userPressed)
//          Toast.makeText(QuizActivity.this, R.string.t_correto, Toast.LENGTH_SHORT).show();
//            System.out.print("verdade");
//        else
//           Toast.makeText(QuizActivity.this, R.string.t_incorreto, Toast.LENGTH_SHORT).show();
//            System.out.print("Falso");

        if (answerIsTrue== userPressed){
            updateQuestion();
            Toast.makeText(QuizActivity.this, R.string.t_correto, Toast.LENGTH_SHORT).show();
        }else {
            updateQuestion();
            Toast.makeText(QuizActivity.this, R.string.t_incorreto, Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button) findViewById(R.id.truebutton);
        falseButton = (Button) findViewById(R.id.falsebutton);
        nextButton = (Button) findViewById(R.id.nextbutton);
        backButton = (Button) findViewById(R.id.backbutton);
        textViewId = (TextView) findViewById(R.id.textview);

        Collections.shuffle(Arrays.asList(perguntas));

        int question = perguntas[currentIndex].getTestoId();
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

        //**end listeners**//

        //**end onCreate()**//
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
