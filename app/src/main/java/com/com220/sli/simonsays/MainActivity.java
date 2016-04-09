package com.com220.sli.simonsays;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    Button bottomRight;
    Button start;
    TextView score;
    ArrayList<Integer> sequence = new ArrayList<Integer>();
    int listSize = 10;
    Boolean swap = false; //For testing purposes
    StringBuilder combinedString = new StringBuilder();
    int i = 0;
    int counter = 0;
    StringBuilder stringAdd = new StringBuilder();
    ArrayList<Integer> seq = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        score = (TextView) findViewById(R.id.score);
        topLeft = (Button) findViewById(R.id.topleft_button);
        topRight = (Button) findViewById(R.id.topright_button);
        bottomRight = (Button) findViewById(R.id.bottomright_button);
        bottomLeft = (Button) findViewById(R.id.bottomleft_button);
        start = (Button) findViewById(R.id.start);

        final Animation blink = new AlphaAnimation(1,0);
        blink.setDuration(1000);
        blink.setInterpolator(new LinearInterpolator());
        //blink.setRepeatCount(Animation.ABSOLUTE); //or INFINITE
        //blink.setRepeatMode(Animation.REVERSE);
        start.startAnimation(blink);

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                start.clearAnimation();
                sequence.clear();
                stringAdd.setLength(0);
                counter = 0;
                for(int i = 0; i < 60; i++)
                {
                    /*
                    Random random = new Random();
                    int temp = random.nextInt(4);
                    sequence.add(temp);

                    String as;
                    as = temp + " ";
                    stringAdd.append(as);
                    */

                    /*
                    sequence.add(0);
                    sequence.add(1);
                    sequence.add(2);
                    sequence.add(3);
                    sequence.add(0);
                    sequence.add(1);
                    sequence.add(2);
                    sequence.add(3);
                    sequence.add(0);
                    sequence.add(1);
                    sequence.add(2);
                    sequence.add(3);
                    sequence.add(0);
                    */
                }
                new CountDownTimer(10000, 1000)
                {
                    public void onTick(long mill)
                    {
                        Random rdm = new Random();
                        int randomNumber = rdm.nextInt(4);
                        String aS = randomNumber + "";
                        stringAdd.append(aS);
                        seq.add(randomNumber);

                        /*
                        int temp;
                        temp = sequence.get(counter);
                        start.setText(temp + ""); //Driver code
                        counter++;
                        */
                        //if(temp == 0)
                        if(randomNumber == 0)
                        {
                            topRight.clearAnimation();
                            bottomLeft.clearAnimation();
                            bottomRight.clearAnimation();
                            topLeft.startAnimation(blink);

                            //topLeft.setBackgroundColor(Color.GRAY);
                            topRight.setBackgroundColor(Color.GREEN);
                            bottomLeft.setBackgroundColor(Color.BLUE);
                            bottomRight.setBackgroundColor(Color.YELLOW);
                            topLeft.setTextColor(Color.GREEN);
                            topRight.setTextColor(Color.WHITE);
                            bottomLeft.setTextColor(Color.WHITE);
                            bottomRight.setTextColor(Color.WHITE);
                        }
                        //else if(temp == 1)
                        else if(randomNumber == 1)
                        {
                            topLeft.clearAnimation();
                            bottomLeft.clearAnimation();
                            bottomRight.clearAnimation();
                            topRight.startAnimation(blink);

                            topLeft.setBackgroundColor(Color.RED);
                            //topRight.setBackgroundColor(Color.GRAY);
                            bottomLeft.setBackgroundColor(Color.BLUE);
                            bottomRight.setBackgroundColor(Color.YELLOW);
                            topLeft.setTextColor(Color.WHITE);
                            topRight.setTextColor(Color.GREEN);
                            bottomLeft.setTextColor(Color.WHITE);
                            bottomRight.setTextColor(Color.WHITE);
                        }
                        //else if(temp == 2)
                        else if(randomNumber == 2)
                        {
                            topLeft.clearAnimation();
                            topRight.clearAnimation();
                            bottomRight.clearAnimation();
                            bottomLeft.startAnimation(blink);

                            topLeft.setBackgroundColor(Color.RED);
                            topRight.setBackgroundColor(Color.GREEN);
                            //bottomLeft.setBackgroundColor(Color.GRAY);
                            bottomRight.setBackgroundColor(Color.YELLOW);
                            topLeft.setTextColor(Color.WHITE);
                            topRight.setTextColor(Color.WHITE);
                            bottomLeft.setTextColor(Color.GREEN);
                            bottomRight.setTextColor(Color.WHITE);
                        }
                        //else if(temp == 3)
                        else if(randomNumber == 3)
                        {
                            topLeft.clearAnimation();
                            topRight.clearAnimation();
                            bottomLeft.clearAnimation();
                            bottomRight.startAnimation(blink);

                            topLeft.setBackgroundColor(Color.RED);
                            topRight.setBackgroundColor(Color.GREEN);
                            bottomLeft.setBackgroundColor(Color.BLUE);
                            //bottomRight.setBackgroundColor(Color.GRAY);
                            topLeft.setTextColor(Color.WHITE);
                            topRight.setTextColor(Color.WHITE);
                            bottomLeft.setTextColor(Color.WHITE);
                            bottomRight.setTextColor(Color.GREEN);
                        }
                        else
                        {
                            start.setBackgroundColor(Color.BLACK);
                        }
                    }
                    @Override
                    public void onFinish()
                    {
                        topLeft.setBackgroundColor(Color.RED);
                        topRight.setBackgroundColor(Color.GREEN);
                        bottomLeft.setBackgroundColor(Color.BLUE);
                        bottomRight.setBackgroundColor(Color.YELLOW);
                        topLeft.setTextColor(Color.WHITE);
                        topRight.setTextColor(Color.WHITE);
                        bottomLeft.setTextColor(Color.WHITE);
                        bottomRight.setTextColor(Color.WHITE);
                        topLeft.clearAnimation();
                        topRight.clearAnimation();
                        bottomLeft.clearAnimation();
                        bottomRight.clearAnimation();
                        score.setText(stringAdd.toString());
                    }
                }.start();
            }
        });

        topLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new CountDownTimer(10000, 1000)
                {
                    public void onTick(long mill)
                    {
                        if(swap == false)
                        {
                            topLeft.setBackgroundColor(Color.BLUE);
                            topRight.setBackgroundColor(Color.BLUE);
                            bottomLeft.setBackgroundColor(Color.BLUE);
                            bottomRight.setBackgroundColor(Color.BLUE);
                            Random ran = new Random();
                            int randNum = ran.nextInt(100);
                            topLeft.setText(randNum + "");
                            swap = true;
                        }
                        else
                        {
                            topLeft.setBackgroundColor(Color.BLACK);
                            topRight.setBackgroundColor(Color.BLACK);
                            bottomLeft.setBackgroundColor(Color.BLACK);
                            bottomRight.setBackgroundColor(Color.BLACK);
                            Random ran = new Random();
                            int randNum = ran.nextInt(100);
                            topLeft.setText(randNum + "");
                            swap = false;
                        }
                    }

                    @Override
                    public void onFinish()
                    {
                        topLeft.setBackgroundColor(Color.RED);
                        topRight.setBackgroundColor(Color.GREEN);
                        bottomLeft.setBackgroundColor(Color.BLUE);
                        bottomRight.setBackgroundColor(Color.YELLOW);
                    }
                }.start();
            }
        });

        /*
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                start.setBackgroundColor(Color.RED);
                score.setText("START!");
                for(int i = 0; i < listSize; i++)
                {
                    Random rand = new Random();
                    int randNum = rand.nextInt(4);
                    sequence.add(randNum);
                    String s = randNum + "";
                    combinedString.append(s);
                }
                long sequenceRuntime = listSize * 1000;
                new CountDownTimer(sequenceRuntime, 1000)
                {
                    @Override
                    public void onTick(long millisUntilFinished)
                    {
                        if(swap == true)
                        {
                            start.setBackgroundColor(Color.BLACK);
                            String s = sequence.get(i).intValue() + "";
                            score.setText(s);
                            i++;
                            swap = false;
                        }
                        else
                        {
                            start.setBackgroundColor(Color.BLUE);
                            String s = sequence.get(i).intValue() + "";
                            score.setText(s);
                            i++;
                            swap = true;
                        }
                    }

                    @Override
                    public void onFinish()
                    {
                        start.setBackgroundColor(Color.RED);
                        score.setText(combinedString.toString());
                    }
                }.start();
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
/* Experimental/throwaway code section:

//Randomizes colors
Random red = new Random();
Random green = new Random();
Random blue = new Random();
int redNum = red.nextInt(255);
int greenNum = green.nextInt(255);
int blueNum = blue.nextInt(255);
StringBuilder randomColor = new StringBuilder();
randomColor.append(redNum + "");
randomColor.append(greenNum + "");
randomColor.append(blueNum + "");
*/