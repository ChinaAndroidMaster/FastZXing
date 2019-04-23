package com.alan.Zxing.Demo.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * 权限帮助类（6.0-23及以上）
 * Created by Administrator on 2016/11/22 0022.
 */

public class PermissionsChecker {

    private Activity context;
    public static final int PERMISSION_REQUEST_CODE = 701 ;

    public PermissionsChecker(Activity context) {
        this.context = context;
    }

    /**
     * 检查权限是否已请求到 (6.0)
     */
    public void checkPermissions(String... permissions) {
        // 版本兼容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                // 判断缺失哪些必要权限
                && lacksPermissions(permissions)) {
            // 如果缺失,则申请
            requestPermissions(permissions);
        }
    }

    /**
     * 判断是否缺失权限集合中的权限
     */
    private boolean lacksPermissions(String... permissions) {
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否缺少某个权限
     */
    public boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_DENIED;
    }

    /**
     * 请求权限
     */
    private void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(context, permissions, PERMISSION_REQUEST_CODE);
    }

    /**
     * 启动应用的设置,进入手动配置权限页面
     */
    public void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }


    public void goMeizuMainager() {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.putExtra("packageName", context.getPackageName());
            context.startActivity(intent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            localActivityNotFoundException.printStackTrace();
            startAppSettings();
        }
    }

    public static String getMobileType() {
        return Build.MANUFACTURER;
    }


//  <!--  Dangerous Permissions.  -->
    /*// 联系人
    Manifest.permission.WRITE_CONTACTS,
    Manifest.permission.GET_ACCOUNTS,
    Manifest.permission.READ_CONTACTS,

    // 电话
    Manifest.permission.READ_CALL_LOG,
    Manifest.permission.READ_PHONE_STATE,
    Manifest.permission.CALL_PHONE,
    Manifest.permission.WRITE_CALL_LOG,
    Manifest.permission.USE_SIP,
    Manifest.permission.PROCESS_OUTGOING_CALLS,
    Manifest.permission.ADD_VOICEMAIL,

    // 日历
    Manifest.permission.READ_CALENDAR,
    Manifest.permission.WRITE_CALENDAR,

    // 相机
    Manifest.permission.CAMERA,

    // 传感器
    Manifest.permission.BODY_SENSORS,

    // 定位
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION,

    // 存储
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE,

    // 录音
    Manifest.permission.RECORD_AUDIO,

    // 短信
    Manifest.permission.READ_SMS,
    Manifest.permission.RECEIVE_WAP_PUSH,
    Manifest.permission.RECEIVE_MMS,
    Manifest.permission.RECEIVE_SMS,
    Manifest.permission.SEND_SMS,*/

}
