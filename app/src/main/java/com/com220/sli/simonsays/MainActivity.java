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
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    Button bottomRight;
    Button start;
    TextView score;
    Boolean swap = false;
    Random rand = new Random(3);

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

        score = (TextView)findViewById(R.id.score);
        topLeft = (Button)findViewById(R.id.topleft_button);
        topRight = (Button)findViewById(R.id.topright_button);
        bottomRight = (Button)findViewById(R.id.bottomright_button);
        bottomLeft = (Button)findViewById(R.id.bottomleft_button);
        start = (Button)findViewById(R.id.start);


        Integer [] intArray = new Integer[4];
        for(int i = 0; i < 4; i++)
        {
            Random ran = new Random();
            int randomNumber = ran.nextInt(100);
            intArray[i] = randomNumber;

        }

        int counter;
        topLeft.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                topLeft.setBackgroundColor(Color.BLACK);
                new CountDownTimer(10000, 1000)
                {
                    public void onTick(long mill)
                    {
                        if(swap == false)
                        {
                            topLeft.setBackgroundColor(Color.BLUE);
                            Random ran = new Random();
                            int randNum = ran.nextInt(100);
                            topLeft.setText(randNum + "");
                            swap = true;
                            score = intArray[counter];
                            counter++;
                        }
                        else
                        {
                            topLeft.setBackgroundColor(Color.BLACK);
                            Random ran = new Random();
                            int randNum = ran.nextInt(100);
                            topLeft.setText(randNum + "");
                            swap = false;
                        }
                    }

                    @Override
                    public void onFinish()
                    {
                        topLeft.setBackgroundColor(Color.GREEN);
                    }
                }.start();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
