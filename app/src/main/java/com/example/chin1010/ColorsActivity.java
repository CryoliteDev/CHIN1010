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
        words.add(new Words("Red", "Hóng - 红", R.drawable.color_red));
        words.add(new Words("Mustard Yellow", "Jièmò huángsè - 芥末黄色",  R.drawable.color_mustard_yellow));
        words.add(new Words("Dusty Yellow", "Chéntǔ fēiyáng de huángsè - \n 尘土飞扬的黄色", R.drawable.color_dusty_yellow));
        words.add(new Words ("Green", "Lǜsè - 绿色", R.drawable.color_green));
        words.add(new Words ("Brown", "Zōngsè - 棕色", R.drawable.color_brown));
        words.add(new Words("Gray", "Huīsè - 灰色", R.drawable.color_gray));
        words.add(new Words("Black", "Hēisè - 黑色", R.drawable.color_black));
        words.add(new Words("White", "Báisè - 白色", R.drawable.color_white));



        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }


}
