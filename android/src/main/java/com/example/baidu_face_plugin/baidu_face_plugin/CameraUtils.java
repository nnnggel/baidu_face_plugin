/**
 * Copyright (C) 2017 Baidu Inc. All rights reserved.
 */
package com.example.baidu_face_plugin.baidu_face_plugin;

import android.hardware.Camera;

/**
 * CameraUtils
 */
public class CameraUtils {

    public static final String TAG = CameraUtils.class.getSimpleName();

    public static void releaseCamera(Camera camera) {
        try {
            camera.release();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
        }
    }
}
