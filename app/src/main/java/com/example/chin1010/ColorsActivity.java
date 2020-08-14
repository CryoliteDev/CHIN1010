package com.example.chin1010;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Creates an array list that contains words
        ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the arraylist
        words.add(new Words("Pink", "Fěn - 粉"));
        words.add(new Words("Red", "Hóng - 红"));
        words.add(new Words("Purple", "Zǐsè - 紫色"));
        words.add(new Words("Blue", "Lán sè - 蓝色"));
        words.add(new Words ("Green", "Lǜsè - 绿色"));
        words.add(new Words("Black", "Hēisè - 黑色"));
        words.add(new Words("Grey", "Huīsè - 灰色"));
        words.add(new Words ("Navy", "Hǎijūn - 海军"));
        words.add(new Words("Orange", "Chéngzi - 橙子"));
        words.add(new Words ("Brown", "Zōngsè - 棕色"));

        Wordsadapter adapter = new Wordsadapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }


}
