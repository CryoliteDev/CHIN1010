package com.example.chin1010;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Creates an array list that contains words
        ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the arraylist
        words.add(new Words("ONE", "Yi - 一"));
        words.add(new Words("TWO", "Er - 二"));
        words.add(new Words("THREE", "San - 三"));
        words.add(new Words("FOUR", "Si - 四"));
        words.add(new Words ("FIVE", "Wu - 五"));
        words.add(new Words("SIX", "Liu - 六"));
        words.add(new Words("SEVEN", "Qi - 七"));
        words.add(new Words ("EIGHT", "Ba - 八"));
        words.add(new Words("NINE", "Jiu - 九"));
        words.add(new Words ("TEN", "Shi - 十"));

        Wordsadapter adapter = new Wordsadapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
