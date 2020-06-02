package com.example.baidu_face_plugin.baidu_face_plugin_example;

import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusEnum;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.example.baidu_face_plugin.baidu_face_plugin.Config;
import com.example.baidu_face_plugin.baidu_face_plugin.FaceSDKResSettings;

import java.util.HashMap;
import java.util.Map;

import io.flutter.app.FlutterApplication;

public class MainApplication extends FlutterApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacePlugin();
    }

    private void initFacePlugin() {
        // 初始化SDK
        FaceSDKManager.getInstance().initialize(this, "baidu-face-plugin-face-android", "idl-license.face-android");

        // 随机动作
        Config.isLivenessRandom = true;
        // 根据需求添加活体动作
        Config.livenessList.clear();
        Config.livenessList.add(LivenessTypeEnum.Eye);
        // TODO test
//        Config.livenessList.add(LivenessTypeEnum.Mouth);
//        Config.livenessList.add(LivenessTypeEnum.HeadUp);
//        Config.livenessList.add(LivenessTypeEnum.HeadDown);
//        Config.livenessList.add(LivenessTypeEnum.HeadLeft);
//        Config.livenessList.add(LivenessTypeEnum.HeadRight);
//        Config.livenessList.add(LivenessTypeEnum.HeadLeftOrRight);

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

        // 初始化资源文件
        initResMap();
    }

    private void initResMap() {
        Map<String, Map<FaceStatusEnum, Integer>> soundMap = new HashMap<>();
        Map<String, Map<FaceStatusEnum, Integer>> tipsMap = new HashMap<>();

        // language 多语言
        Map<FaceStatusEnum, Integer> zhSoundMap = new HashMap<>();
        zhSoundMap.put(FaceStatusEnum.Detect_NoFace, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.detect_face_in);
        zhSoundMap.put(FaceStatusEnum.Detect_FacePointOut, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.detect_face_in);
        zhSoundMap.put(FaceStatusEnum.Liveness_Eye, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_eye);
        zhSoundMap.put(FaceStatusEnum.Liveness_Mouth, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_mouth);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadUp, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_head_up);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadDown, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_head_down);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadLeft, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_head_left);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadRight, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_head_right);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadLeftRight, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.liveness_head_left_right);
        zhSoundMap.put(FaceStatusEnum.Liveness_OK, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.face_good);
        zhSoundMap.put(FaceStatusEnum.OK, com.example.baidu_face_plugin.baidu_face_plugin.R.raw.face_good);
        soundMap.put("zh", zhSoundMap);

        Map<FaceStatusEnum, Integer> zhTipsMap = new HashMap<>();
        zhTipsMap.put(FaceStatusEnum.Detect_NoFace, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_no_face);
        zhTipsMap.put(FaceStatusEnum.Detect_FacePointOut, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_face_in);
        zhTipsMap.put(FaceStatusEnum.Detect_PoorIllumintion, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_low_light);
        zhTipsMap.put(FaceStatusEnum.Detect_ImageBlured, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_keep);
        zhTipsMap.put(FaceStatusEnum.Detect_OccLeftEye, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccRightEye, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccNose, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccMouth, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccLeftContour, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccRightContour, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccChin, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfUpMaxRange, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_head_down);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfDownMaxRange, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_head_up);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfLeftMaxRange, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_head_right);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfRightMaxRange, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_head_left);
        zhTipsMap.put(FaceStatusEnum.Detect_FaceZoomIn, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_zoom_in);
        zhTipsMap.put(FaceStatusEnum.Detect_FaceZoomOut, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_zoom_out);

        zhTipsMap.put(FaceStatusEnum.Liveness_Eye, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_eye);
        zhTipsMap.put(FaceStatusEnum.Liveness_Mouth, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_mouth);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadUp, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_head_up);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadDown, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_head_down);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadLeft, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_head_left);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadRight, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_head_right);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadLeftRight, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_head_left_right);
        zhTipsMap.put(FaceStatusEnum.Liveness_OK, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_good);
        zhTipsMap.put(FaceStatusEnum.OK, com.example.baidu_face_plugin.baidu_face_plugin.R.string.liveness_good);

        zhTipsMap.put(FaceStatusEnum.Error_Timeout, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_timeout);
        zhTipsMap.put(FaceStatusEnum.Error_DetectTimeout, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_timeout);
        zhTipsMap.put(FaceStatusEnum.Error_LivenessTimeout, com.example.baidu_face_plugin.baidu_face_plugin.R.string.detect_timeout);
        tipsMap.put("zh", zhTipsMap);


        FaceSDKResSettings.initResMaps(soundMap, tipsMap);
    }
}
