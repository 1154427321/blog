import 'package:blog/common/index.dart';
import 'package:flutter_native_splash/flutter_native_splash.dart';
import 'package:get/get.dart';

class SplashController extends GetxController {
  SplashController();

  void onTap() {}

  _jumpToPage() {

    //加载时缓冲一秒
    Future.delayed(const Duration(seconds: 1), () {
      ConfigService.inject.isAlreadyOpen
          ?Get.offAllNamed(RouteNames.main)
          :Get.offAllNamed(RouteNames.systemWelcome);
    });

  }

  @override
  void onReady() {
    super.onReady();
    // 删除设备启动图
    FlutterNativeSplash.remove();
    // 跳转界面
    _jumpToPage();
  }

  // @override
  // void onClose() {
  //   super.onClose();
  // }
}
