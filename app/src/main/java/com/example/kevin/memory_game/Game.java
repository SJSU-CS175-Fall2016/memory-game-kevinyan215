package com.example.kevin.memory_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private int clickCounter;
    private int picID1;
    private int picID2;
    private int points;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Log.d("lifecycle", "onCreate");
        clickCounter = 0;

        checkVisibility();
        displayPoints();

    }


    /*
    @Override
    public void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        state.putInt("points", points);
        //state.putAll(persistant);
        Log.d("lifecycle", "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle state){
        super.onRestoreInstanceState(state);
        Log.d("lifecycle", "onRestoreInstanceState");

        //points = state.getInt("points");
        Toast.makeText(this, state.getInt("points") + "", Toast.LENGTH_LONG).show();
        displayPoints();
    }
    */

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("lifecycle", "onStart");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("lifecycle", "onPause");

        saveVisibilityAndPoints();
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.d("lifecycle", "onStop");;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("lifecycle", "onDestroy");;

    }



    public void flipImage(View view){
        clickCounter++;
        ImageButton image = new ImageButton(this);


        if(clickCounter == 1){
            picID1 = view.getId();
        }
        else{
            picID2 = view.getId();
        }

        switch(view.getId()){
            case R.id.imageButton1:
                image = (ImageButton) findViewById(R.id.imageButton1);
                image.setImageResource(R.drawable.kobe);
                image.setTag(R.drawable.kobe);
                break;
            case R.id.imageButton2:
                image = (ImageButton) findViewById(R.id.imageButton2);
                image.setImageResource(R.drawable.lebron);
                image.setTag(R.drawable.lebron);
                break;
            case R.id.imageButton3:
                image = (ImageButton) findViewById(R.id.imageButton3);
                image.setImageResource(R.drawable.jordan);
                image.setTag(R.drawable.jordan);
                break;
            case R.id.imageButton4:
                image = (ImageButton) findViewById(R.id.imageButton4);
                image.setImageResource(R.drawable.curry);
                image.setTag(R.drawable.curry);
                break;
            case R.id.imageButton5:
                image = (ImageButton) findViewById(R.id.imageButton5);
                image.setImageResource(R.drawable.kobe);
                image.setTag(R.drawable.kobe);
                break;
            case R.id.imageButton6:
                image = (ImageButton) findViewById(R.id.imageButton6);
                image.setImageResource(R.drawable.magic);
                image.setTag(R.drawable.magic);
                break;
            case R.id.imageButton7:
                image = (ImageButton) findViewById(R.id.imageButton7);
                image.setImageResource(R.drawable.ellis);
                image.setTag(R.drawable.ellis);
                break;
            case R.id.imageButton8:
                image = (ImageButton) findViewById(R.id.imageButton8);
                image.setImageResource(R.drawable.lebron);
                image.setTag(R.drawable.lebron);
                break;
            case R.id.imageButton9:
                image = (ImageButton) findViewById(R.id.imageButton9);
                image.setImageResource(R.drawable.ellis);
                image.setTag(R.drawable.ellis);
                break;
            case R.id.imageButton10:
                image = (ImageButton) findViewById(R.id.imageButton10);
                image.setImageResource(R.drawable.jordan);
                image.setTag(R.drawable.jordan);
                break;
            case R.id.imageButton11:
                image = (ImageButton) findViewById(R.id.imageButton11);
                image.setImageResource(R.drawable.curry);
                image.setTag(R.drawable.curry);
                break;
            case R.id.imageButton12:
                image = (ImageButton) findViewById(R.id.imageButton12);
                image.setImageResource(R.drawable.magic);
                image.setTag(R.drawable.magic);
                break;
            case R.id.imageButton13:
                image = (ImageButton) findViewById(R.id.imageButton13);
                image.setImageResource(R.drawable.iverson);
                image.setTag(R.drawable.iverson);
                break;
            case R.id.imageButton14:
                image = (ImageButton) findViewById(R.id.imageButton14);
                image.setImageResource(R.drawable.draymond);
                image.setTag(R.drawable.draymond);
                break;
            case R.id.imageButton15:
                image = (ImageButton) findViewById(R.id.imageButton15);
                image.setImageResource(R.drawable.draymond);
                image.setTag(R.drawable.draymond);
                break;
            case R.id.imageButton16:
                image = (ImageButton) findViewById(R.id.imageButton16);
                image.setImageResource(R.drawable.yao);
                image.setTag(R.drawable.yao);
                break;
            case R.id.imageButton17:
                image = (ImageButton) findViewById(R.id.imageButton17);
                image.setImageResource(R.drawable.nash);
                image.setTag(R.drawable.nash);
                break;
            case R.id.imageButton18:
                image = (ImageButton) findViewById(R.id.imageButton18);
                image.setImageResource(R.drawable.iverson);
                image.setTag(R.drawable.iverson);
                break;
            case R.id.imageButton19:
                image = (ImageButton) findViewById(R.id.imageButton19);
                image.setImageResource(R.drawable.nash);
                image.setTag(R.drawable.nash);
                break;
            case R.id.imageButton20:
                image = (ImageButton) findViewById(R.id.imageButton20);
                image.setImageResource(R.drawable.yao);
                image.setTag(R.drawable.yao);
                break;


        }
        image.setEnabled(false);

        if(clickCounter == 2){
            checkPictures();
        }

    }

    public void checkPictures(){

        final ImageButton origImage1 = (ImageButton) findViewById(R.id.imageButton1);
        final ImageButton origImage2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton origImage3 = (ImageButton) findViewById(R.id.imageButton3);
        final ImageButton origImage4 = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton origImage5 = (ImageButton) findViewById(R.id.imageButton5);
        final ImageButton origImage6 = (ImageButton) findViewById(R.id.imageButton6);
        final ImageButton origImage7 = (ImageButton) findViewById(R.id.imageButton7);
        final ImageButton origImage8 = (ImageButton) findViewById(R.id.imageButton8);
        final ImageButton origImage9 = (ImageButton) findViewById(R.id.imageButton9);
        final ImageButton origImage10 = (ImageButton) findViewById(R.id.imageButton10);
        final ImageButton origImage11 = (ImageButton) findViewById(R.id.imageButton11);
        final ImageButton origImage12 = (ImageButton) findViewById(R.id.imageButton12);
        final ImageButton origImage13 = (ImageButton) findViewById(R.id.imageButton13);
        final ImageButton origImage14 = (ImageButton) findViewById(R.id.imageButton14);
        final ImageButton origImage15 = (ImageButton) findViewById(R.id.imageButton15);
        final ImageButton origImage16 = (ImageButton) findViewById(R.id.imageButton16);
        final ImageButton origImage17 = (ImageButton) findViewById(R.id.imageButton17);
        final ImageButton origImage18 = (ImageButton) findViewById(R.id.imageButton18);
        final ImageButton origImage19 = (ImageButton) findViewById(R.id.imageButton19);
        final ImageButton origImage20 = (ImageButton) findViewById(R.id.imageButton20);

        origImage1.setEnabled(false);
        origImage2.setEnabled(false);
        origImage3.setEnabled(false);
        origImage4.setEnabled(false);
        origImage5.setEnabled(false);
        origImage6.setEnabled(false);
        origImage7.setEnabled(false);
        origImage8.setEnabled(false);
        origImage9.setEnabled(false);
        origImage10.setEnabled(false);
        origImage11.setEnabled(false);
        origImage12.setEnabled(false);
        origImage13.setEnabled(false);
        origImage14.setEnabled(false);
        origImage15.setEnabled(false);
        origImage16.setEnabled(false);
        origImage17.setEnabled(false);
        origImage18.setEnabled(false);
        origImage19.setEnabled(false);
        origImage20.setEnabled(false);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                //finish();
                //startActivity(getIntent());
                ImageButton image1 = (ImageButton) findViewById(picID1);
                ImageButton image2 = (ImageButton) findViewById(picID2);


                if(image1.getTag().equals(image2.getTag()) ){

                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.INVISIBLE);

                    points++;
                    displayPoints();
                }
                else {

                    image1.setImageResource(R.drawable.basketball);
                    image2.setImageResource(R.drawable.basketball);
                }

                origImage1.setEnabled(true);
                origImage2.setEnabled(true);
                origImage3.setEnabled(true);
                origImage4.setEnabled(true);
                origImage5.setEnabled(true);
                origImage6.setEnabled(true);
                origImage7.setEnabled(true);
                origImage8.setEnabled(true);
                origImage9.setEnabled(true);
                origImage10.setEnabled(true);
                origImage11.setEnabled(true);
                origImage12.setEnabled(true);
                origImage13.setEnabled(true);
                origImage14.setEnabled(true);
                origImage15.setEnabled(true);
                origImage16.setEnabled(true);
                origImage17.setEnabled(true);
                origImage18.setEnabled(true);
                origImage19.setEnabled(true);
                origImage20.setEnabled(true);

            }
        }, 1000);
        clickCounter = 0;
    }

    public void displayPoints(){
        TextView pointsText = (TextView) findViewById(R.id.points);
        pointsText.setText("Points: " + points );
    }

    public void reset(View view){
        SharedPreferences prefs = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();

        prefsEditor.clear();
        prefsEditor.apply();



        /*
        recreate();




        points = prefs.getInt("points", 0);

        Toast.makeText(this,"hello", Toast.LENGTH_LONG).show();

        clickCounter = 0;


        ImageButton origImage1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton origImage2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton origImage3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton origImage4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton origImage5 = (ImageButton) findViewById(R.id.imageButton5);


        if(prefs.getInt("origImage1", View.VISIBLE) == View.VISIBLE){
            origImage1.setVisibility(View.VISIBLE);
        }
        else{
            origImage1.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage5", View.VISIBLE) == View.VISIBLE){
            origImage5.setVisibility(View.VISIBLE);
        }
        else{
            origImage5.setVisibility(View.INVISIBLE);
        }

        displayPoints();

        */
    }

    public void checkVisibility(){

        SharedPreferences prefs = getSharedPreferences("preferences", MODE_PRIVATE);
        points = prefs.getInt("points", 0);


        ImageButton origImage1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton origImage2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton origImage3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton origImage4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton origImage5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton origImage6 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton origImage7 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton origImage8 = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton origImage9 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton origImage10 = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton origImage11 = (ImageButton) findViewById(R.id.imageButton11);
        ImageButton origImage12 = (ImageButton) findViewById(R.id.imageButton12);
        ImageButton origImage13 = (ImageButton) findViewById(R.id.imageButton13);
        ImageButton origImage14 = (ImageButton) findViewById(R.id.imageButton14);
        ImageButton origImage15 = (ImageButton) findViewById(R.id.imageButton15);
        ImageButton origImage16 = (ImageButton) findViewById(R.id.imageButton16);
        ImageButton origImage17 = (ImageButton) findViewById(R.id.imageButton17);
        ImageButton origImage18 = (ImageButton) findViewById(R.id.imageButton18);
        ImageButton origImage19 = (ImageButton) findViewById(R.id.imageButton19);
        ImageButton origImage20 = (ImageButton) findViewById(R.id.imageButton20);

        if(prefs.getInt("origImage1", View.VISIBLE) == View.VISIBLE){
            origImage1.setVisibility(View.VISIBLE);
        }
        else{
            origImage1.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage2", View.VISIBLE) == View.VISIBLE){
            origImage2.setVisibility(View.VISIBLE);
        }
        else{
            origImage2.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage3", View.VISIBLE) == View.VISIBLE){
            origImage3.setVisibility(View.VISIBLE);
        }
        else{
            origImage3.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage4", View.VISIBLE) == View.VISIBLE){
            origImage4.setVisibility(View.VISIBLE);
        }
        else{
            origImage4.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage5", View.VISIBLE) == View.VISIBLE){
            origImage5.setVisibility(View.VISIBLE);
        }
        else{
            origImage5.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage6", View.VISIBLE) == View.VISIBLE){
            origImage6.setVisibility(View.VISIBLE);
        }
        else{
            origImage6.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage7", View.VISIBLE) == View.VISIBLE){
            origImage7.setVisibility(View.VISIBLE);
        }
        else{
            origImage7.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage8", View.VISIBLE) == View.VISIBLE){
            origImage8.setVisibility(View.VISIBLE);
        }
        else{
            origImage8.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage9", View.VISIBLE) == View.VISIBLE){
            origImage9.setVisibility(View.VISIBLE);
        }
        else{
            origImage9.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage10", View.VISIBLE) == View.VISIBLE){
            origImage10.setVisibility(View.VISIBLE);
        }
        else{
            origImage10.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage11", View.VISIBLE) == View.VISIBLE){
            origImage11.setVisibility(View.VISIBLE);
        }
        else{
            origImage11.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage12", View.VISIBLE) == View.VISIBLE){
            origImage12.setVisibility(View.VISIBLE);
        }
        else{
            origImage12.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage13", View.VISIBLE) == View.VISIBLE){
            origImage13.setVisibility(View.VISIBLE);
        }
        else{
            origImage13.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage14", View.VISIBLE) == View.VISIBLE){
            origImage14.setVisibility(View.VISIBLE);
        }
        else{
            origImage14.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage15", View.VISIBLE) == View.VISIBLE){
            origImage15.setVisibility(View.VISIBLE);
        }
        else{
            origImage15.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage16", View.VISIBLE) == View.VISIBLE){
            origImage16.setVisibility(View.VISIBLE);
        }
        else{
            origImage16.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage17", View.VISIBLE) == View.VISIBLE){
            origImage17.setVisibility(View.VISIBLE);
        }
        else{
            origImage17.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage18", View.VISIBLE) == View.VISIBLE){
            origImage18.setVisibility(View.VISIBLE);
        }
        else{
            origImage18.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage19", View.VISIBLE) == View.VISIBLE){
            origImage19.setVisibility(View.VISIBLE);
        }
        else{
            origImage19.setVisibility(View.INVISIBLE);
        }
        if(prefs.getInt("origImage20", View.VISIBLE) == View.VISIBLE){
            origImage20.setVisibility(View.VISIBLE);
        }
        else{
            origImage20.setVisibility(View.INVISIBLE);
        }
    }

    public void saveVisibilityAndPoints(){

        SharedPreferences prefs = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt("points", points);

        ImageButton origImage1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton origImage2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton origImage3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton origImage4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton origImage5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton origImage6 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton origImage7 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton origImage8 = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton origImage9 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton origImage10 = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton origImage11 = (ImageButton) findViewById(R.id.imageButton11);
        ImageButton origImage12 = (ImageButton) findViewById(R.id.imageButton12);
        ImageButton origImage13 = (ImageButton) findViewById(R.id.imageButton13);
        ImageButton origImage14 = (ImageButton) findViewById(R.id.imageButton14);
        ImageButton origImage15 = (ImageButton) findViewById(R.id.imageButton15);
        ImageButton origImage16 = (ImageButton) findViewById(R.id.imageButton16);
        ImageButton origImage17 = (ImageButton) findViewById(R.id.imageButton17);
        ImageButton origImage18 = (ImageButton) findViewById(R.id.imageButton18);
        ImageButton origImage19 = (ImageButton) findViewById(R.id.imageButton19);
        ImageButton origImage20 = (ImageButton) findViewById(R.id.imageButton20);

        prefsEditor.putInt("origImage1", origImage1.getVisibility());
        prefsEditor.putInt("origImage2", origImage2.getVisibility());
        prefsEditor.putInt("origImage3", origImage3.getVisibility());
        prefsEditor.putInt("origImage4", origImage4.getVisibility());
        prefsEditor.putInt("origImage5", origImage5.getVisibility());
        prefsEditor.putInt("origImage6", origImage6.getVisibility());
        prefsEditor.putInt("origImage7", origImage7.getVisibility());
        prefsEditor.putInt("origImage8", origImage8.getVisibility());
        prefsEditor.putInt("origImage9", origImage9.getVisibility());
        prefsEditor.putInt("origImage10", origImage10.getVisibility());
        prefsEditor.putInt("origImage11", origImage11.getVisibility());
        prefsEditor.putInt("origImage12", origImage12.getVisibility());
        prefsEditor.putInt("origImage13", origImage13.getVisibility());
        prefsEditor.putInt("origImage14", origImage14.getVisibility());
        prefsEditor.putInt("origImage15", origImage15.getVisibility());
        prefsEditor.putInt("origImage16", origImage16.getVisibility());
        prefsEditor.putInt("origImage17", origImage17.getVisibility());
        prefsEditor.putInt("origImage18", origImage18.getVisibility());
        prefsEditor.putInt("origImage19", origImage19.getVisibility());
        prefsEditor.putInt("origImage20", origImage20.getVisibility());


        prefsEditor.apply();
    }
}
