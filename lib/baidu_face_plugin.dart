import 'dart:async';

import 'package:flutter/services.dart';

class BaiduFacePlugin {
  static const MethodChannel _channel =
      const MethodChannel('com.example.baidu_face_plugin');

  Future<LivenessResult> liveness({language = 'zh'}) async {
    var arguments = Map();
    arguments['language'] = language;
    final Map<dynamic, dynamic> map =
        await _channel.invokeMethod('liveness', arguments);
    return map != null ? new LivenessResult.fromMap(map) : null;
  }

  Future<DetectResult> detect({language = 'zh'}) async {
    var arguments = Map();
    arguments['language'] = language;
    final Map<dynamic, dynamic> map =
        await _channel.invokeMethod('detect', arguments);
    return map != null ? new DetectResult.fromMap(map) : null;
  }
}

class LivenessResult {
  LivenessResult({this.success, this.image});

  factory LivenessResult.fromMap(Map<dynamic, dynamic> map) =>
      new LivenessResult(
        success: map['success'],
        image: map['image'],
      );

  final String success;

  // sucess=true
  final String image;

  @override
  String toString() => 'LivenessResult: $success,$image';
}

class DetectResult {
  DetectResult({this.success, this.image});

  factory DetectResult.fromMap(Map<dynamic, dynamic> map) => new DetectResult(
        success: map['success'],
        image: map['image'],
      );

  final String success;

  // sucess=true
  final String image;

  @override
  String toString() => 'DetectResult: $success,$image';
}
