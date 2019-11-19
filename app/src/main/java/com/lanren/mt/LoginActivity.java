package com.lanren.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.lanren.mt.utils.QuickSharedPreferences;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText mUserName;
    private EditText mPassWord;
    private Button mLogin;
    private EditText mEmail;
    private RadioGroup mSex;
    private String upLoadSex;
    private Switch mIsStudent;
    private Context mContext;
    private RadioButton mMan;
    private RadioButton mWoman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        initView();
    }

    private void initView() {
//        --------------------  找控件  -----------------------
        mUserName = findViewById(R.id.lanren_et_username);
        mPassWord = findViewById(R.id.lanren_et_password);
        mLogin = findViewById(R.id.lanren_et_login);

        mEmail = findViewById(R.id.lanren_et_email);
        setEditTextInhibitInputSpaChat(mEmail);

        mSex = findViewById(R.id.lanren_rg_sex);
        mMan = findViewById(R.id.lanren_rb_man);
        mWoman = findViewById(R.id.lanren_rb_woman);
        if (QuickSharedPreferences.getSex(mContext).equals("男")){
            mMan.setChecked(true);
        }else {
            mWoman.setChecked(true);
        }

        mSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.lanren_rb_man:
                        upLoadSex = "男";
                        QuickSharedPreferences.setSex(mContext,upLoadSex);
                        break;
                    case R.id.lanren_rb_woman:
                        upLoadSex = "女";
                        QuickSharedPreferences.setSex(mContext, upLoadSex);
                        break;
                    default:
                        break;
                }
            }
        });

        mIsStudent = findViewById(R.id.lanren_sw_isstudent);
        mIsStudent.setChecked(QuickSharedPreferences.getIsStudent(mContext));
        mIsStudent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsStudent.setChecked(isChecked);
                QuickSharedPreferences.setIsStudent(mContext,isChecked);
            }
        });

//        --------------------  设置点击事件  -----------------------
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框中的内容
                String username = mUserName.getText().toString();
                String password = mPassWord.getText().toString();

                //判断内容是否是空,如果是空的,提示不能为空,不是空的,再往下走
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    if (TextUtils.isEmpty(password)){
                        Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    }else {
                        if (username.equals("lanren") && password.equals("666")){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginActivity.this,"账号密码不匹配",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                Log.i(TAG,"用户的性别是： " + QuickSharedPreferences.getSex(mContext) + "  用户是不是学生？ " + (QuickSharedPreferences.getIsStudent(mContext) ? "是" : "不是"));
            }
        });

    }


    /**
     * 输入框限制
     * @param editText
     */
    public  void setEditTextInhibitInputSpaChat(final EditText editText) {
        InputFilter filter_limit = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (editText.getText().toString().length() < 12) {
                    String limitStr = "[0-9A-Za-z@.]";
                    Pattern pattern = Pattern.compile(limitStr);
                    Matcher matcher = pattern.matcher(source.toString());
                    if (matcher.matches()) {
                        return null;
                    } else {
                        Toast.makeText(LoginActivity.this, "不合法输入", Toast.LENGTH_SHORT).show();
                        return "";
                    }
                }else {
                    Toast.makeText(LoginActivity.this,"超过规定长度",Toast.LENGTH_SHORT).show();
                    return "";
                }
            }
            };
        editText.setFilters(new InputFilter[]{filter_limit});
    }
}
