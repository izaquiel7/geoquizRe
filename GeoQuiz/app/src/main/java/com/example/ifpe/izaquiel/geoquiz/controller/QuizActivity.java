package com.example.ifpe.izaquiel.geoquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ifpe.izaquiel.geoquiz.R;
import com.example.ifpe.izaquiel.geoquiz.model.Question;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button backButton;
    private TextView textViewId;
    private int currentIndex;



    Question[] questions = new Question[]{
            new Question(R.string.question1, false),
            new Question(R.string.question2, false),
            new Question(R.string.question3, true),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true),
            new Question(R.string.question6, true),
            new Question(R.string.question7, false),
            new Question(R.string.question8, true),
            new Question(R.string.question9, true),
            new Question(R.string.question10, false),
    };

    private void updateQuestion(){
        int idQuestion = questions[currentIndex].getTextId();
        textViewId.setText(idQuestion);
    }

    private void checkAnswer(boolean userPressed){
        boolean answerIsTrue = questions[currentIndex].isAnswerIsTrue();

        int messageId = (answerIsTrue == userPressed)?
                R.string.t_correto:
                R.string.t_incorreto;

        if (answerIsTrue == userPressed){
            currentIndex = (ran.nextInt(9) + 1) % questions.length;
        }

        Toast.makeText(QuizActivity.this, messageId, Toast.LENGTH_SHORT).show();
    }

    Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button) findViewById(R.id.truebutton);
        falseButton = (Button) findViewById(R.id.falsebutton);
        nextButton = (Button) findViewById(R.id.nextbutton);
        backButton = (Button)  findViewById(R.id.backbutton);
        textViewId = (TextView) findViewById(R.id.textview);

        int question = questions[currentIndex].getTextId();
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
                currentIndex = (ran.nextInt(9) + 1) % questions.length;
                updateQuestion();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex==0){
                    currentIndex = questions.length;
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

    public Question[] getQuestions() {
        return questions;
    }
}
