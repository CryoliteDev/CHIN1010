package com.example.chin1010;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class Wordsadapter extends ArrayAdapter<Words> {
    public Wordsadapter(Context context, ArrayList<Words> words) {
        super(context,0, words);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent,false);
        }

        Words currentWord = getItem(position);

        //chinese text view in list_item.xml
        TextView chinTextView = (TextView) listItemView.findViewById(R.id.chinese_text_view);
        chinTextView.setText(currentWord.getChineseTranslation());
        //default_text_view in list_item.xml
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
