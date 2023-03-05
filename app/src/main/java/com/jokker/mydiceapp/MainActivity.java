package com.jokker.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImage1 = findViewById(R.id.diceImageView1);
        ImageView diceImage2 = findViewById(R.id.diceImageView2);

        int[] diceImages = { R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                             R.drawable.dice4, R.drawable.dice5, R.drawable.dice6 };


        Button rollDiceButton = findViewById(R.id.btnRollDiceId);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i( "rollDiceButton", "Roll the Dice button clicked !" );
                Random rndObj = new Random();
                int randomNumber1 = rndObj.nextInt(6);
                int randomNumber2 = rndObj.nextInt(6);
                Log.i( "random numbers generated : ", randomNumber1 + ", " + randomNumber2 );

                diceImage1.setImageResource(diceImages[randomNumber1]);
                diceImage2.setImageResource(diceImages[randomNumber2]);

                if( randomNumber1 == 5 && randomNumber2 == 5 ) {
                    Toast.makeText( getApplicationContext(), "Boom Yeah !!!", Toast.LENGTH_SHORT ).show();
                }

                YoYo.with(Techniques.Pulse)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.FadeInDown)
                        .duration(700)
                        .repeat(1)
                        .playOn(diceImage2);

                mp.start();

            }
        });

    }

    public void onClickFunction(View view) throws InterruptedException {
        Log.i( "onClickFunction", "on click function button clicked !" );

    }
}