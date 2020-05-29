package com.example.baidu_face_plugin.baidu_face_plugin;


import com.baidu.idl.face.platform.LivenessTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public static String licenseID = "baidu-face-plugin-face-android";
    public static String licenseFileName = "idl-license.face-android";

    public static List<LivenessTypeEnum> livenessList = new ArrayList<>();
    public static boolean isLivenessRandom = false;
}