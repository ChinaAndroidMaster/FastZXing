package com.alan.Zxing.Demo;

import android.os.Bundle;

public class FastCaptureActivity  extends CaptureActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
