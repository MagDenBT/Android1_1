package com.example.android1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    private TextView anagramTextView;
    private EditText inputEditText;
    private EditText filterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = (EditText) findViewById(R.id.input_text);
        filterEditText = (EditText) findViewById(R.id.input_filter);

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText filterEditText = (EditText) findViewById(R.id.input_filter);
                anagramTextView.setText(AnagramCreator.calculateAnagram(inputEditText.getText().toString(), filterEditText.getText().toString().trim()));;
            }
        };
        inputEditText.addTextChangedListener(tw);
        filterEditText.addTextChangedListener(tw);

        anagramTextView = (TextView) findViewById(R.id.anagram_text);
        anagramTextView.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String textDef = getString(R.string.anagram_text_def);
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