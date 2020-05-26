package com.rogergcc.memorygame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryGameActivity extends AppCompatActivity {


    private int[] images;
    private Random randNumber;
    private static final String TAG = "MemoryGameActivity";
    private int countClicksToCompare = 0;
    private String firstTag = "";
    private String secondTag = "";

    View buttonClickedFirst;
    View buttonClickedSecond;
    private int countCorrects = 0;
    private int totalClicks = 0;
    private LinearLayout llResults;
    private Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // cow, dinosaur, etc are png files that are copied into the drawable directory
        // google android how to do this...
        // double up the image array - 2 cards get the same picture


        final int[] animals = {
                R.drawable.dog, R.drawable.cat, R.drawable.panda, R.drawable.dog, R.drawable.cat, R.drawable.panda
        };
        // if you want to make an option of different images (animals, planets, elements, just change the association
        // of the images array to a different set of data - use a case statment or other logic
        images = animals.clone();

        setContentView(R.layout.activity_memory_game);


        llResults = findViewById(R.id.ll_resultWon);
        btnPlayAgain = findViewById(R.id.btn_playagain);

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MemoryGameActivity.this, "Ok !", Toast.LENGTH_SHORT).show();
                llResults.setVisibility(View.GONE);
                recreate();
            }
        });


        // create the button array List - an ArrayList is like an array, but it is not a fixed length
        // good practice in Java to learn how to use them

        List<Button> buttonArray = new ArrayList<Button>();

        buttonArray.add((Button) findViewById(R.id.button0));
        buttonArray.add((Button) findViewById(R.id.button1));
        buttonArray.add((Button) findViewById(R.id.button2));
        buttonArray.add((Button) findViewById(R.id.button3));
        buttonArray.add((Button) findViewById(R.id.button4));
        buttonArray.add((Button) findViewById(R.id.button5));


// create randomized order for images - standard swap algorithm to randomize an array -
// //look this up if you've never seen it - it's really cool
        Random rand = new Random();
        for (int i = 0; i < images.length; i++) {
            int randomIndexToSwap = rand.nextInt(images.length);
            int temp;
            temp = images[randomIndexToSwap];
            images[randomIndexToSwap] = images[i];
            images[i] = temp;
        }

        int counter = 0;
        for (Button b : buttonArray) {

//            String name = getResources().getResourceEntryName(images[counter]);

            b.setId(images[counter]);

            b.setTag(images[counter]);  // this line stores the button number into the button in the array -
            // you can use this to see which button eas clicked later in the button
            // callback routine
            Log.d("SETTING BUTTON", String.valueOf(counter));

            counter++;

            b.setBackgroundResource(R.drawable.back);// all cards get a wolf as a background initially

            final int finalCounter = counter;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View buttonClicked) {
                    //getTag will be the index of the button that is clicked.
                    // make that button's image the image in the array
                    totalClicks++;

                    if (countClicksToCompare < 2) {
                        buttonClicked.setBackgroundResource(images[finalCounter - 1]);
                        countClicksToCompare++;
                        Object tag = images[finalCounter - 1];

                        if (countClicksToCompare == 1) {
                            buttonClickedFirst = buttonClicked;

                            buttonClickedFirst.setEnabled(false);

                            firstTag = tag + "";
                            Log.e(TAG, "1st Selected: " + firstTag);
                        }
                        if (countClicksToCompare == 2) {
                            buttonClickedSecond = buttonClicked;

                            secondTag = tag + "";
                            Log.e(TAG, "2nd Selected: " + secondTag);

                            if (firstTag.equals(secondTag)) {   // proper compare syntax needed here

                                buttonClickedFirst.setEnabled(false);
                                buttonClickedSecond.setEnabled(false);
                                Toast.makeText(buttonClicked.getContext(), "Equals", Toast.LENGTH_LONG).show();
                                countClicksToCompare = 0;

                                countCorrects++;

                            } else {
                                buttonClickedFirst.setEnabled(true);
                            }
                        }

                    } else {
                        totalClicks = totalClicks - 1;
                        countClicksToCompare = 0;
//                        Toast.makeText(MemoryGameActivity.this, "More than 2 opens", Toast.LENGTH_SHORT).show();
                        buttonClickedFirst.setBackgroundResource(R.drawable.back);
                        buttonClickedSecond.setBackgroundResource(R.drawable.back);
                    }

                    TextView textViewQuclicks = findViewById(R.id.tv_quantclicks);
                    String quantClickMessage = totalClicks + " clicks";
                    textViewQuclicks.setText(quantClickMessage);

                    if (countCorrects == (animals.length / 2)) {
                        llResults.setVisibility(View.VISIBLE);
                        Toast.makeText(MemoryGameActivity.this, "You Rock!", Toast.LENGTH_SHORT).show();

                    }


                }
            });


        }

    }


}
