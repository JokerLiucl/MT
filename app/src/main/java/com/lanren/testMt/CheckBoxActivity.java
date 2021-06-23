package com.lanren.testMt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.lanren.mt.R;

import java.util.ArrayList;

public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox checkbox4;
    private CheckBox checkbox5;
    private ArrayList<CheckBox> checkBoxArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        checkbox4 = findViewById(R.id.checkbox4);
        checkbox5 = findViewById(R.id.checkbox5);
        checkbox1.setOnCheckedChangeListener(this);
        checkbox2.setOnCheckedChangeListener(this);
        checkbox3.setOnCheckedChangeListener(this);
        checkbox4.setOnCheckedChangeListener(this);
        checkbox5.setOnCheckedChangeListener(this);
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkbox1:
                if (!isChecked){
                    checkbox1.setChecked(false);
                    checkBoxArrayList.remove(checkbox1);
                }else {
                    if (checkBoxArrayList.size() < 3){
                        checkbox1.setChecked(true);
                        checkBoxArrayList.add(checkbox1);
                    }else {
                        checkbox1.setChecked(false);
                        Toast.makeText(CheckBoxActivity.this,"最多只能选择三个",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.checkbox2:
                if (!isChecked){
                    checkbox2.setChecked(false);
                    checkBoxArrayList.remove(checkbox2);
                }else {
                    if (checkBoxArrayList.size() < 3){
                        checkbox2.setChecked(true);
                        checkBoxArrayList.add(checkbox2);
                    }else {
                        checkbox2.setChecked(false);
                        Toast.makeText(CheckBoxActivity.this,"最多只能选择三个",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.checkbox3:
                if (!isChecked){
                    checkbox3.setChecked(false);
                    checkBoxArrayList.remove(checkbox3);
                }else {
                    if (checkBoxArrayList.size() < 3){
                        checkbox3.setChecked(true);
                        checkBoxArrayList.add(checkbox3);
                    }else {
                        checkbox3.setChecked(false);
                        Toast.makeText(CheckBoxActivity.this,"最多只能选择三个",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.checkbox4:
                if (!isChecked){
                    checkbox4.setChecked(false);
                    checkBoxArrayList.remove(checkbox4);
                }else {
                    if (checkBoxArrayList.size() < 3){
                        checkbox4.setChecked(true);
                        checkBoxArrayList.add(checkbox4);
                    }else {
                        checkbox4.setChecked(false);
                        Toast.makeText(CheckBoxActivity.this,"最多只能选择三个",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.checkbox5:
                if (!isChecked){
                    checkbox5.setChecked(false);
                    checkBoxArrayList.remove(checkbox5);
                }else {
                    if (checkBoxArrayList.size() < 3){
                        checkbox5.setChecked(true);
                        checkBoxArrayList.add(checkbox5);
                    }else {
                        checkbox5.setChecked(false);
                        Toast.makeText(CheckBoxActivity.this,"最多只能选择三个",Toast.LENGTH_SHORT).show();
                    }
                }
                break;

        }
    }
}
