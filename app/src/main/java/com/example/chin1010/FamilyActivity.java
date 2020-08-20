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
        words.add(new Words("Father", "Fùqīn - 父亲", R.drawable.family_father));
        words.add(new Words("Mom", "Māmā - 妈妈", R.drawable.family_mother));
        words.add(new Words("Son", "Érzi - ", R.drawable.family_son));
        words.add(new Words("Daughter", "Nǚ'ér - 女儿", R.drawable.family_daughter));
        words.add(new Words ("Brother", "Gēgē - 哥哥", R.drawable.family_older_brother));
        words.add(new Words("Sister", "Mèimei - 妹妹", R.drawable.family_older_sister));
        words.add(new Words("Grandfather", "Zǔfù - 祖父", R.drawable.family_grandfather));
        words.add(new Words ("Grandmother", "Zǔmǔ - 祖母", R.drawable.family_grandmother));

        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
