package com.example.baidu_face_plugin.baidu_face_plugin;

import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;

import io.flutter.app.FlutterApplication;

public class MainApplication extends FlutterApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        setFaceConfig();
    }

    private void setFaceConfig() {
        // 随机动作
        Config.isLivenessRandom = true;

        // 根据需求添加活体动作
        Config.livenessList.clear();
        Config.livenessList.add(LivenessTypeEnum.Eye);
        // FIXME test
//        Config.livenessList.add(LivenessTypeEnum.Mouth);
//        Config.livenessList.add(LivenessTypeEnum.HeadUp);
//        Config.livenessList.add(LivenessTypeEnum.HeadDown);
//        Config.livenessList.add(LivenessTypeEnum.HeadLeft);
//        Config.livenessList.add(LivenessTypeEnum.HeadRight);
//        Config.livenessList.add(LivenessTypeEnum.HeadLeftOrRight);

        // 初始化SDK
        FaceSDKManager.getInstance().initialize(this, Config.licenseID, Config.licenseFileName);

        // 设置 FaceConfig
        FaceConfig config = FaceSDKManager.getInstance().getFaceConfig();
        config.setLivenessTypeList(Config.livenessList);
        config.setLivenessRandom(Config.isLivenessRandom);
        config.setBlurnessValue(FaceEnvironment.VALUE_BLURNESS);
        config.setBrightnessValue(FaceEnvironment.VALUE_BRIGHTNESS);
        config.setCropFaceValue(FaceEnvironment.VALUE_CROP_FACE_SIZE);
        config.setHeadPitchValue(FaceEnvironment.VALUE_HEAD_PITCH);
        config.setHeadRollValue(FaceEnvironment.VALUE_HEAD_ROLL);
        config.setHeadYawValue(FaceEnvironment.VALUE_HEAD_YAW);
        config.setMinFaceSize(FaceEnvironment.VALUE_MIN_FACE_SIZE);
        config.setNotFaceValue(FaceEnvironment.VALUE_NOT_FACE_THRESHOLD);
        config.setOcclusionValue(FaceEnvironment.VALUE_OCCLUSION);
        config.setCheckFaceQuality(true);
        config.setFaceDecodeNumberOfThreads(2);

        // 关闭提示音
        config.setSound(false);

        FaceSDKManager.getInstance().setFaceConfig(config);

        // 初始化提示音和提示字符（多语言）
        FaceSDKResSettings.initResMaps();
    }
}
