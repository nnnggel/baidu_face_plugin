#import "BaiduFacePlugin.h"
#if __has_include(<baidu_face_plugin/baidu_face_plugin-Swift.h>)
#import <baidu_face_plugin/baidu_face_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "baidu_face_plugin-Swift.h"
#endif

@implementation BaiduFacePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftBaiduFacePlugin registerWithRegistrar:registrar];
}
@end
