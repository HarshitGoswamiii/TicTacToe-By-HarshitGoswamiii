package com.harshuu.tictactoe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int flag =0;
    int count=0;
    boolean gameover=false;
    Button button;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        conv()  ;
        button = findViewById(R.id.restart);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },2000);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });
    }
    private void conv() {
        btn1 = findViewById(R.id.btns1);
        btn2 = findViewById(R.id.btns2);
        btn3 = findViewById(R.id.btns3);
        btn4 = findViewById(R.id.btns4);
        btn5 = findViewById(R.id.btns5);
        btn6 = findViewById(R.id.btns6);
        btn7 = findViewById(R.id.btns7);
        btn8 = findViewById(R.id.btns8);
        btn9 = findViewById(R.id.btns9);
    }
    public void restart () {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;
        gameover=false;
    }
    public void check(View view) {
        if(gameover) return;
        Button btwCurrent = (Button) view;
        if (btwCurrent.getText().toString().isEmpty()) {
            count++;
            if (flag == 0) {
                btwCurrent.setText("X");
                flag = 1;
            } else {
                btwCurrent.setText("O");
                flag = 0;
            }
            if (count > 4) {
                bt1 = btn1.getText().toString();
                bt2 = btn2.getText().toString();
                bt3 = btn3.getText().toString();
                bt4 = btn4.getText().toString();
                bt5 = btn5.getText().toString();
                bt6 = btn6.getText().toString();
                bt7 = btn7.getText().toString();
                bt8 = btn8.getText().toString();
                bt9 = btn9.getText().toString();

                if (bt1.equals(bt2) && bt2.equals(bt3) && !bt1.isEmpty()) {
                    announceWinner(bt1);
                    
                } else if (bt4.equals(bt5) && bt5.equals(bt6) && !bt4.isEmpty()) {
                    announceWinner(bt4);
                    
                } else if (bt7.equals(bt8) && bt8.equals(bt9) && !bt7.isEmpty()) {
                    announceWinner(bt7);
                    
                } else if (bt1.equals(bt4) && bt4.equals(bt7) && !bt1.isEmpty()) {
                    announceWinner(bt1);
                    
                } else if (bt2.equals(bt5) && bt5.equals(bt8) && !bt8.isEmpty()) {
                    announceWinner(bt2);
                    
                } else if (bt3.equals(bt6) && bt6.equals(bt9) && !bt3.isEmpty()) {
                    announceWinner(bt3);
                    
                } else if (bt1.equals(bt5) && bt5.equals(bt9) && !bt5.isEmpty()) {
                    announceWinner(bt1);
                    
                } else if (bt3.equals(bt5) && bt5.equals(bt7) && !bt3.isEmpty()) {
                    announceWinner(bt3);
                    
                } else if (count == 9) {
                    announceDraw();
                    
                }
            }
        }
    }

    private void announceWinner(String winner) { //For Declaration of Winner
        Toast.makeText(this, "Winner: " + winner, Toast.LENGTH_SHORT).show();
        // Delay the restart by 2 seconds
        gameover = true;
        new Handler().postDelayed(this::restart, 1000);
    }

    private void announceDraw() {  //    For Declaring Draw : If no one wins
        Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
        // Delay the restart by 2 seconds
        gameover=true;
        new Handler().postDelayed(this::restart, 1000);
    }
    }