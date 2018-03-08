package com.dh.questionanswer;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.dh.questionanswer.Fragment.IntroduceFragment;
import com.dh.questionanswer.Fragment.StartFragment;

/**
 *启动界面,不同情况调用不同Fragment
 */
public class StartActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide the status bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hide the title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        if(isFirstStart()){//第一次启动
            replaceFragment(new IntroduceFragment());
        }else {
            replaceFragment(new StartFragment());
        }


    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_layout,fragment);
        transaction.commit();
    }

    //使用SharedPreferences判断APP是否是第一次启动
    public Boolean isFirstStart(){
        SharedPreferences preferences=
                getSharedPreferences("QuestionAnswerSharedPreferences",MODE_PRIVATE);
        Boolean isFirst=preferences.getBoolean("isFirst",true);
        if(isFirst){//第一次启动
            preferences.edit().putBoolean("isFirst",false).apply();
            return true;
        }else{
            return false;
        }

    }
}


