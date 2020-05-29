import 'dart:async';

import 'package:baidu_face_plugin/baidu_face_plugin.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

Future<void> main() async {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: const Text('Plugin example app'),
          ),
          body: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              RaisedButton(
                  child: Text("打开liveness"),
                  onPressed: () {
                    _liveness();
                  }),
              RaisedButton(
                  child: Text("打开detect"),
                  onPressed: () {
                    _detect();
                  }),
            ],
          )),
    );
  }

  _liveness() async {
    LivenessResult result = await new BaiduFacePlugin().liveness();

    debugPrint('LivenessResult: $result');
    Fluttertoast.showToast(msg: result.toString(), timeInSecForIosWeb: 4);

    // setState
  }

  _detect() async {
    DetectResult result = await new BaiduFacePlugin().detect();

    debugPrint('DetectResult: $result');
    Fluttertoast.showToast(msg: result.toString(), timeInSecForIosWeb: 4);

    // setState
  }
}
