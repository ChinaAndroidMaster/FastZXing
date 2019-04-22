package com.alan.Zxing.Demo;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class FastCaptureActivity  extends CaptureActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }


    private void init(){
        //关闭相册
        setAlbumVisibility(View.GONE);
        //自定义扫描框大小
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        int drawWidth = screenWidth * 8/10;
        int drawHeight = screenWidth * 3/10;
        int realWidth = screenWidth * 9/10;
        int realHeight = screenWidth * 3/10;
        setScanRectWidthHeight(drawWidth,drawHeight,realWidth,realHeight,true);
        //设置扫描结果回调
        setResultCallBack(new ResultCallBack() {
            @Override
            public void decodeResult(String result) {
//                restartCameraScan();//重新开启扫描
            }
        });
    }


    /**
     * 设置中间屏幕提示
     */
    public void setCenterHint(String text){
        tvCenterHint.setText(text);
    }


    /**
     * 闪关灯-是否显示
     */
    public void setFlashlightVisibility(int visibility){
        mLightText.setVisibility(visibility);
        mSwitchLight.setVisibility(visibility);
    }

    /**
     * 相册-是否显示
     * @param visibility
     */
    public void setAlbumVisibility(int visibility){
        mAlbum.setVisibility(visibility);
    }
}
