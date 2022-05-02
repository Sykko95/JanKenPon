package com.cursoAndroid.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickChoice(int playerChoice){
        result(match(cpuChoice(), playerChoice));
    }

    public int match(int cpuChoice, int playerChoice){
       int test = cpuChoice - playerChoice;
       int match = 0;
       switch (test){
           case 0:
               match = 0;
               break;
           case 1:
           case -2:
               match = -1;
               break;
           case -1:
           case 2:
               match = 1;
               break;
       }
       return match;
    }

    public void result(int match){

        TextView actionText = findViewById(R.id.actionText);

        if (match == 1){
            actionText.setText(R.string.win);
        } else if (match == -1){
            actionText.setText(R.string.lose);
        } else {
            actionText.setText(R.string.draw);
        }
    }

   public void chooseRock(View view){
        this.clickChoice(0);
   }

   public void choosePaper(View view){
        this.clickChoice(1);
   }

   public void chooseScissor(View view){
        this.clickChoice(2);
   }

    public int cpuChoice(){

        ImageView appChoiceImg = findViewById(R.id.appChoiceImg);

        int choice = new Random().nextInt(3);
        switch (choice){
            case 0:
                appChoiceImg.setImageResource(R.drawable.pedra);
                break;
            case 1:
                appChoiceImg.setImageResource(R.drawable.papel);
                break;
            case 2:
                appChoiceImg.setImageResource(R.drawable.tesoura);
        }
        return choice;
    }
}