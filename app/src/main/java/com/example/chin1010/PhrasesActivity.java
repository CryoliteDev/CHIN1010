package com.example.chin1010;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity{
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Creates an array list that contains words
        ArrayList<Words> words = new ArrayList<Words>();

        //adds words to the array list
        words.add(new Words("Where are you going?", "Nǐ yào qù nǎlǐ? - 你要去哪里？"));
        words.add(new Words("What is your name?", "Nǐ jiào shénme míngzì? - 你叫什么名字?"));
        words.add(new Words("My name is ...", "Wǒ de míngzì shì.. - 我的名字是 ..."));
        words.add(new Words("How are you feeling?", "Nǐ gǎnjué zěnme yàng? - 你感觉怎么样?"));
        words.add(new Words ("I'm feeling good.", "Wǒ gǎnjué hěn hǎo. - 我感觉很好."));
        words.add(new Words("Are you coming?", "Nǐ lái ma - 你来吗?"));
        words.add(new Words("Where we going?", "Nǐ yào qù nǎlǐ?- 你要去哪里"));
        words.add(new Words ("Yes, I'm coming.", "Shì de, wǒ láile - 是的，我来了 "));
        words.add(new Words("Let's go.", "Wǒmen zǒu ba. - 我们走吧"));
        words.add(new Words ("Come here", "Guòlái. - 过来"));

        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
