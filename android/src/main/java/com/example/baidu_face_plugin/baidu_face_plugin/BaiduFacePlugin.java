package com.example.baidu_face_plugin.baidu_face_plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * BaiduFacePlugin
 */
public class BaiduFacePlugin implements PluginRegistry.ActivityResultListener, MethodCallHandler {

    private static final String CHANNEL = "com.example.baidu_face_plugin";

    private static final int LIVENESS_REQUEST_CODE = 10110;

    private static final int DETECT_REQUEST_CODE = 10111;

    private Activity activity;

    private LivenessCallback livenessCallback;

    private DetectCallback detectCallback;

    private BaiduFacePlugin(Activity activity) {
        this.activity = activity;
    }

    /**
     * Plugin registration.
     */
    public static void registerWith(PluginRegistry.Registrar registrar) {
        System.out.println("====registerWith");
        Log.i("BaiduFacePlugin", "====registerWith");
        final BaiduFacePlugin plugin = new BaiduFacePlugin(registrar.activity());
        final MethodChannel channel = new MethodChannel(registrar.messenger(), CHANNEL);
        channel.setMethodCallHandler(plugin);
        registrar.addActivityResultListener(plugin);
    }


    @Override
    public void onMethodCall(@NonNull final MethodCall call, @NonNull final Result result) {
        if ("liveness".equals(call.method)) {
            livenessCallback = new LivenessCallback(result);
            liveness(call.hasArgument("language") ? call.<String>argument("language") : null);
        } else if ("detect".equals(call.method)) {
            detectCallback = new DetectCallback(result);
            detect(call.hasArgument("language") ? call.<String>argument("language") : null);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("BaiduFacePlugin",
            "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode + ", data=" + data);
        switch (requestCode) {
            case LIVENESS_REQUEST_CODE: {
                if (livenessCallback != null && data != null) {
                    if (data.getBooleanExtra("success", false)) {
                        livenessCallback.sucess(data.getStringExtra("image"));
                    } else {
                        livenessCallback.failed();
                    }
                }
                break;
            }
            case DETECT_REQUEST_CODE: {
                if (detectCallback != null && data != null) {
                    if (data.getBooleanExtra("success", false)) {
                        detectCallback.sucess(data.getStringExtra("image"));
                    } else {
                        detectCallback.failed();
                    }
                }
                break;
            }
            default:
        }
        return false;
    }

    private void detect(String language) {
        Intent intent = new Intent(activity, FaceDetectExpActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("language", (language == null || "".equals(language)) ? "zh" : language);
        intent.putExtras(mBundle);
        activity.startActivityForResult(intent, DETECT_REQUEST_CODE);
    }

    private void liveness(String language) {
        Intent intent = new Intent(activity, FaceLivenessExpActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putString("language", (language == null || "".equals(language)) ? "zh" : language);
        intent.putExtras(mBundle);
        activity.startActivityForResult(intent, LIVENESS_REQUEST_CODE);
    }

    class LivenessCallback {

        private Result result;

        public LivenessCallback(Result result) {
            this.result = result;
        }

        public void sucess(String image) {
            Map<String, String> map = new HashMap<>();
            map.put("success", "true");
            map.put("image", image);
            result.success(map);
        }

        public void failed() {
            Map<String, String> map = new HashMap<>();
            map.put("success", "false");
            result.success(map);
        }

    }

    class DetectCallback {

        private Result result;

        public DetectCallback(Result result) {
            this.result = result;
        }

        public void sucess(String image) {
            Map<String, String> map = new HashMap<>();
            map.put("success", "true");
            map.put("image", image);
            result.success(map);
        }

        public void failed() {
            Map<String, String> map = new HashMap<>();
            map.put("success", "false");
            result.success(map);
        }

    }
}
