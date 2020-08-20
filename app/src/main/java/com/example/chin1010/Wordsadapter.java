package com.example.chin1010;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Wordsadapter extends ArrayAdapter<Words> {

    private int colorID;
    public Wordsadapter(Context context, ArrayList<Words> words, int colorResourceID) {
        super(context,0, words);
        colorID = colorResourceID;
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

        //image_view in list_item.xml
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImgResourceID());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textBox = listItemView.findViewById(R.id.text_box);
        int color = ContextCompat.getColor(getContext(), colorID);
        textBox.setBackgroundColor(color);

        return listItemView;
    }
}
