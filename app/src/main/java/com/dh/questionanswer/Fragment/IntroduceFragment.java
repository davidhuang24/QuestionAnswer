package com.dh.questionanswer.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.dh.questionanswer.LoginActivity;
import com.dh.questionanswer.R;
import com.dh.questionanswer.RegisterActivity;

/**
 * 介绍碎片,用于介绍APP功能特性，第一次启动APP时调用
 */

public class IntroduceFragment extends Fragment implements View.OnClickListener{

    private SliderLayout sliderLayout;
    private Button logupButton;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_introduce,container,false);

        sliderLayout = (SliderLayout) view.findViewById(R.id.slider_layout);
        initSliderLayout();
        logupButton=(Button) sliderLayout.findViewById(R.id.lu_button);
        loginButton=(Button) sliderLayout.findViewById(R.id.li_button);
        logupButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        return view;
    }

    private void initSliderLayout(){


        DefaultSliderView defaultSliderView1= new DefaultSliderView(getContext());
        defaultSliderView1
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .image(R.drawable.bj);
        sliderLayout.addSlider(defaultSliderView1);

        DefaultSliderView defaultSliderView2= new DefaultSliderView(getContext());
        defaultSliderView2
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .image(R.drawable.sh);
        sliderLayout.addSlider(defaultSliderView2);

        DefaultSliderView defaultSliderView3= new DefaultSliderView(getContext());
        defaultSliderView3
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .image(R.drawable.wh);
        sliderLayout.addSlider(defaultSliderView3);

        DefaultSliderView defaultSliderView4= new DefaultSliderView(getContext());
        defaultSliderView4
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .image(R.drawable.hk);
        sliderLayout.addSlider(defaultSliderView4);

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);;//切换动画
        sliderLayout.setDuration(4000);//自动播放停留时间
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){//登录
            case R.id.lu_button:
                RegisterActivity.actionStart(getContext(),"","");
                break;
            case R.id.li_button://注册
                LoginActivity.actionStart(getContext(),"","");
                break;
            default:
        }

    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();//防止内存泄露,在Activity和Fragment销毁前调用
        super.onStop();
    }
}
