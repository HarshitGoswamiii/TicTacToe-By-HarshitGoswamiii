package com.harshuu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Homepage extends AppCompatActivity {
Button butt;
EditText playerone;
EditText playertwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        butt = findViewById(R.id.start);
        playerone = findViewById(R.id.player_one);
        playertwo = findViewById(R.id.playertwo);

        Intent MainPage = new Intent(this,MainActivity.class);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage);
            }
        });

    }
}