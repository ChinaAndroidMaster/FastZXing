package com.sunnydlee.fastdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alan.Zxing.Demo.CaptureActivity;
import com.alan.Zxing.Demo.FastCaptureActivity;
import com.alan.Zxing.Demo.FastZXing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void skipToFastZXing(View view) {
        //打开扫描页
        Intent intent = new Intent(this, FastCaptureActivity.class);
        startActivity(intent);

//        设置扫描结果回调
        FastZXing.getInstance().setResultCallBack(new CaptureActivity.ResultCallBack() {
            @Override
            public void decodeResult(String result, CaptureActivity activity) {
                if (activity != null) {
                    activity.restartCameraScan();//重新开启扫描,连续扫描
                }
            }

        });
    }
}
