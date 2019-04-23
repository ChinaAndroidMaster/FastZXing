package com.alan.Zxing.Demo;


public class FastZXing {

    private static FastZXing instance;

    public   CaptureActivity.ResultCallBack sResultCallBack;

    public  void setResultCallBack(CaptureActivity.ResultCallBack resultCallBack) {
        sResultCallBack = resultCallBack;
    }

    public static FastZXing getInstance(){
        synchronized (FastZXing.class){
            if(instance == null){
                instance = new FastZXing();
            }
        }
        return instance;
    }
}
