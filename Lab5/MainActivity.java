package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ask();
    }

    private Game game = new Game();
    private String question;
    private String answer;
    private int score = 0;
    private int qNum = 1;

    private void ask(){
        String[] QandR = game.qa().split("\n", 2);
        question = QandR[0];
        answer = QandR[1].toUpperCase();

        ((TextView) findViewById(R.id.question)).setText(question);
    }

    public void onDone(View v){
        if(qNum == 10){
            ((TextView) findViewById(R.id.qNum)).setText("Game Over!");
            finish();
        }
        else{
            EditText answerView = findViewById(R.id.answer);
            String inputAnswer = answerView.getText().toString().toUpperCase();
            if(inputAnswer.equals(answer)){
                score++;
                ((TextView) findViewById(R.id.score)).setText("SCORE= " + score);
                ((TextView) findViewById(R.id.log)).append("Q# " + qNum + ": " + question + "\n" + "Your answer: " + inputAnswer + "\n" + "Correct answer: " + answer + "\n\n");
            }
            else{
                ((TextView) findViewById(R.id.score)).setText("SCORE= " + score);
                ((TextView) findViewById(R.id.log)).append("Q# " + qNum + ": " + question + "\n" + "Your answer: " + inputAnswer + "\n" + "Correct answer: " + answer + "\n\n");
            }
        }
        qNum++;
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + qNum);
        ask();
    }
}
