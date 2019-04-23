# FastZXing
A custom ZXing qr code scanning, faster and more applicable

[![](https://jitpack.io/v/sunnydlee/FastZXing.svg)](https://jitpack.io/#sunnydlee/FastZXing)

  ![效果图](https://github.com/sunnydlee/FastZXing/blob/master/device-2019-04-22-164719.png)

 ### gradle
 Add it in your root build.gradle at the end of repositories:
 
  ```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
  ```
  
  Add the dependency:
  ```
  	dependencies {
	        implementation 'com.github.sunnydlee:FastZXing:1.0.0'
	}
  ```

快速接入方式：
 ```
        //打开扫描页
        Intent intent = new Intent(this, FastCaptureActivity.class);
        startActivity(intent);
        //设置扫描结果回调
        FastZXing.getInstance().setResultCallBack(new CaptureActivity.ResultCallBack() {
            @Override
            public void decodeResult(String result, CaptureActivity activity) {
                if (activity != null) {
                    activity.restartCameraScan();//重新开启扫描,连续扫描
                }
            }

        });
 ```
