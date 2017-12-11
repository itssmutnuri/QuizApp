package com.srikarmutnuri.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Total Score
    int scoreTotal = 0;

    //individual scores
    int scoreOne, scoreTwo,  scoreThree, scoreFour, scoreFive;

    // Question 1
    RadioButton answer1D;

    // Question 2
    CheckBox answer2A;
    CheckBox answer2B;
    CheckBox answer2C;
    CheckBox answer2D;


    // Question 3
    EditText answerThree;

    // Question 4
    RadioButton answer4C;

    // Question 5
    RadioButton answer5B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables for answers.

        answer1D = (RadioButton) this.findViewById(R.id.answer1D);

        answer2A = (CheckBox) this.findViewById(R.id.answer2A);
        answer2B = (CheckBox) this.findViewById(R.id.answer2B);
        answer2D = (CheckBox) this.findViewById(R.id.answer2C);
        answer2C = (CheckBox) this.findViewById(R.id.answer2D);

        answerThree = (EditText) this.findViewById(R.id.answerThree);

        answer4C = (RadioButton) this.findViewById(R.id.answer4C);

        answer5B = (RadioButton) this.findViewById(R.id.answer5B);

    }

    // Radio button ON check for answer One
    void answerOne() {

        Boolean answer1;

        answer1 = answer1D.isChecked();
        if (answer1) {
            scoreOne = 1;
        } else {
            scoreOne = 0;
        }
    }

    //CheckBoxes ON check for answer Two. Options three and four should be checked ON in this case.
    void answerTwo(){

        Boolean choice1;
        Boolean choice2;
        Boolean choice3;
        Boolean choice4;

        choice1 = answer2A.isChecked();
        choice2 = answer2B.isChecked();
        choice3 = answer2C.isChecked();
        choice4 = answer2D.isChecked();

        if (!choice1 && !choice2 && choice3 && choice4) {
            scoreTwo = 1;
        } else {
            scoreTwo = 0;
        }

    }

    //EditText input match check for answer Three
    void answerThree(){

        String answer3;

        answer3 = answerThree.getText().toString();

        if(answer3.equals("14")){
            scoreThree=1;
        }else{
            scoreThree=0;
        }

    }

    // Radio button ON check for answer Four
    void answerFour(){

        Boolean answer4;

        answer4 = answer4C.isChecked();
        if (answer4) {
            scoreFour = 1;
        } else {
            scoreFour = 0;
        }

    }

    // Radio button ON check for answer Five
    void answerFive(){

        Boolean answer5;

        answer5 = answer5B.isChecked();
        if (answer5) {
            scoreFive = 1;
        } else {
            scoreFive = 0;
        }

    }



    //Function to be called when SUBMIT is clicked. This handles the logics.
    public void onClickSubmit(View view){

        CharSequence text;

        //Function calls. Add methods here for additional questions.
        answerOne();
        answerTwo();
        answerThree();
        answerFour();
        answerFive();


        //calculate total score from individual ones.
        scoreTotal = scoreOne + scoreTwo +  scoreThree + scoreFour + scoreFive;

        //set TOAST text by score.
        if(scoreTotal==5){
            text = "5/5. Congrats!";
        }else{
            text = "Your Score: "+scoreTotal+"/5";
        }

        //TOAST call for message display.
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
