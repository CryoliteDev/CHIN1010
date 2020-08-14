package com.example.chin1010;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Creates an array list that contains words
        ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the arraylist
        words.add(new Words("Father", "Fùqīn - 父亲"));
        words.add(new Words("Mom", "Māmā - 妈妈"));
        words.add(new Words("Son", "Érzi - "));
        words.add(new Words("Daughter", "Nǚ'ér - 女儿"));
        words.add(new Words ("Brother", "Gēgē - 哥哥"));
        words.add(new Words("Sister", "Mèimei - 妹妹"));
        words.add(new Words("Grandfather", "Zǔfù - 祖父"));
        words.add(new Words ("Grandmother", "Zǔmǔ - 祖母"));
        words.add(new Words("Uncle", "Shūshu - 叔叔"));
        words.add(new Words ("Aunt", "Gūmā - 姑妈"));

        Wordsadapter adapter = new Wordsadapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
