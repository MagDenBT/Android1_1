package com.example.android1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText inputEditText = (EditText) findViewById(R.id.input_text);
        EditText filterEditText = (EditText) findViewById(R.id.input_filter);

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                TextView anagramTextView = (TextView) findViewById(R.id.anagram_text);
                EditText inputEditText = (EditText) findViewById(R.id.input_text);
                EditText filterEditText = (EditText) findViewById(R.id.input_filter);
                String text = inputEditText.getText().toString();
                String anagram = "";
                if (!text.trim().isEmpty()) {
                    anagram = Anagram_creator.getAnagram(text, filterEditText.getText().toString());
                }
                anagramTextView.setText(anagram);
            }
        };
        inputEditText.addTextChangedListener(tw);
        filterEditText.addTextChangedListener(tw);

        TextView anagramTextView = (TextView) findViewById(R.id.anagram_text);
        anagramTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                TextView anagramTextView = (TextView) findViewById(R.id.anagram_text);
                String textDef = anagramTextView.getContext().getString(R.string.anagram_text_def);
                String textNew = editable.toString();
                if (textNew.contentEquals(textDef)) {
                    anagramTextView.setTextAppearance(R.style.anagram_text_def);
                }else if(textNew.trim().isEmpty()) {
                    anagramTextView.setText(textDef);
                    anagramTextView.setTextAppearance(R.style.anagram_text_def);
                }else{
                    anagramTextView.setTextAppearance(R.style.anagram_text);
                }

            }
            }
        );

    }

}