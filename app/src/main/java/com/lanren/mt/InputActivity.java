package com.lanren.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;

public class InputActivity extends AppCompatActivity {

    private TextFieldBoxes mFileBox;
    private ExtendedEditText mEdit;
    private TextFieldBoxes mFileBox2;
    private ExtendedEditText mEdit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initView();
    }

    private void initView() {
        mFileBox = findViewById(R.id.text_field_boxes);
        mEdit = findViewById(R.id.extended_edit_text);
        mFileBox2 = findViewById(R.id.text_field_boxes2);
        mEdit2 = findViewById(R.id.extended_edit_text2);

        mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    mFileBox.setBackground(getResources().getDrawable(R.drawable.shape2));
                }else {
                    mFileBox.setBackground(getResources().getDrawable(R.drawable.shape1));
                }
            }
        });

        mEdit2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    mFileBox2.setBackground(getResources().getDrawable(R.drawable.shape2));
                }else {
                    mFileBox.setBackground(getResources().getDrawable(R.drawable.shape1));
                }
            }
        });
    }
}