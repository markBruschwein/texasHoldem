package com.example.markbruschwein.texasholdem;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    //instance variables for custom betting
    protected SeekBar betSeekBar = null;
    protected TextView betTextView = null;

    // cards in the middle
    protected LinearLayout card1 = null;
    protected LinearLayout card2 = null;
    protected LinearLayout card3 = null;
    protected LinearLayout card4 = null;
    protected LinearLayout card5 = null;

    // instance variables related to the user's hand
    protected boolean card1Check = false;
    protected boolean card2Check = false;
    protected boolean card3Check = false;
    protected boolean card4Check = false;
    protected boolean card5Check = false;
    protected boolean handCard1Check = false;
    protected boolean handCard2Check = false;
    protected LinearLayout handCard1 = null;
    protected LinearLayout handCard2 = null;
    protected TextView userCard1ValueTop = null;
    protected TextView userCard1ValueSuit = null;
    protected TextView userCard1ValueBottom = null;
    protected TextView userCard2ValueTop = null;
    protected TextView userCard2ValueSuit = null;
    protected TextView userCard2ValueBottom = null;
    protected Button foldButton = null;


    protected int numCardsSelected = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        betSeekBar = (SeekBar)findViewById(R.id.betSeekBar);
        betSeekBar.setOnSeekBarChangeListener(this);

        betTextView = (TextView)findViewById(R.id.betTextView);



        // for handling the event that fold is selected
        handCard1 = (LinearLayout)findViewById(R.id.handCard1);
        handCard2 = (LinearLayout)findViewById(R.id.handCard2);
        userCard1ValueBottom = (TextView)findViewById(R.id.userCard1ValueBottom);
        userCard1ValueSuit = (TextView)findViewById(R.id.userCard1Suit);
        userCard1ValueTop = (TextView)findViewById(R.id.userCard1ValueTop);
        userCard2ValueBottom = (TextView)findViewById(R.id.userCard2ValueBottom);
        userCard2ValueSuit = (TextView)findViewById(R.id.userCard2Suit);
        userCard2ValueTop = (TextView)findViewById(R.id.userCard2ValueTop);
        foldButton = (Button)findViewById(R.id.foldButton);
        foldButton.setOnClickListener(this);


        // for all face up cards
        handCard1.setOnClickListener(this);
        handCard2.setOnClickListener(this);
        card1 = (LinearLayout)findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = (LinearLayout)findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = (LinearLayout)findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = (LinearLayout)findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = (LinearLayout)findViewById(R.id.card5);
        card5.setOnClickListener(this);
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

    @Override
    public void onClick(View v)
    {
        // the next five if else statements are for
        // highlighting cards, but no more than five can be chosen at once
        if(v.getId() == R.id.card1)
        {
            if(card1Check == false && numCardsSelected < 5)
            {
                this.card1.setBackgroundColor(0xFFFFFF4D);
                card1Check = true;
                numCardsSelected++;
            }
            else if(card1Check == true)
            {
                this.card1.setBackgroundColor(0xFFFCFBFB);
                card1Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.card2)
        {
            if(card2Check == false && numCardsSelected < 5)
            {
                this.card2.setBackgroundColor(0xFFFFFF4D);
                card2Check = true;
                numCardsSelected++;
            }
            else if(card2Check == true)
            {
                this.card2.setBackgroundColor(0xFFFCFBFB);
                card2Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.card3)
        {
            if(card3Check == false && numCardsSelected < 5)
            {
                this.card3.setBackgroundColor(0xFFFFFF4D);
                card3Check = true;
                numCardsSelected++;
            }
            else if(card3Check == true)
            {
                this.card3.setBackgroundColor(0xFFFCFBFB);
                card3Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.card4)
        {
            if(card4Check == false && numCardsSelected < 5)
            {
                this.card4.setBackgroundColor(0xFFFFFF4D);
                card4Check = true;
                numCardsSelected++;
            }
            else if(card4Check == true)
            {
                this.card4.setBackgroundColor(0xFFFCFBFB);
                card4Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.card5)
        {
            if(card5Check == false && numCardsSelected < 5)
            {
                this.card5.setBackgroundColor(0xFFFFFF4D);
                card5Check = true;
                numCardsSelected++;
            }
            else if(card5Check == true)
            {
                this.card5.setBackgroundColor(0xFFFCFBFB);
                card5Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.handCard1)
        {
            if(handCard1Check == false && numCardsSelected < 5)
            {
                this.handCard1.setBackgroundColor(0xFFFFFF4D);
                handCard1Check = true;
                numCardsSelected++;
            }
            else if(handCard1Check == true)
            {
                this.handCard1.setBackgroundColor(0xFFFCFBFB);
                handCard1Check = false;
                numCardsSelected--;
            }
        }
        else if(v.getId() == R.id.handCard2)
        {
            if(handCard2Check == false && numCardsSelected < 5)
            {
                this.handCard2.setBackgroundColor(0xFFFFFF4D);
                handCard2Check = true;
                numCardsSelected++;
            }
            else if(handCard2Check == true)
            {
                this.handCard2.setBackgroundColor(0xFFFCFBFB);
                handCard2Check = false;
                numCardsSelected--;
            }
        }


        else if(v.getId() == R.id.foldButton)
        {
            // if the user hits the fold button, both of their cards turn black

            this.userCard1ValueTop.setTextColor(0xFF000000);
            this.userCard1ValueSuit.setTextColor(0xFF000000);
            this.userCard1ValueBottom.setTextColor(0xFF000000);
            this.userCard2ValueTop.setTextColor(0xFF000000);
            this.userCard2ValueSuit.setTextColor(0xFF000000);
            this.userCard2ValueBottom.setTextColor(0xFF000000);
            this.handCard1.setBackgroundColor(0xFF000000);
            this.handCard2.setBackgroundColor(0xFF000000);
        }

        Log.i("Num of selected cards", "" + numCardsSelected);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        betTextView.setText("" + progress * 10);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {
        //not used
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {
        //not used
    }


}
