package com.wrinth.english_is_easy;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JohnL on 7/6/2016.
 */
public class WordAdapter  extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId) {
        super(context, 0, word);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word currentWord = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.getImageResourceId() != -1) {
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        LinearLayout textLayout = (LinearLayout) listItemView.findViewById(R.id.text_view);
        textLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        miwokTextView.setText(currentWord.getEngliahTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.chinese_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;

    }

}
