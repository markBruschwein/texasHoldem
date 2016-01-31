package com.example.markbruschwein.texasholdem;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    protected SeekBar betSeekBar = null;
    protected TextView betTextView = null;
    protected LinearLayout card1 = null;
    protected LinearLayout card2 = null;
    protected boolean card1Check = false;
    protected boolean card2Check = false;
    protected LinearLayout handCard1 = null;
    protected LinearLayout handCard2 = null;
    protected TextView userCard1ValueTop = null;
    protected TextView userCard1ValueSuit = null;
    protected TextView userCard1ValueBottom = null;
    protected TextView userCard2ValueTop = null;
    protected TextView userCard2ValueSuit = null;
    protected TextView userCard2ValueBottom = null;
    protected Button foldButton = null;




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

        card1 = (LinearLayout)findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = (LinearLayout)findViewById(R.id.card2);
        card2.setOnClickListener(this);

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
        if(v.getId() == R.id.card1)
        {
            if(card1Check == false)
            {
                this.card1.setBackgroundColor(0xFFFFFF4D);
                card1Check = true;
            }
            else
            {
                this.card1.setBackgroundColor(0xFFFCFBFB);
                card1Check = false;
            }
        }
        else if(v.getId() == R.id.card2)
        {
            if(card2Check == false)
            {
                this.card2.setBackgroundColor(0xFFFFFF4D);
                card2Check = true;
            }
            else
            {
                this.card2.setBackgroundColor(0xFFFCFBFB);
                card2Check = false;
            }
        }
        else if(v.getId() == R.id.foldButton) {
            this.userCard1ValueTop.setTextColor(0xFF000000);
            this.userCard1ValueSuit.setTextColor(0xFF000000);
            this.userCard1ValueBottom.setTextColor(0xFF000000);
            this.userCard2ValueTop.setTextColor(0xFF000000);
            this.userCard2ValueSuit.setTextColor(0xFF000000);
            this.userCard2ValueBottom.setTextColor(0xFF000000);
            this.handCard1.setBackgroundColor(0xFF000000);
            this.handCard2.setBackgroundColor(0xFF000000);
        }

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
