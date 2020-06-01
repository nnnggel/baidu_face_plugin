# baidu_face_plugin

百度人脸识别和活体检测 Flutter 插件（目前版本仅支持 Android）

# 使用方式
## 注册百度开发者账号
前往 [百度开发者账号](https://ai.baidu.com) 进行注册。

## 申请并配置license
1 . 登录 [控制台](https://console.bce.baidu.com/)，前往 全局->人工智能->人脸识别->人脸识别 - 离线采集SDK管理
![avatar](https://raw.githubusercontent.com/nnnggel/baidu_face_plugin/master/doc/license-apply.png)  

2 . 新建授权，填入必须的信息（Android MD5签名配置方式自行 google），将结果配置在实际项目 /example/android/app/build.gradle）  
```
signingConfigs {

        def password = "10101100"
        def alias = "nutella"
        def filePath = "/Users/yuanchongyu/nutella.jks"  //如  ../facesharp.jks//签名文件路径

        debug {
            keyAlias alias
            keyPassword password
            storeFile file(filePath)
            storePassword(password)
        }
        release {
            keyAlias alias
            keyPassword password
            storeFile file(filePath)
            storePassword(password)
        }
    }
```
3 . 下载license放在实际项目中（/example/android/app/src/main/assets/idl-license.face-android）
![avatar](https://raw.githubusercontent.com/nnnggel/baidu_face_plugin/master/doc/license-config.png)

4 . 在实际项目中增加入口 application class（参考 com.example.baidu_face_plugin.baidu_face_plugin_example.MainApplication），在"初始化SDK"的地方配置 License-ID 和 License-File-Name，并修改实际项目 AndroidManifest.xml 的入口 application class（参考 example - AndroidManifest.xml ）
```
<application
    tools:replace="android:label"
    android:name="com.example.baidu_face_plugin.baidu_face_plugin_example.MainApplication"
...
```

> 步骤 2 和 3 中的配置可以在新建完授权后，下载示例项目  
> ![avatar](https://raw.githubusercontent.com/nnnggel/baidu_face_plugin/master/doc/license-demo.png)

## 如何调用
1 . pubspec.yaml 中加入依赖
```
dependencies:
  baidu_face_plugin: ^1.0.0
```

2 . import
```
import 'package:baidu_face_plugin/baidu_face_plugin.dart';
```

3 . call
```
LivenessResult result = await new BaiduFacePlugin().liveness();
DetectResult result = await new BaiduFacePlugin().detect();
```
> result 包含两个属性（sucess和image）  
> success 属性表示是否完成并成功。如果 success == 'true'，则 image 返回最佳人脸照片（base64格式）

## 一些说明
* 入口 application class（com.example.baidu_face_plugin.baidu_face_plugin_example.MainApplication）的作用是初始化和配置插件功能（活体需要哪些动作，是否随机出现；识别的光线、模糊、角度等质量要求；是否开启语音提示等），视实际情况调整。如果你的项目中已经有入口 application class，可以合并。
* UI 样式可以在 com.example.baidu_face_plugin.baidu_face_plugin.FaceDetectRoundView 调整。
* 人脸识别和活体检测 成功后将返回base64格式最佳人脸照片（人脸识别就一张照片，活体检测返回的是多个动作中最佳的一张），调试的时候需要打印完整日志（debug模式或[自行分段](https://stackoverflow.com/questions/49138971/logging-large-strings-from-flutter)）才能获取完整字符串。
* 支持多语言配置（语音和提示文字），加入资源文件（src/main/res）后可在 com.example.baidu_face_plugin.baidu_face_plugin_example.MainApplication 中配置，参考 com.example.baidu_face_plugin.baidu_face_plugin.FaceSDKResSettings。
* 官方示例项目中的依赖关系为 app->faceplatform-ui->faceplatform，集成时发现部分配置需要修改 faceplatform-ui 实现，所以将 faceplatform-ui 的源码拷贝在到了 plugin module 进行调整。

## 官方集成文档
> [安卓-有动作活体版](https://ai.baidu.com/ai-doc/FACE/Mk37c1pue)
