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
        words.add(new Words("ONE", "Yi - 一", R.drawable.number_one));
        words.add(new Words("TWO", "Er - 二", R.drawable.number_two));
        words.add(new Words("THREE", "San - 三", R.drawable.number_three));
        words.add(new Words("FOUR", "Si - 四", R.drawable.number_four));
        words.add(new Words ("FIVE", "Wu - 五", R.drawable.number_five));
        words.add(new Words("SIX", "Liu - 六", R.drawable.number_six));
        words.add(new Words("SEVEN", "Qi - 七", R.drawable.number_seven));
        words.add(new Words ("EIGHT", "Ba - 八", R.drawable.number_eight));
        words.add(new Words("NINE", "Jiu - 九", R.drawable.number_nine));
        words.add(new Words ("TEN", "Shi - 十", R.drawable.number_ten));

        Wordsadapter adapter = new Wordsadapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
