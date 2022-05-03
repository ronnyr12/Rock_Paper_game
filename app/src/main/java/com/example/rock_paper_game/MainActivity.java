package com.example.rock_paper_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //phase1 - declaration
    Button btn_rock, btn_paper, btn_scissors;
    ImageView iv_cpu, iv_player;

    String player_choise ,cpuChoise, result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //phase2 - referencing
        btn_paper = findViewById(R.id.btn_paper);
        btn_rock = findViewById(R.id.btn_rock);
        btn_scissors = findViewById(R.id.btn_scissors);
        iv_cpu = findViewById(R.id.iv_cpu);
        iv_player = findViewById(R.id.iv_player);

        r = new Random();

        //phase3 - listeners
        btn_paper.setOnClickListener(this);
        btn_rock.setOnClickListener(this);
        btn_scissors.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_paper:
                player_choise = "paper";
                iv_player.setImageResource(R.drawable.paper);
                elAlgorithm();
                break;
            case R.id.btn_rock:
                player_choise = "rock";
                iv_player.setImageResource(R.drawable.rock);
                elAlgorithm();
                break;
            case R.id.btn_scissors:
                player_choise = "scissors";
                iv_player.setImageResource(R.drawable.scissors);
                elAlgorithm();
                break;

        }
    }

    private void elAlgorithm() {
        int cpu = r.nextInt(3);
        if(cpu == 0) {
            cpuChoise = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if(cpu==1) {
            cpuChoise = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }else if(cpu==2) {
            cpuChoise = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(player_choise.equals("rock") && cpuChoise.equals("paper")){
            result = "you win";
        }
        else if(player_choise.equals("rock") && cpuChoise.equals("scissors")){
            result = "you lose";
        }
        else if(player_choise.equals("paper") && cpuChoise.equals("rock")){
            result = "you win";
        }
        else if(player_choise.equals("paper") && cpuChoise.equals("scissors")){
            result = "you lose";
        }
        else if(player_choise.equals("scissors") && cpuChoise.equals("paper")){
            result = "you win";
        }
        else if(player_choise.equals("scissors") && cpuChoise.equals("rock")){
            result = "you lose";
        }
        else if(player_choise.equals("rock") && cpuChoise.equals("rock")){
            result = "draw";
        }
        else if(player_choise.equals("paper") && cpuChoise.equals("paper")){
            result = "draw";
        }
        else if(player_choise.equals("scissors") && cpuChoise.equals("scissors")){
            result = "draw";
        }
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
    }
}