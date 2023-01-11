package com.example.android1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private TextView anagramTextView;
    private EditText inputEditText;
    private EditText filterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.input_text);
        filterEditText = findViewById(R.id.input_filter);
        anagramTextView = findViewById(R.id.anagram_text);

        inputEditText.addTextChangedListener(this);
        filterEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String anagram = AnagramCreator.calculateAnagram(inputEditText.getText().toString(), filterEditText.getText().toString().trim());
        if (!anagram.isEmpty()) {
            anagramTextView.setTextAppearance(R.style.anagram_text);
            anagramTextView.setText(anagram);
        } else {
            anagramTextView.setTextAppearance(R.style.anagram_text_def);
            anagramTextView.setText(getString(R.string.anagram_text_def));
        }
    }
}