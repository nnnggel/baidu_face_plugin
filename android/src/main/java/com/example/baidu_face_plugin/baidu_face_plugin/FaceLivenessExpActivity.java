package com.example.baidu_face_plugin.baidu_face_plugin;

import android.content.DialogInterface;
import android.os.Bundle;

import com.baidu.idl.face.platform.FaceStatusEnum;

import java.util.HashMap;

public class FaceLivenessExpActivity extends FaceLivenessActivity {

    private DefaultDialog mDefaultDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onLivenessCompletion(FaceStatusEnum status, String message, HashMap<String, String> base64ImageMap) {
        super.onLivenessCompletion(status, message, base64ImageMap);
        if (status == FaceStatusEnum.OK && mIsCompletion) {
            this.getIntent().putExtra("success", true);
            // map中包含所有动作照片，另外会记录一张bestImage0
            this.getIntent().putExtra("image", base64ImageMap.get("bestImage0"));
            this.setResult(10013, this.getIntent());
            finish();
//            showMessageDialog("活体检测", "检测成功");
        } else if (status == FaceStatusEnum.Error_DetectTimeout ||
                status == FaceStatusEnum.Error_LivenessTimeout ||
                status == FaceStatusEnum.Error_Timeout) {
            this.getIntent().putExtra("success", false);
            this.setResult(10013, this.getIntent());
            finish();
//            showMessageDialog("活体检测", "采集超时");
        }
    }

    private void showMessageDialog(String title, String message) {
        if (mDefaultDialog == null) {
            DefaultDialog.Builder builder = new DefaultDialog.Builder(this);
            builder.setTitle(title).
                    setMessage(message).
                    setNegativeButton("确认",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mDefaultDialog.dismiss();
                                    finish();
                                }
                            });
            mDefaultDialog = builder.create();
            mDefaultDialog.setCancelable(true);
        }
        mDefaultDialog.dismiss();
        mDefaultDialog.show();
    }

    @Override
    public void finish() {
        super.finish();
    }

}
