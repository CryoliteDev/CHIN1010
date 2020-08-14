package com.example.chin1010;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Intent for the colors page
         */
        TextView colors = (TextView) findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colIntent);
            }
        });

        /**
         * Intent for the family page
         */
        TextView family = (TextView) findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent famIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(famIntent);
            }
        });

        /**
         * Intent for the Numbers page
         */
        TextView numbers = (TextView) findViewById(R.id.numbers);

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numIntent);
            }
        });

        /**
         * Intent for the Phrases page
         */
        TextView phrases = (TextView)  findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phraseIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phraseIntent);
            }
        });


    }
}
