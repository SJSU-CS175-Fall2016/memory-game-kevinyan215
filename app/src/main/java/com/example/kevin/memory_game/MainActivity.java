package com.example.kevin.memory_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("lifecycle", "MainActivity onCreate");
        setContentView(R.layout.activity_main);


    }

    public void playGame(View view) {
        //intent call Game
        Intent playGameIntent = new Intent(this,Game.class);
        startActivity(playGameIntent);
    }

    public void rulesOnClick(View view){
        //intent  call Rules
        Intent rulesIntent = new Intent(this, Rules.class);
        startActivity(rulesIntent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.d("lifecycle", "MainActivity onDestroy");

        SharedPreferences prefs = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.clear();
        prefsEditor.apply();

    }
}
