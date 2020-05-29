/**
 * Copyright (C) 2017 Baidu Inc. All rights reserved.
 */
package com.example.baidu_face_plugin.baidu_face_plugin;

import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * sdk使用Res资源设置功能
 */
public class FaceSDKResSettings {

    // map<language,map<faceStatus,resourceId>>
    private static final Map<String, Map<FaceStatusEnum, Integer>> soundMap = new HashMap<>();
    private static final Map<String, Map<FaceStatusEnum, Integer>> tipsMap = new HashMap<>();

    public static void initResMaps() {

        // TODO language 多语言
        Map<FaceStatusEnum, Integer> zhSoundMap = new HashMap<>();
        zhSoundMap.put(FaceStatusEnum.Detect_NoFace, R.raw.detect_face_in);
        zhSoundMap.put(FaceStatusEnum.Detect_FacePointOut, R.raw.detect_face_in);
        zhSoundMap.put(FaceStatusEnum.Liveness_Eye, R.raw.liveness_eye);
        zhSoundMap.put(FaceStatusEnum.Liveness_Mouth, R.raw.liveness_mouth);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadUp, R.raw.liveness_head_up);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadDown, R.raw.liveness_head_down);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadLeft, R.raw.liveness_head_left);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadRight, R.raw.liveness_head_right);
        zhSoundMap.put(FaceStatusEnum.Liveness_HeadLeftRight, R.raw.liveness_head_left_right);
        zhSoundMap.put(FaceStatusEnum.Liveness_OK, R.raw.face_good);
        zhSoundMap.put(FaceStatusEnum.OK, R.raw.face_good);
        soundMap.put("zh", zhSoundMap);

        Map<FaceStatusEnum, Integer> zhTipsMap = new HashMap<>();
        zhTipsMap.put(FaceStatusEnum.Detect_NoFace, R.string.detect_no_face);
        zhTipsMap.put(FaceStatusEnum.Detect_FacePointOut, R.string.detect_face_in);
        zhTipsMap.put(FaceStatusEnum.Detect_PoorIllumintion, R.string.detect_low_light);
        zhTipsMap.put(FaceStatusEnum.Detect_ImageBlured, R.string.detect_keep);
        zhTipsMap.put(FaceStatusEnum.Detect_OccLeftEye, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccRightEye, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccNose, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccMouth, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccLeftContour, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccRightContour, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_OccChin, R.string.detect_occ_face);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfUpMaxRange, R.string.detect_head_down);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfDownMaxRange, R.string.detect_head_up);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfLeftMaxRange, R.string.detect_head_right);
        zhTipsMap.put(FaceStatusEnum.Detect_PitchOutOfRightMaxRange, R.string.detect_head_left);
        zhTipsMap.put(FaceStatusEnum.Detect_FaceZoomIn, R.string.detect_zoom_in);
        zhTipsMap.put(FaceStatusEnum.Detect_FaceZoomOut, R.string.detect_zoom_out);

        zhTipsMap.put(FaceStatusEnum.Liveness_Eye, R.string.liveness_eye);
        zhTipsMap.put(FaceStatusEnum.Liveness_Mouth, R.string.liveness_mouth);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadUp, R.string.liveness_head_up);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadDown, R.string.liveness_head_down);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadLeft, R.string.liveness_head_left);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadRight, R.string.liveness_head_right);
        zhTipsMap.put(FaceStatusEnum.Liveness_HeadLeftRight, R.string.liveness_head_left_right);
        zhTipsMap.put(FaceStatusEnum.Liveness_OK, R.string.liveness_good);
        zhTipsMap.put(FaceStatusEnum.OK, R.string.liveness_good);

        zhTipsMap.put(FaceStatusEnum.Error_Timeout, R.string.detect_timeout);
        zhTipsMap.put(FaceStatusEnum.Error_DetectTimeout, R.string.detect_timeout);
        zhTipsMap.put(FaceStatusEnum.Error_LivenessTimeout, R.string.detect_timeout);
        tipsMap.put("zh", zhTipsMap);
    }

    public static void changeResLanguage(String language) {
        if (language == null || "".equals(language) || soundMap.get(language) == null || tipsMap.get(language) == null) {
            throw new RuntimeException("language is not supported: " + language);
        }

        for (Map.Entry<FaceStatusEnum, Integer> e : soundMap.get(language).entrySet()) {
            FaceEnvironment.setSoundId(e.getKey(), e.getValue());
        }

        for (Map.Entry<FaceStatusEnum, Integer> e : tipsMap.get(language).entrySet()) {
            FaceEnvironment.setTipsId(e.getKey(), e.getValue());
        }

//        // Sound Res Id
//        FaceEnvironment.setSoundId(FaceStatusEnum.Detect_NoFace, R.raw.detect_face_in);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Detect_FacePointOut, R.raw.detect_face_in);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_Eye, R.raw.liveness_eye);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_Mouth, R.raw.liveness_mouth);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_HeadUp, R.raw.liveness_head_up);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_HeadDown, R.raw.liveness_head_down);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_HeadLeft, R.raw.liveness_head_left);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_HeadRight, R.raw.liveness_head_right);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_HeadLeftRight, R.raw.liveness_head_left_right);
//        FaceEnvironment.setSoundId(FaceStatusEnum.Liveness_OK, R.raw.face_good);
//        FaceEnvironment.setSoundId(FaceStatusEnum.OK, R.raw.face_good);
//
//        // Tips Res Id
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_NoFace, R.string.detect_no_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_FacePointOut, R.string.detect_face_in);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_PoorIllumintion, R.string.detect_low_light);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_ImageBlured, R.string.detect_keep);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccLeftEye, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccRightEye, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccNose, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccMouth, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccLeftContour, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccRightContour, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_OccChin, R.string.detect_occ_face);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_PitchOutOfUpMaxRange, R.string.detect_head_down);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_PitchOutOfDownMaxRange, R.string.detect_head_up);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_PitchOutOfLeftMaxRange, R.string.detect_head_right);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_PitchOutOfRightMaxRange, R.string.detect_head_left);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_FaceZoomIn, R.string.detect_zoom_in);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Detect_FaceZoomOut, R.string.detect_zoom_out);
//
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_Eye, R.string.liveness_eye);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_Mouth, R.string.liveness_mouth);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_HeadUp, R.string.liveness_head_up);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_HeadDown, R.string.liveness_head_down);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_HeadLeft, R.string.liveness_head_left);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_HeadRight, R.string.liveness_head_right);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_HeadLeftRight, R.string.liveness_head_left_right);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Liveness_OK, R.string.liveness_good);
//        FaceEnvironment.setTipsId(FaceStatusEnum.OK, R.string.liveness_good);
//
//        FaceEnvironment.setTipsId(FaceStatusEnum.Error_Timeout, R.string.detect_timeout);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Error_DetectTimeout, R.string.detect_timeout);
//        FaceEnvironment.setTipsId(FaceStatusEnum.Error_LivenessTimeout, R.string.detect_timeout);
    }
}
